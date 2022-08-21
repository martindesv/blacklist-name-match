# Blacklist Name Matching

## Technologies used
* Apache Maven 3.6.3
* openjdk version "1.8.0_312"

## Setting up the program
Open the file found at `src/main/resources/config.properties`  
and set the following arguments for the program:
* namesFileLocation
* noiseWordsFileLocation
* acceptTypos

## Running the program
From terminal run `mvn compile exec:java -Dexec.args="'Oscar'"`

where `-Dexec.args` value is the input name to validate against  
NB! Single quotes are important

### Output

![build image](images/build.png)
