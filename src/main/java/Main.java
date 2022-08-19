import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String inputName = args[0];
        final String namesFileLocation = args[1];
        final String noiseWordsFileLocation = args[2];

        Set<String> noiseWordsArr = createNoiseWordsArr(noiseWordsFileLocation);

        Set<String> inputNameSet = createNameSet(inputName, noiseWordsArr);

        try (Scanner scanner = new Scanner(new File(namesFileLocation))) {
            while (scanner.hasNext()) {
                Set<String> listNameSet = createNameSet(scanner.nextLine(), noiseWordsArr);
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

    public static Set<String> createNameSet(String inputName, Set<String> noiseWordsArr) {
        String[] inputNameArray;
        inputNameArray = inputName.replaceAll("\\p{Punct}", "").split(" ");
        Set<String> nameSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Collections.addAll(nameSet, inputNameArray);
        nameSet.removeAll(noiseWordsArr);
        return nameSet;
    }

    public static Set<String> createNoiseWordsArr(String noiseWordsFileLocation) {
        Set<String> noiseWordsArr = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        try (Scanner scanner = new Scanner(new File(noiseWordsFileLocation))) {
            while (scanner.hasNext()) {
                noiseWordsArr.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return noiseWordsArr;
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
