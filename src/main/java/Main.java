package src.main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start program");

        String[] inputNameArray;
        inputNameArray = args[0].split(" ");

        HashSet<String> inputNameSet = new HashSet<String>(Arrays.asList(inputNameArray));

        try (Scanner scanner = new Scanner(new File(args[1]))) {
            while (scanner.hasNext()) {
                String[] listNameArray;
                listNameArray = scanner.nextLine().split(" ");
                HashSet<String> listNameSet = new HashSet<String>(Arrays.asList(listNameArray));
                checkNames(inputNameSet, listNameSet);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void checkNames(HashSet<String> inputNameSet, HashSet<String> listNameSet) {
        inputNameSet.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        listNameSet.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());

        System.out.println(inputNameSet);
        if (inputNameSet.equals(listNameSet)) {
            System.out.println("Match found:");
            System.out.println(inputNameSet);
            System.out.println(listNameSet);
        }
    }
}
