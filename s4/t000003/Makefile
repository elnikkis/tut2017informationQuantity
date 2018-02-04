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
	java -classpath "../.." s4.t000003/InformationEstimator dummy100 dummy10
test: TestCase.class Frequencer.class InformationEstimator.class
	java -ea -classpath "../.." s4.t000003/TestCase


makedummy: dummy10 dummy100 dummy1k dummy1m

dummy10:
	base64 /dev/urandom | head -c 10 > $@
dummy100:
	base64 /dev/urandom | head -c 100 > $@
dummy1k:
	base64 /dev/urandom | head -c 1024 > $@
dummy1m:
	base64 /dev/urandom | head -c 1000000 > $@
