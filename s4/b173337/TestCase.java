package s4.b173337; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
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

    /* TEST CASE for FrequencerInterface */

	    // It returns -1 when TARGET is not set.
		try {
	    	FrequencerInterface  myObject;
	    	int freq;
	    	System.out.println("checking s4.b173337.Frequencer");
			System.out.println("It returns -1 when TARGET is not set.");

	    	myObject = new s4.b173337.Frequencer();
	    	myObject.setSpace("Hi Ho Hi Ho".getBytes());
			//Target is not set
			//myObject.setTarget("H".getBytes());
	    	freq = myObject.frequency();
	    	if(-1 == freq) { System.out.println("OK ( TARGET is not set ) "); } else {System.out.println("WRONG"); }
		}
		catch(Exception e) {
	    	System.out.println("Exception occurred: STOP");
		}

		// It returns -1 when TARGET's length is zero.
		try {
			FrequencerInterface  myObject;
			int freq;
			System.out.println("It returns -1 when TARGET's length is zero.");
			myObject = new s4.b173337.Frequencer();
			myObject.setSpace("".getBytes());
			//Target's length is zero.
			myObject.setTarget("".getBytes);
			freq = myObject.frequency();
			if(-1 == freq) { System.out.println("OK ( TARGET's length is zero. ) "); } else {System.out.println("WRONG"); }
		}
		catch(Exception e) {
			System.out.println("Exception occurred: STOP");
		}

		//It returns 0 when SPACE is not set.
		try {
			FrequencerInterface  myObject;
			int freq;
			System.out.println("It returns 0 when SPACE is not set.");
			myObject = new s4.b173337.Frequencer();


			//myObject.setSpace("Hi Ho Hi Ho".getBytes());
			myObject.setTarget("H".getBytes());
			freq = myObject.frequency();
			if(0 == freq) { System.out.println("OK ( SPACE is not set. ) "); } else {System.out.println("WRONG"); }
		}
		catch(Exception e) {
			System.out.println("Exception occurred: STOP");
		}

		//It returns 0 when SPACE's length is zero.
		try {
			FrequencerInterface  myObject;
			int freq;
			System.out.println("It returns 0 when SPACE's length is zero.");
			myObject = new s4.b173337.Frequencer();
			myObject.setSpace("".getBytes());
			myObject.setTarget("H".getBytes());
			freq = myObject.frequency();
			if(0 == freq) { System.out.println("OK ( SPACE's length is zero. )"); } else {System.out.println("WRONG"); }
		}
		catch(Exception e) {
				System.out.println("Exception occurred: STOP");
		}


	/*TEST CASE for InformationEstimatorInterface
	It returns 0.0 when the target is not set or Target's length is zero;*/
		try {
	    	InformationEstimatorInterface myObject;
	    	double value;
	    	System.out.println("checking s4.b173337.InformationEstimator");
	    	myObject = new s4.b173337.InformationEstimator();
	    	myObject.setSpace("3210321001230123".getBytes());
	    	// Target is not set.
	    	//myObject.setTarget("0".getBytes());
			System.out.println("Target is not set.");
	    	value = myObject.estimation();
	    	System.out.println(">0 "+value);

	    	//Target's length is zero
			System.out.println("Target's length is zero.");
	    	myObject.setTarget("".getBytes());
	    	value = myObject.estimation();
	    	System.out.println(">01"+value);
	    	/*myObject.setTarget("0123".getBytes());
	    	value = myObject.estimation();
	    	System.out.println(">0123 "+value);
	    	myObject.setTarget("00".getBytes());
	    	value = myObject.estimation();
	    	System.out.println(">00 "+value);*/
		}
		catch(Exception e) {
		    System.out.println("Exception occurred: STOP");
		}

	/*It returns Double.MAX_VALUE, when the true value is infinite, or space is not set.*/
		try {
			InformationEstimatorInterface myObject;
			double value;
			System.out.println("checking s4.b173337.InformationEstimator");
			myObject = new s4.b173337.InformationEstimator();

			//Space is not set
			//myObject.setSpace("3210321001230123".getBytes());

			myObject.setTarget("0".getBytes());
			value = myObject.estimation();
			System.out.println("Space is not set.");
			System.out.println(">0 "+value);

		}
		catch(Exception e) {
			System.out.println("Exception occurred: STOP");
		}

    }

}	    
	    
