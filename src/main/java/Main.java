import org.apache.commons.text.similarity.LevenshteinDistance;

public class Main {
    public static void main(String[] args) {
        final String inputName = args[0];
        final String namesFileLocation = args[1];
        final String noiseWordsFileLocation = args[2];

        MatchFinder.findMatch(inputName, namesFileLocation, noiseWordsFileLocation);

        LevenshteinDistance distance = new LevenshteinDistance();
        System.out.println("test " + distance.apply("",""));
    }
}
