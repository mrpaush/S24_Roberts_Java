package AdvJava.Fred;

import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
       // find strings that contain the word "done"
        List<String> list = Arrays.asList("Done abc", "", "bcdone", "", "dOne here");
        System.out.println("\nStrings that contain the word \"done\":");
        list.stream()
                .filter(str -> str.toLowerCase().contains("done"))
                .forEach(System.out::println);
    }
}