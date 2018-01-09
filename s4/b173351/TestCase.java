package s4.b173351; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
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
	    System.out.println("checking s4.b173351.Frequencer");
	    myObject = new s4.b173351.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
        myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}
/*追加:TEST CASE1 ~ TEST CASE4*/
        try {/*[TEST CASE1]It returns -1 when TARGET is not set*/
            FrequencerInterface  myObject;
            int freq;
            System.out.println("checking s4.b173351.Frequencer");
            myObject = new s4.b173351.Frequencer();
            myObject.setSpace("Hi Ho Hi Ho".getBytes());
            //myObject.setTarget("H".getBytes());
            freq = myObject.frequency();
            if(-1 == freq) { System.out.println("TEST CASE1 OK"); } else {System.out.println("TEST CASE1 WRONG"); }
        }
        catch(Exception e) {
            System.out.println("Exception occurred: STOP");
        }
        try {/*[TEST CASE2]It returns -1 when TARGET's length is zero*/
            FrequencerInterface  myObject;
            int freq;
            System.out.println("checking s4.b173351.Frequencer");
            myObject = new s4.b173351.Frequencer();
            myObject.setSpace("Hi Ho Hi Ho".getBytes());
            myObject.setTarget("".getBytes());
            freq = myObject.frequency();
            System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
            if(-1 == freq) { System.out.println("TEST CASE2 OK"); } else {System.out.println("TEST CASE2 WRONG"); }
        }
        catch(Exception e) {
            System.out.println("Exception occurred: STOP");
        }
        try {/*[TEST CASE3]It returns 0 when SPACE is not set*/
            FrequencerInterface  myObject;
            int freq;
            System.out.println("checking s4.b173351.Frequencer");
            myObject = new s4.b173351.Frequencer();
            //myObject.setSpace("".getBytes());
            myObject.setTarget("H".getBytes());
            freq = myObject.frequency();
            if(0 == freq) { System.out.println("TEST CASE3 OK"); } else {System.out.println("TEST CASE3 WRONG"); }
        }
        catch(Exception e) {
            System.out.println("Exception occurred: STOP");
        }
        try {/*[TEST CASE4]It returns -1 when SPACE's length is zero*/
            FrequencerInterface  myObject;
            int freq;
            System.out.println("checking s4.b173351.Frequencer");
            myObject = new s4.b173351.Frequencer();
            myObject.setSpace("".getBytes());
            myObject.setTarget("H".getBytes());
            freq = myObject.frequency();
            System.out.print("\"H\" in \"\" appears "+freq+" times. ");
            if(0 == freq) { System.out.println("TEST CASE4 OK"); } else {System.out.println("TEST CASE4 WRONG"); }
        }
        catch(Exception e) {
            System.out.println("Exception occurred: STOP");
        }
        

	try {
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("checking s4.b173351.InformationEstimator");
	    myObject = new s4.b173351.InformationEstimator();
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
/*追加:TEST CASE5 ~ TEST CASE8*/
        try {/*[TEST CASE5]It return 0.0 when TARGET is not set*/
            InformationEstimatorInterface myObject;
            double value;
            System.out.println("checking s4.b173351.InformationEstimator");
            myObject = new s4.b173351.InformationEstimator();
            myObject.setSpace("3210321001230123".getBytes());
            //myObject.setTarget("".getBytes());
            value = myObject.estimation();
            if(0.0 == value) { System.out.println("TEST CASE5 OK"); } else {System.out.println("TEST CASE5 WRONG");}
        }
        catch(Exception e) {
            System.out.println("Exception occurred: STOP");
        }
        try {/*[TEST CASE6]It return 0.0 when TARGET's length is zero*/
            InformationEstimatorInterface myObject;
            double value;
            System.out.println("checking s4.b173351.InformationEstimator");
            myObject = new s4.b173351.InformationEstimator();
            myObject.setSpace("3210321001230123".getBytes());
            myObject.setTarget("".getBytes());
            value = myObject.estimation();
            System.out.println("> "+value);
            if(0.0 == value) { System.out.println("TEST CASE6 OK"); } else {System.out.println("TEST CASE6 WRONG");}
        }
        catch(Exception e) {
            System.out.println("Exception occurred: STOP");
        }
        try {/*[TEST CASE7]It return Double.MAX_VALUE when SPACE is not set*/
            InformationEstimatorInterface myObject;
            double value;
            System.out.println("checking s4.b173351.InformationEstimator");
            myObject = new s4.b173351.InformationEstimator();
            //myObject.setSpace("3210321001230123".getBytes());
            myObject.setTarget("0".getBytes());
            value = myObject.estimation();
            if(Double.MAX_VALUE == value) { System.out.println("TEST CASE7 OK"); } else {System.out.println("TEST CASE7 WRONG");}
        }
        catch(Exception e) {
            System.out.println("Exception occurred: STOP");
        }
        try {/*[TEST CASE8]It return Double.MAX_VALUE when true value is infinite*/
            InformationEstimatorInterface myObject;
            double value;
            System.out.println("checking s4.b173351.InformationEstimator");
            myObject = new s4.b173351.InformationEstimator();
            myObject.setSpace("".getBytes());
            myObject.setTarget("0".getBytes());
            value = myObject.estimation();
            System.out.println("0> "+value);
            if(Double.MAX_VALUE == value) { System.out.println("TEST CASE8 OK"); } else {System.out.println("TEST CASE8 WRONG");}
        }
        catch(Exception e) {
            System.out.println("Exception occurred: STOP");
        }
    }
}
	    
