import org.apache.commons.text.similarity.LevenshteinDistance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MatchFinder {
    static String noiseWordsFileLocation;
    static Set<String> noiseWordsSet;
    static boolean acceptTypos;
    public static void findMatch(String inputName, String namesFileLocation,
                                 String noiseWordsFileLocation, boolean acceptTypos) {
        MatchFinder.noiseWordsFileLocation = noiseWordsFileLocation;
        MatchFinder.noiseWordsSet = createNoiseWordsSet();
        MatchFinder.acceptTypos = acceptTypos;
        Set<String> inputNameSet = createNameSet(inputName);
        findMatchInNamesFile(namesFileLocation, inputNameSet);
    }

    public static void findMatchInNamesFile(String namesFileLocation, Set<String> inputNameSet) {
        try (Scanner scanner = new Scanner(new File(namesFileLocation))) {
            boolean isMatch = false;
            while (scanner.hasNext()) {
                Set<String> listNameSet = createNameSet(scanner.nextLine());
                if (isMatch(inputNameSet, listNameSet, MatchFinder.acceptTypos)) {
                    isMatch = true;
                    System.out.println("Match was found!");
                    System.out.println("inputNameSet " + inputNameSet);
                    System.out.println("listNameSet " + listNameSet);
                }
            }
            if (!isMatch) {
                System.out.println("Match was not found");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Set<String> createNameSet(String inputName) {
        String[] inputNameArray;
        inputNameArray = inputName.replaceAll("\\p{Punct}", "").split(" ");
        Set<String> nameSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Collections.addAll(nameSet, inputNameArray);
        nameSet.removeAll(MatchFinder.noiseWordsSet);
        return nameSet;
    }

    public static Set<String> createNoiseWordsSet() {
        Set<String> noiseWordsSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        try (Scanner scanner = new Scanner(new File(MatchFinder.noiseWordsFileLocation))) {
            while (scanner.hasNext()) {
                noiseWordsSet.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return noiseWordsSet;
    }

    public static boolean isMatch(Set<String> inputNameSet, Set<String> listNameSet, boolean acceptTypos) {

        if (acceptTypos) {
            return isMatchAcceptTypos(inputNameSet, listNameSet);
        }

        List<String> common = new ArrayList<>(inputNameSet);
        common.retainAll(listNameSet);

        /* if input name contains of 2 or more words
         the program will return true if 2 or more words match */

        if (inputNameSet.size() == 1) {
            return common.size() == 1;
        }

        return common.size() >= 2;
    }

    public static boolean isMatchAcceptTypos(Set<String> inputNameSet, Set<String> listNameSet) {
        LevenshteinDistance distance = new LevenshteinDistance();
        String inputName = String.join(" ", inputNameSet).toLowerCase();
        String listName = String.join(" ", listNameSet).toLowerCase();
        return distance.apply(inputName,listName) <= 1;
    }
}
