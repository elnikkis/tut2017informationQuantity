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
        // 基本的な振る舞いチェック
        if(this.myTarget == null || this.myTarget.length == 0){
            return -1;
        }
        if(this.mySpace == null || this.mySpace.length == 0){
            return 0;
        }
        return subByteFrequency(0, this.myTarget.length);
    }

    /**
     * TARGETのsubBytesの頻度を数える
     */
    @Override
    public int subByteFrequency(int start, int length) {
        // 基本的な振る舞いチェック
        if(this.myTarget == null || this.myTarget.length == 0){
            return -1;
        }
        if(this.mySpace == null || this.mySpace.length == 0){
            return 0;
        }

        //int targetLength = myTarget.length;
        int targetLength = length;
        int spaceLength = mySpace.length;

        // 値域: start >= 0 && length > 0
        if(start < 0 || length <= 0){
            return -1;
        }
        // subByteがTARGETからはみ出ているときはエラー
        if(start+length > this.myTarget.length){
            return -1;
        }

        int count = 0;
        for(int p=0; p<spaceLength-targetLength; p++){
            boolean abort = false;
            for(int i=0; i<targetLength; i++){
                if(myTarget[start+i] != mySpace[p+i]){
                    abort = true;
                    break;
                }
            }
            if(abort == false){
                count++;
            }
        }
        return count;
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
