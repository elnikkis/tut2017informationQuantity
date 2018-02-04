package s4.t000003; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
import java.lang.*;
import s4.specification.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class InformationEstimator implements InformationEstimatorInterface {
    // Code to tet, *warning: This code condtains intentional problem*
    byte[] myTarget; // data to compute its information quantity
    byte[] mySpace;  // Sample space to compute the probability
    FrequencerInterface myFrequencer;  // Object for counting frequency

    double[][] memo;

    byte[] subBytes(byte[] x, int start, int end) {
        // corresponding to substring of String for  byte[] ,
        // It is not implement in class library because internal structure of byte[] requires copy.
        byte[] result = new byte[end - start];
        for(int i = 0; i<end - start; i++) {
            result[i] = x[start + i];
        }
        return result;
    }

    public static byte[] readBytesFromFile(final String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }

    // IQ: information quantity for a count,  -log2(count/sizeof(space))
    double iq(int freq) {
        return  - Math.log10((double) freq / (double) mySpace.length) / Math.log10((double) 2.0);
    }

    /**
     * Information quantity of subbyte TARGET[start:end]
     *
     * iqs(s) = min()
     * iqs("abc") = min( f("abc"), IQ("a")+f("bc"), IQ("ab")+f("c") )
     *
     * s: TARGET[start:end]
     */
    double iqs(int start, int end) {
        if(end - start <= 0){
            //System.out.printf("[%d:%d]\n", start, end);
            return 0.0;
        }
        //System.out.printf("start: %d, end: %d\n", start, end);
        //System.out.println(memo);
        if(Double.compare(memo[start][end], Double.MAX_VALUE) != 0){
            return memo[start][end];
        }

        double value = Double.MAX_VALUE;
        for(int i=0; i<end-start; i++){
            // IQ(0:i) + f(i:len)
            int freq = myFrequencer.subByteFrequency(start+i, end);
            //assert freq >= 0;
            double t1 = iqs(start, start+i);
            double t2 = iq(freq);
            double iq = t1 + t2;

            //System.out.println(new String(mySpace));
            //System.out.println(new String(myTarget));
            //System.out.printf("iq(%d)\n", freq);
            System.out.printf("iqs(%d, %d) + iq(%d, %d) = %e + %e = %e\n", start, start+i, start+i, end, t1, t2, iq);

            // find min
            if(iq < value){
                value = iq;
            }
        }

        // memo
        memo[start][end] = value;

        return value;
    }

    @Override
    public void setTarget(byte[] target) {
        myTarget = target;
        if(myFrequencer == null){
            myFrequencer = new Frequencer();
        }
        myFrequencer.setTarget(target);

        // メモ化するやつ、無限大で初期化
        memo = new double[target.length+1][target.length+1];
        for(int i=0; i<memo.length; i++){
            for(int j=0; j<memo[i].length; j++){
                memo[i][j] = Double.MAX_VALUE;
            }
        }
    }

    @Override
    public void setSpace(byte[] space) {
        mySpace = space;
        if(myFrequencer == null){
            myFrequencer = new Frequencer();
        }
        myFrequencer.setSpace(space);
    }

    @Override
    public double estimation(){
        if(this.myTarget == null || this.myTarget.length == 0){
            return 0.0;
        }
        if(this.mySpace == null){
            return Double.MAX_VALUE;
        }
        //TODO Spaceのlengthが0のときは？

        boolean[] partition = new boolean[myTarget.length+1];
        int np;
        np = 1<<(myTarget.length-1);
        // System.out.println("np="+np+" length="+myTarget.length);
        double value = Double.MAX_VALUE; // value = mininimum of each "value1".

        for(int p=0; p<np; p++) { // There are 2^(n-1) kinds of partitions.
            // binary representation of p forms partition.
            // for partition {"ab" "cde" "fg"}
            // a b c d e f g   : myTarget
            // T F T F F T F T : partition:
            partition[0] = true; // I know that this is not needed, but..
            for(int i=0; i<myTarget.length -1;i++) {
                partition[i+1] = (0 !=((1<<i) & p));
            }
            partition[myTarget.length] = true;

            // Compute Information Quantity for the partition, in "value1"
            // value1 = IQ(#"ab")+IQ(#"cde")+IQ(#"fg") for the above example
            double value1 = (double) 0.0;
            int end = 0;;
            int start = end;
            while(start < myTarget.length) {
                // System.out.write(myTarget[end]);
                end++;
                while(partition[end] == false) {
                    // System.out.write(myTarget[end]);
                    end++;
                }
                value1 = iqs(start, end);
                System.out.printf("iqs[%d:%d] = %e\n", start, end, value1);

                // System.out.print("("+start+","+end+")");
                //myFrequencer.setTarget(subBytes(myTarget, start, end));
                //value1 = value1 + iq(myFrequencer.frequency());

                start = end;
            }
            // System.out.println(" "+ value1);

            // Get the minimal value in "value"
            if(Double.compare(value1, value) < 0){
                value = value1;
            }
            //if(value1 < value) value = value1;
        }
        return value;
    }

    public static void main(String[] args) {
        /*
        InformationEstimator myObject;
        double value;
        myObject = new InformationEstimator();
        myObject.setSpace("3210321001230123".getBytes());
        myObject.setTarget("0".getBytes());
        value = myObject.estimation();
        System.out.println(">0 "+value);
        myObject.setTarget("01".getBytes());
        value = myObject.estimation();
        System.out.println(">01 "+value);
        myObject.setTarget("0123".getBytes());
        value = myObject.estimation();
        System.out.println(">0123 "+value);
        myObject.setTarget("00".getBytes());
        value = myObject.estimation();
        System.out.println(">00 "+value);
        */

        if(args.length < 2){
            System.err.println("Usage: java InformationEstimator [SPACE file] [TARGET file]");
            System.exit(1);
        }

        byte[] space = null;
        byte[] target = null;
        try{
            space = readBytesFromFile(args[0]);
            target = readBytesFromFile(args[1]);
        }
        catch(IOException e){
        }
        InformationEstimator estimator = new InformationEstimator();
        estimator.setSpace(space);
        estimator.setTarget(target);
        double value = estimator.estimation();
        System.out.printf("%e\n", value);
    }
}
