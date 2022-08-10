#!/bin/bash

echo "First arg: $1"
echo "Second arg: $2"

javac src/main/java/Main.java
java src/main/java/Main "$1" "$2"
