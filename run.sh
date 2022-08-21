#!/bin/bash

echo "Input name: $1"

mkdir -p output
javac -d output src/main/java/*.java
java -cp output Main "$1" "names.txt" "noise.txt"
