#!/bin/bash

echo "Input name: $1"

javac src/main/java/Main.java
java src/main/java/Main "$1" "names.txt"
