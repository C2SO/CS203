package Optimal;

import java.io.*;
import java.util.*;

public class OptimalContainer {

    private File runFile;
    private static Scanner read;

    public OptimalContainer(String fileName) {
        this.runFile = fileName;
    }

    public void run() {
        try {
            read = new Scanner(runFile);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find input file. Program will now exit.");
            return;
        }
    }
}