
all: 
	javac -d classes Test.java $$(find org -name "*.java")

test: all 
	java -cp classes Test

clean: 
	rm -rf classes
	find . -name "*.class" -type f -delete


.PHONY: all clean test