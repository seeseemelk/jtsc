JXE ?= java -jar ../../build/libs/jxe-all.jar
SRC = $(shell find src -iname '*.java')
SUFFIX ?=
CLASSES = $(SRC:src/%.java=bin$(SUFFIX)/%.class)

.PHONY: test
test: $(CLASSES)
	$(JXE) $(JAVA_ARGS) bin$(SUFFIX) conv$(SUFFIX)
	cp tests.d conv/source
	cd conv && dub test

bin$(SUFFIX)/%.class: src/%.java
	javac -d bin$(SUFFIX) $^
