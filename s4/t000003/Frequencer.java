package s4.t000003; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
import java.lang.*;
import s4.specification.*;


public class Frequencer implements FrequencerInterface {
    // Code to Test, *warning: This code  contains intentional problem*
    byte [] myTarget;
    byte [] mySpace;

    @Override
    public void setTarget(byte[] target) {
        myTarget = target;
    }

    @Override
    public void setSpace(byte[] space) {
        mySpace = space;
    }

    @Override
    public int frequency() {
        if(this.myTarget == null || this.myTarget.length == 0){
            return -1;
        }
        if(this.mySpace == null || this.mySpace.length == 0){
            return 0;
        }

        int targetLength = myTarget.length;
        int spaceLength = mySpace.length;
        // mySpaceの中からmyTargetの出現頻度を数える
        int count = 0;
        for(int start = 0; start < spaceLength-targetLength; start++) { // Is it OK?
            boolean abort = false;
            for(int i = 0; i<targetLength; i++) {
                if(myTarget[i] != mySpace[start+i]) {
                    abort = true;
                    break;
                }
            }
            if(abort == false) {
                count++;
            }
        }
        return count;
    }

    // I know that here is a potential problem in the declaration.
    @Override
    public int subByteFrequency(int start, int length) { 
        // Not yet, but it is not currently used by anyone.
        return -1;
    }

    public static void main(String[] args) {
        Frequencer myObject;
        int freq;
        try {
            System.out.println("checking my Frequencer");
            myObject = new Frequencer();
            myObject.setSpace("Hi Ho Hi Ho".getBytes());
            myObject.setTarget("H".getBytes());
            freq = myObject.frequency();
            System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
            if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        }
        catch(Exception e) {
            System.out.println("Exception occurred: STOP");
        }
    }
}
