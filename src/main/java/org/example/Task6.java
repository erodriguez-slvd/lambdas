package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
A sequence of positive integers numbers and a sequence of strings stringList are given. Get a new sequence of strings according to the following rule: for each value n from sequence numbers, select a string from sequence stringList that starts with a digit and has length n. If Look at the template on the end of the task before solving the problem. there are several required strings in the stringList sequence, return the first; if there are none, then return the string “Not found” For example:
input: {1, 3, 4}, {“1aa”, “aaa”, “1”, “a”}
output: {“1”, “1aa”, “Not Found”}
 */
public class Task6 {
    public static void main(String[] args) {
        Integer[] intArray = {1, 3, 4};
        String[] stringArray = {"1aa", "aaa", "1", "a"};
        System.out.println(solution(Arrays.asList(intArray), Arrays.asList(stringArray)));
    }

    public static List<String> solution(List<Integer> integerList, List<String> stringList) {
        return integerList.stream().map(e -> stringList.stream().filter(s -> Character.isDigit(s.charAt(0)) && s.length() == e).findFirst().orElse("Not Found")).collect(Collectors.toList());
    }
}
