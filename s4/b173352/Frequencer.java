package s4.b173352; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
import java.lang.*;
import s4.specification.*;

/*
interface FrequencerInterface {     // This interface provides the design for frequency counter.
    void setTarget(byte[]  target); // set the data to search.
    void setSpace(byte[]  space);  // set the data to be searched target from.
    int frequency(); //It return -1, when TARGET is not set or TARGET's length is zero
                    //Otherwise, it return 0, when SPACE is not set or Space's length is zero
                    //Otherwise, get the frequency of TAGET in SPACE
    int subByteFrequency(int start, int end);
    // get the frequency of subByte of taget, i.e target[start], taget[start+1], ... , target[end-1].
    // For the incorrect value of START or END, the behavior is undefined.
*/


public class Frequencer implements FrequencerInterface{
    // Code to Test, *warning: This code  contains intentional problem*
    byte [] myTarget;
    byte [] mySpace;
    public void setTarget(byte [] target) { myTarget = target;}
    public void setSpace(byte []space) { mySpace = space; }
    public int frequency() {
	int targetLength = myTarget.length;
	int spaceLength = mySpace.length;
	int count = 0;
	if(targetLength == 0)return -1;
	for(int start = 0; start<spaceLength; start++) { // Is it OK?
	    boolean abort = false;
	    for(int i = 0; i<targetLength; i++) {
		if(myTarget[i] != mySpace[start+i]) { abort = true; break; }
	    }
	    if(abort == false) { count++; }
	}
	return count;
    }

    // I know that here is a potential problem in the declaration.
    public int subByteFrequency(int start, int end) { 
	// Not yet, but it is not currently used by anyone.
	int targetLength = myTarget.length;
	int spaceLength = mySpace.length;
	if(targetLength == 0)return -1;
	if(!(start >= 0 && start <= end && end < targetLength)) return -1;
	byte [] result = new byte[end - start];
	for(int i = 0; i<end - start; i++) { result[i] = myTarget[start + i]; };
	int count = 0;
	int resultLength = result.length;
	for(int head = 0; head<spaceLength; head++) { // Is it OK?
	    boolean abort = false;
	    for(int i = 0; i<resultLength; i++) {
		if(result[i] != mySpace[head+i]) { abort = true; break; }
	    }
	    if(abort == false) { count++; }
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
	    
