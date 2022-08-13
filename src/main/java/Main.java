package src.main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Start program");
        System.out.println();
        String[] inputNameArray;
        inputNameArray = args[0].split(" ");

        Set<String> inputNameSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Collections.addAll(inputNameSet, inputNameArray);

        try (Scanner scanner = new Scanner(new File(args[1]))) {
            while (scanner.hasNext()) {
                String[] listNameArray;
                listNameArray = scanner.nextLine().split(" ");
                Set<String> listNameSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                Collections.addAll(listNameSet, listNameArray);
                checkNames(inputNameSet, listNameSet);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void checkNames(Set<String> inputNameSet, Set<String> listNameSet) {
        List<String> common = new ArrayList<>(inputNameSet);
        common.retainAll(listNameSet);
        if (common.size() >= 2) {
            System.out.println("inputNameSet " + inputNameSet);
            System.out.println("listNameSet " + listNameSet);
            System.out.println("Match is found!");
        }
    }
}
