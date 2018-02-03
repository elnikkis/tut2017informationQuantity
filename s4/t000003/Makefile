all:
	javac Hello.java -classpath "../.."
	javac Frequencer.java -classpath "../.."
	javac InformationEstimator.java -classpath "../.."
	javac TestCase.java -classpath "../.."
run:
#	java -classpath "../.." s4.t000003/Hello
#	java -classpath "../.." s4.t000003/Frequencer
#	java -classpath "../.." s4.t000003/InformationEstimator
	java -classpath "../.." s4.t000003/TestCase

%.class: %.java
	javac $< -classpath "../.."

runhello: Hello.class
	java -classpath "../.." s4.t000003/Hello
runfrequencer: Frequencer.class
	java -classpath "../.." s4.t000003/Frequencer
runinformationestimator: InformationEstimator.class
	java -classpath "../.." s4.t000003/InformationEstimator
test: TestCase.class
	java -classpath "../.." s4.t000003/TestCase
