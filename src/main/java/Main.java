public class Main {
    public static void main(String[] args) {
        final String inputName = args[0];
        final String namesFileLocation = args[1];
        final String noiseWordsFileLocation = args[2];

        FindName findName = new FindName(inputName, namesFileLocation, noiseWordsFileLocation);
        findName.checkIfMatch();
    }
}
