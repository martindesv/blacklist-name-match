import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String inputName = args[0];
        final String fileLocation = args[1];

        Set<String> inputNameSet = createNameSet(inputName);

        try (Scanner scanner = new Scanner(new File(fileLocation))) {
            while (scanner.hasNext()) {
                Set<String> listNameSet = createNameSet(scanner.nextLine());
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

    public static Set<String> createNameSet(String inputName) {
        String[] inputNameArray;
        inputNameArray = inputName.split(" ");
        Set<String> nameSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Collections.addAll(nameSet, inputNameArray);
        return nameSet;
    }

    public static boolean isMatch(Set<String> inputNameSet, Set<String> listNameSet) {
        List<String> common = new ArrayList<>(inputNameSet);
        common.retainAll(listNameSet);
        if (inputNameSet.size() == 1) {
            return common.size() >= 1;
        }

        return common.size() >= 2;
    }
}
