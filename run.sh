#!/bin/bash

echo "Input name: $1"

javac src/main/java/*.java
java -cp src/main/java Main "$1" "names.txt" "noise.txt"
