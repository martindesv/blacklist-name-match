import org.apache.commons.text.similarity.LevenshteinDistance;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Running Main");

        Properties prop = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("filesLocation.properties");
        prop.load(stream);

        final String inputName = args[0];
        final String namesFileLocation = prop.getProperty("namesFileLocation");
        final String noiseWordsFileLocation = prop.getProperty("noiseWordsFileLocation");

        MatchFinder.findMatch(inputName, namesFileLocation, noiseWordsFileLocation);

        LevenshteinDistance distance = new LevenshteinDistance();
        System.out.println("test " + distance.apply("osama bin laden","osama bin laden"));
    }
}
