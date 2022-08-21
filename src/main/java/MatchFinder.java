import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MatchFinder {
    public static void findMatch(String inputName, String namesFileLocation, String noiseWordsFileLocation) {
        Set<String> noiseWordsSet = createNoiseWordsSet(noiseWordsFileLocation);
        Set<String> inputNameSet = createNameSet(inputName, noiseWordsSet);
        findMatchInNamesFile(namesFileLocation, noiseWordsSet, inputNameSet);
    }

    public static void findMatchInNamesFile(String namesFileLocation, Set<String> noiseWordsSet, Set<String> inputNameSet) {
        try (Scanner scanner = new Scanner(new File(namesFileLocation))) {
            while (scanner.hasNext()) {
                Set<String> listNameSet = createNameSet(scanner.nextLine(), noiseWordsSet);
                if (isMatch(inputNameSet, listNameSet)) {
                    System.out.println("inputNameSet " + inputNameSet);
                    System.out.println("listNameSet " + listNameSet);
                    System.out.println("Match is found!");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Set<String> createNameSet(String inputName, Set<String> noiseWordsSet) {
        String[] inputNameArray;
        inputNameArray = inputName.replaceAll("\\p{Punct}", "").split(" ");
        Set<String> nameSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Collections.addAll(nameSet, inputNameArray);
        nameSet.removeAll(noiseWordsSet);
        return nameSet;
    }

    public static Set<String> createNoiseWordsSet(String noiseWordsFileLocation) {
        Set<String> noiseWordsSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        try (Scanner scanner = new Scanner(new File(noiseWordsFileLocation))) {
            while (scanner.hasNext()) {
                noiseWordsSet.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return noiseWordsSet;
    }

    public static boolean isMatch(Set<String> inputNameSet, Set<String> listNameSet) {
        List<String> common = new ArrayList<>(inputNameSet);
        common.retainAll(listNameSet);
        if (inputNameSet.size() == 1) {
            return common.size() == 1;
        }

        return common.size() >= 2;
    }
}
