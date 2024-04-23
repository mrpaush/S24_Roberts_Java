package AdvJava.Fred;

import java.util.*;
import java.util.stream.Collectors;

public class Problem2 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
        System.out.printf("%nStrings: %s%n", strList);
        //code goes here use lambda to remove empty
        System.out.printf("%nStrings with more with 1 or more characters: %s%n", strList.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList()));
    }
}
//geting a remove error becaus

