package s4.t000003; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
import java.lang.*;
import s4.specification.*;


public class TestCase {
    private static int testCount = 0;

    /** Test and print message.
     *
     * @param expr : boolean value
     * @param message : String Message printed when failed
     */
    static void assertTrue(boolean expr, String message) {
        testCount++;
        System.out.printf("Test%2d ", testCount);
        if(!expr) {
            System.out.println("Failed: " + message);
        }
        else {
            System.out.println("Passed");
        }
    }

    /**
     * Test frequency method of FrequencerInterface
    **/
    private static void testFrequency() {
        {
            FrequencerInterface frequencer = new Frequencer();
            frequencer.setSpace("Foo Bar Foo Bar".getBytes());
            frequencer.setTarget("Foo".getBytes());
            int count = frequencer.frequency();
            assertTrue(count == 2, "Foo appears 2 times");
        }
        {
            FrequencerInterface frq = new Frequencer();
            int ret = frq.frequency();
            assertTrue(ret == 0 || ret == -1, "When TARGET and SPACE is empty, the behaviour is undefined...?");
        }
        {
            FrequencerInterface frq = new Frequencer();
            frq.setSpace("foo bar foo ba".getBytes());
            int ret = frq.frequency();
            assertTrue(ret == -1, "When TARGET is not set, frequency should return -1.");
        }
        {
            FrequencerInterface frq = new Frequencer();
            frq.setSpace("foo bar foo ba".getBytes());
            frq.setTarget("".getBytes());
            int ret = frq.frequency();
            assertTrue(ret == -1, "When TARGET's length is zero, frequency should return -1.");
        }
        {
            FrequencerInterface frq = new Frequencer();
            frq.setTarget("ba".getBytes());
            int ret = frq.frequency();
            assertTrue(ret == 0, "When SPACE is not set, frequency should return 0.");
        }
        {
            FrequencerInterface frq = new Frequencer();
            frq.setSpace("".getBytes());
            frq.setTarget("ba".getBytes());
            int ret = frq.frequency();
            assertTrue(ret == 0, "When SPACE's length is zero, frequency should return 0.");
        }
        {
            FrequencerInterface frq = new Frequencer();
            frq.setSpace("foo bar foo ba".getBytes());
            frq.setTarget("o".getBytes());
            int ret = frq.frequency();
            assertTrue(ret == 4, "should return the frequency");
        }
    }

    private static void testSubByteFrequency() {
        {
            FrequencerInterface frq = new Frequencer();
            frq.setSpace("aaaaaaaaaaaaaaaaaaaaaaa".getBytes());
            frq.setTarget("a".getBytes());
            {
                int ret = frq.subByteFrequency(0, 5);
                assertTrue(ret == 5, "subByteFrequency 5");
            }
            {
                int ret = frq.subByteFrequency(0, 2);
                assertTrue(ret == 2, "subByteFrequency 2");
            }
            {
                int ret = frq.subByteFrequency(0, 0);
                assertTrue(ret == 2, "subByteFrequency 0");
            }
        }
    }

    private static void testInformationEstimator() {
        {
            InformationEstimatorInterface est = new InformationEstimator();
            double ret = est.estimation();
            assertTrue(ret == 0.0 || ret == Double.MAX_VALUE, "both empty");
        }
        {
            InformationEstimatorInterface est = new InformationEstimator();
            est.setSpace("foo bar foo ba".getBytes());
            double ret = est.estimation();
            assertTrue(ret == 0.0, "When TARGET is not set, returns 0.0");
        }
        {
            InformationEstimatorInterface est = new InformationEstimator();
            est.setSpace("foo bar foo ba".getBytes());
            est.setTarget("".getBytes());
            double ret = est.estimation();
            assertTrue(ret == 0.0, "When TARGET's length is zero, returns 0.0");
        }
        {
            InformationEstimatorInterface est = new InformationEstimator();
            est.setTarget("fo".getBytes());
            double ret = est.estimation();
            assertTrue(ret == Double.MAX_VALUE, "When SPACE is not set, returns Double.MAX_VALUE");
        }
        //TODO 推定値がinfiniteの場合のテスト
    }

    public static void main(String[] args) {
        try {
            FrequencerInterface  myObject;
            int freq;
            System.out.println("checking s4.t000003.Frequencer");
            myObject = new s4.t000003.Frequencer();
            myObject.setSpace("Hi Ho Hi Ho".getBytes());
            myObject.setTarget("H".getBytes());
            freq = myObject.frequency();
            System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
            if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred: STOP");
        }

        try {
            InformationEstimatorInterface myObject;
            double value;
            System.out.println("checking s4.t000003.InformationEstimator");
            myObject = new s4.t000003.InformationEstimator();
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
            e.printStackTrace();
            System.out.println("Exception occurred: STOP");
        }

        try {
            testFrequency();
            testSubByteFrequency();
            testInformationEstimator();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred: STOP");
        }
    }
}
