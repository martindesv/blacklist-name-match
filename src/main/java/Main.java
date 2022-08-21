import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Running Main");

        Properties prop = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("config.properties");
        prop.load(stream);

        if (args.length == 0) {
            System.out.println("Please pass a name to the program");
            return;
        }

        final String inputName = args[0];
        final String namesFileLocation = prop.getProperty("namesFileLocation");
        final String noiseWordsFileLocation = prop.getProperty("noiseWordsFileLocation");
        final boolean acceptTypos = Boolean.parseBoolean(prop.getProperty("acceptTypos"));

        MatchFinder.findMatch(inputName, namesFileLocation, noiseWordsFileLocation, acceptTypos);
    }
}
