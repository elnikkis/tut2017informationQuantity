package s4.b173335; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID.
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
}
*/

/*
package s4.specification;
public interface InformationEstimatorInterface{
    void setTarget(byte target[]); // set the data for computing the information quantities
    void setSpace(byte space[]); // set data for sample space to computer probability
    double estimation(); // It returns 0.0 when the target is not set or Target's length is zero;
// It returns Double.MAX_VALUE, when the true value is infinite, or space is not set.
// The behavior is undefined, if the true value is finete but larger than Double.MAX_VALUE.
// Note that this happens only when the space is unreasonably large. We will encounter other problem anyway.
// Otherwise, estimation of information quantity,
}
*/


public class TestCase {
    public static void main(String[] args) {
        // [1] check behavior when normal input
	   try {
	    FrequencerInterface  myObject;
	    int freq;
        System.out.println("\nTest [1]");
	    System.out.println("checking s4.b173335.Frequencer");
	    myObject = new s4.b173335.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	   catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

        // [2] check "It return -1, when TARGET is not set"
        try {
	    FrequencerInterface  myObject;
	    int freq;
        System.out.println("\nTest [2]");
	    System.out.println("checking s4.b173335.Frequencer");
	    myObject = new s4.b173335.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    freq = myObject.frequency();
	    System.out.print("It returned " + freq+ ", when Target is not set. ");
	    if(-1 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        System.out.println();
    }
	   catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

        // [3] check "It return -1, when TARGET's length is zero"
        try {
	    FrequencerInterface  myObject;
	    int freq;
        System.out.println("\nTest [3]");
	    System.out.println("checking s4.b173335.Frequencer");
	    myObject = new s4.b173335.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("".getBytes());
	    freq = myObject.frequency();
	    System.out.print("It returned " + freq+ ", when TARGET's length is zero. ");
	    if(-1 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	   catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

        // [4] check "it return 0, when SPACE is not set"
        try {
        FrequencerInterface  myObject;
        int freq;
        System.out.println("\nTest [4]");
        System.out.println("checking s4.b173335.Frequencer");
        myObject = new s4.b173335.Frequencer();
        myObject.setTarget("H".getBytes());
        freq = myObject.frequency();
        System.out.print("It returned " + freq+ ", when Space is not set. ");
        if(0 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
    }
        catch(Exception e) {
        System.out.println("Exception occurred: STOP");
    }

        // [5] check "it return 0, when Space's length is zero"
        try {
            FrequencerInterface  myObject;
            int freq;
            System.out.println("\nTest [5]");
            System.out.println("checking s4.b173335.Frequencer");
            myObject = new s4.b173335.Frequencer();
            myObject.setSpace("".getBytes());
            myObject.setTarget("H".getBytes());
            freq = myObject.frequency();
            System.out.print("It returned " + freq + ", when Space's length is zero. ");
            if(0 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        }
        catch(Exception e) {
            System.out.println("Exception occurred: STOP");
        }

        // [6] check behavior when input using two bytes character
        try {
            FrequencerInterface  myObject;
            int freq;
            System.out.println("\nTest [6]");
            System.out.println("checking s4.b173335.Frequencer");
            myObject = new s4.b173335.Frequencer();
            myObject.setSpace("あいういえおあ".getBytes());
            myObject.setTarget("あ".getBytes());
            freq = myObject.frequency();
            System.out.print("\"あ\" in \"あいういえおあ\" appears "+freq+" times. ");
            if(2 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        }
        catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

        // [7] check behavior when normal input
        try {
            InformationEstimatorInterface myObject;
            double value;
            System.out.println("\nTest [7]");
            System.out.println("checking s4.b173335.InformationEstimator");
            myObject = new s4.b173335.InformationEstimator();
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
        }
        catch(Exception e) {
            System.out.println("Exception occurred: STOP");
        }

        // check "It returns 0.0 when the target is not set."
        try {
            InformationEstimatorInterface myObject;
            double value;
            System.out.println("\nTest [8]");
            System.out.println("checking s4.b173335.InformationEstimator");
            myObject = new s4.b173335.InformationEstimator();
            myObject.setSpace("3210321001230123".getBytes());
            value = myObject.estimation();
            System.out.println("It returned "+value + ", when the target is not set.");
            if(0.0 == value) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        }
        catch(Exception e) {
            System.out.println("Exception occurred: STOP");
        }

        // check "It returns 0.0 when the Target's length is zero."
        try {
            InformationEstimatorInterface myObject;
            double value;
            System.out.println("\nTest [9]");
            System.out.println("checking s4.b173335.InformationEstimator");
            myObject = new s4.b173335.InformationEstimator();
            myObject.setSpace("3210321001230123".getBytes());
            myObject.setTarget("".getBytes());
            value = myObject.estimation();
            System.out.println("It returned "+value + ", when Target's length is zero.");
            if(0.0 == value) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        }
        catch(Exception e) {
            System.out.println("Exception occurred: STOP");
        }

        // check "It returns Double.MAX_VALUE, when the true value is infinite, or space is not set."
        try {
            InformationEstimatorInterface myObject;
            double value;
            System.out.println("\nTest [10]");
            System.out.println("checking s4.b173335.InformationEstimator");
            myObject = new s4.b173335.InformationEstimator();
            myObject.setSpace("".getBytes());
            myObject.setTarget("0".getBytes());
            value = myObject.estimation();
            System.out.println("It returned "+value + "when the true value is infinite, or space is not set.");
            if(Double.MAX_VALUE == value) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        }
        catch(Exception e) {
            System.out.println("Exception occurred: STOP");
        }
        try {
            InformationEstimatorInterface myObject;
            double value;
            System.out.println("\nTest [11]");
            System.out.println("checking s4.b173335.InformationEstimator");
            myObject = new s4.b173335.InformationEstimator();
            myObject.setTarget("0".getBytes());
            value = myObject.estimation();
            System.out.println("It returned "+value + "when the true value is infinite, or space is not set.");
            if(Double.MAX_VALUE == value) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        }
        catch(Exception e) {
            System.out.println("Exception occurred: STOP");
        }
    }
}
