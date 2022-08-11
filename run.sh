#!/bin/bash

echo "First argument: $1"
echo "Second argument: $2"

javac src/main/java/Main.java
java src/main/java/Main "$1" "names.txt"
