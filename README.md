Blacklist Name Matching

javac src/main/java/Main.java
java src/main/java/Main

./run.sh "Mary Tree" "/home/m/Desktop/test-projects/lhv/blacklist-name-match/names.txt"

mvn test

mvn clean compile exec:java -Dexec.args="'osama bin laden' names.txt noise.txt"
