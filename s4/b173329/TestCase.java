package s4.b173329; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
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
	    System.out.println("checking s4.b173329.Frequencer");
	    myObject = new s4.b173329.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        
        FrequencerInterface  myObject2;
        int freq2;
        myObject2 = new s4.b173329.Frequencer();
        myObject2.setSpace("Hi Ho Hi Ho".getBytes());
        //myObject2.setTarget("H".getBytes());
        freq2 = myObject2.frequency();
        System.out.print("the TARGET is not set. It returns " + freq2);
        if(-1 == freq2) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        
        FrequencerInterface  myObject3;
        int freq3;
        myObject3 = new s4.b173329.Frequencer();
        myObject3.setSpace("Hi Ho Hi Ho".getBytes());
        myObject3.setTarget("".getBytes());
        freq3 = myObject3.frequency();
        System.out.print("TARGET's length is zero. It returns " + freq3);
        if(-1 == freq3) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        
        FrequencerInterface  myObject4;
        int freq4;
        myObject4 = new s4.b173329.Frequencer();
        //myObject4.setSpace("Hi Ho Hi Ho".getBytes());
        myObject4.setTarget("H".getBytes());
        freq4 = myObject4.frequency();
        System.out.print("SPACE is not set. It returns " + freq4);
        if(0 == freq4) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        
        FrequencerInterface  myObject5;
        int freq5;
        myObject5 = new s4.b173329.Frequencer();
        myObject5.setSpace("".getBytes());
        myObject5.setTarget("H".getBytes());
        freq5 = myObject5.frequency();
        System.out.print("SPACE's length is zero. It returns " + freq5);
        if(0 == freq5) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	try {
        InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("checking s4.b173329.InformationEstimator");
	    myObject = new s4.b173329.InformationEstimator();
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
        
        InformationEstimatorInterface myObject2;
        double value2;
        myObject2 = new s4.b173329.InformationEstimator();
        myObject2.setSpace("3210321001230123".getBytes());
        //myObject2.setTarget("0".getBytes());
        value2 = myObject2.estimation();
        System.out.print("the TARGET is not set. It returns 0.0. ");
        if(0.0 == value2) { System.out.println("value = " + value2 + "OK"); } else {System.out.println("WRONG"); }
        
        InformationEstimatorInterface myObject3;
        double value3;
        myObject3 = new s4.b173329.InformationEstimator();
        myObject3.setSpace("3210321001230123".getBytes());
        myObject3.setTarget("".getBytes());
        value3 = myObject3.estimation();
        System.out.print("TARGET's length is zero. It returns 0.0. ");
        if(0.0 == value3) { System.out.println("value = " + value3 + "OK"); } else {System.out.println("WRONG"); }
        
        InformationEstimatorInterface myObject4;
        double value4;
        myObject4 = new s4.b173329.InformationEstimator();
        myObject4.setSpace("jsgsgjsdkgnsdlkfgsdkgjsdgjds;lfkg;dlskgjslvtbnkjgjsvjmscoisfoisfoghsfsgsg gdsfgvvvgv".getBytes());
        myObject4.setTarget("0".getBytes());
        value4 = myObject4.estimation();
        System.out.print("the true value is finite. It returns Double.MAX_VALUE. ");
        if(Double.MAX_VALUE == value4) { System.out.println("value = " + value4 + "OK"); } else {System.out.println("WRONG"); }
        
        InformationEstimatorInterface myObject5;
        double value5;
        myObject5 = new s4.b173329.InformationEstimator();
        //myObject5.setSpace("3210321001230123".getBytes());
        myObject5.setTarget("0".getBytes());
        value5 = myObject4.estimation();
        System.out.print("SPACE is not set. It returns Double.MAX_VALUE. ");
        if(Double.MAX_VALUE == value5) { System.out.println("value = " + value5 + "OK"); } else {System.out.println("WRONG"); }


    
    
    }
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

    }
}	    
	    
