#CSC3002S OS Assignment 2 part II Makefile
#Elle Mouton
#13/04/2019

JAVAC=/usr/bin/javac
JAVA = java
PATH = dishWashS

.SUFFIXES: .java .class

$(PATH)/%.class:$(PATH)/%.java
	$(JAVAC) $<
	
CLASSES =	Dryer.class\
		Washer.class\
		WetDishRack.class\
		CleaningDishes.class
		
CLASS_FILES = $(CLASSES:%.class=$(PATH)/%.class)

default: $(CLASS_FILES)

clean:
	/bin/rm $(PATH)/*.class