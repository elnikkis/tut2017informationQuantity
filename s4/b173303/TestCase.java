package s4.b173303; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
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
	try {
	    FrequencerInterface  myObject;
	    int freq;
	    System.out.println("checking s4.b173303.Frequencer");
	    myObject = new s4.b173303.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

      
            //Target is Zero                                                                                 
            FrequencerInterface  myObject2;
            myObject2 = new s4.b173303.Frequencer();
            myObject2.setSpace("abcde".getBytes());
	    myObject2.setTarget("".getBytes());
            freq = myObject2.frequency();
	    System.out.print("\"\" in \"abcde\" appears "+freq+" times. ");
            if(-1 == freq) { System.out.println("Target is Zero"); } else {System.out.println("WRONG"); }

            //Not set target
            FrequencerInterface  myObject3;
	    myObject3 = new s4.b173303.Frequencer();
            myObject3.setSpace("abcde".getBytes());
            freq = myObject3.frequency();
	    System.out.print("\"\" in \"abcde\" appears "+freq+" times. ");
            if(-1 == freq) { System.out.println("Not set Target"); } else {System.out.println("WRONG"); }

	    //Not set Space
	    FrequencerInterface  myObject4;
            myObject4 = new s4.b173303.Frequencer();
	    myObject4.setTarget("d".getBytes());
            freq = myObject4.frequency();
            System.out.print("\"d\" in \"\" appears "+freq+" times. ");
            if(0 == freq) { System.out.println("Not set Space"); } else {System.out.println("WRONG"); }

	    //Space is zero
	    FrequencerInterface  myObject5;
            myObject5 = new s4.b173303.Frequencer();
	    myObject5.setSpace("".getBytes());
            myObject5.setTarget("".getBytes());
            freq = myObject5.frequency();
            System.out.print("\"\" in \"\" appears "+freq+" times. ");
            if(0 == freq) { System.out.println("Space is Zero"); } else {System.out.println("WRONG"); }

	}
	System.out.print("\"d\" in \"\" appears "+freq+" times. ");	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	try {
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("checking s4.b173303.InformationEstimator");
	    myObject = new s4.b173303.InformationEstimator();
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

	    //Target is zero
            myObject.setTarget("".getBytes());
            value = myObject.estimation();
            System.out.print(">Target Zero "+value+"  ");
	    if(0.0 == value) { System.out.println("Target is Zero"); } else {System.out.println("WRONG"); }

	    //Not set Target
	    InformationEstimatorInterface myObject2;
	    myObject2 = new s4.b173303.InformationEstimator();
            myObject2.setSpace("3210321001230123".getBytes());
            value = myObject2.estimation();
            System.out.print(">Not set target "+value+"  ");
	    if(0.0 == value) { System.out.println("Not set Target"); } else {System.out.println("WRONG"); }

	    //True value is Infinite                                                                         
            InformationEstimatorInterface myObject3;
            myObject3 = new s4.b173303.InformationEstimator();
            myObject3.setSpace("".getBytes());
            myObject3.setTarget("012".getBytes());
            value = myObject3.estimation();
            System.out.print(">Infinite "+value+"  ");
            if(Double.MAX_VALUE == value) { System.out.println("True value is Infinite"); } else {System.out.println("WRONG"); }

	    //Not set Space
	    InformationEstimatorInterface myObject4;
            myObject4 = new s4.b173303.InformationEstimator();
            myObject4.setTarget("0".getBytes());
            value = myObject4.estimation();
            System.out.print(">Not set Space "+value+"  ");
	    if(Double.MAX_VALUE == value) { System.out.println("Not set space "); } else {System.out.println("WRONG"); }

	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}
    }
}	    
	    
