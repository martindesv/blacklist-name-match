package src.main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start program");

        String[] inputNameArray;
        inputNameArray = args[0].split(" ");

        SortedSet<String> inputNameSet =
                new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        Collections.addAll(inputNameSet, inputNameArray);

        try (Scanner scanner = new Scanner(new File(args[1]))) {
            while (scanner.hasNext()) {
                String[] listNameArray;
                listNameArray = scanner.nextLine().split(" ");
                SortedSet<String> listNameSet =
                        new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
                Collections.addAll(listNameSet, listNameArray);
                checkNames(inputNameSet, listNameSet);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void checkNames(SortedSet<String> inputNameSet, SortedSet<String> listNameSet) {
        if (inputNameSet.equals(listNameSet)) {
            System.out.println("Match found:");
            System.out.println(inputNameSet);
            System.out.println(listNameSet);
        }
    }
}
