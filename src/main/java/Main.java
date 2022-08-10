package src.main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start program");
        try (Scanner scanner = new Scanner(new File(args[1]))) {
            while (scanner.hasNext()) {
                checkNames(scanner.nextLine(), args[0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void checkNames(String line, String blacklistedName) {
        System.out.println(line.equals(blacklistedName));
    }
}
