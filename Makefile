### THE FOLLOWING BUILD PROCESS IS OUTDATED AND WILL BE REPLACE AS OF 2025-01-20 
###
####


# Project directories

SRC_DIR := src
LIB_DIR := lib
BIN_DIR := bin
DIST_DIR := ../../plugins

# Output JAR file name
JAR_NAME := Maven.jar
OUTPUT_JAR := $(DIST_DIR)/$(JAR_NAME)

# Libraries
LIBS := $(wildcard $(LIB_DIR)/*.jar)
CLASSPATH := $(LIBS: =:)

# Compiler and flags
JAVAC := javac
JAR := jar
JAVA_FLAGS := -cp $(CLASSPATH) -d $(BIN_DIR)

# Find all .java source files
JAVA_SOURCES := $(shell find $(SRC_DIR) -name "*.java")
# Generate a list of .class files corresponding to each .java file in the bin directory
CLASS_FILES := $(patsubst $(SRC_DIR)/%.java, $(BIN_DIR)/%.class, $(JAVA_SOURCES))

# Default target
all: $(OUTPUT_JAR)

# Rule to compile .java files into .class files in the bin directory
$(BIN_DIR)/%.class: $(SRC_DIR)/%.java
	@mkdir -p $(dir $@)
	$(JAVAC) $(JAVA_FLAGS) $<

# Create the JAR file
$(OUTPUT_JAR): $(CLASS_FILES)
	@mkdir -p $(DIST_DIR)
	$(JAR) cvf $(OUTPUT_JAR) -C $(BIN_DIR) .

# Clean the bin and dist directories
clean:
	rm -rf $(BIN_DIR) $(DIST_DIR)

.PHONY: all clean