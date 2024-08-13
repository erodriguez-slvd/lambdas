package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
A sequence of non-empty strings stringList is given. Get a sequence of ascending sorted integer values equal to the lengths of the strings included in the stringList sequence. For example:
input: {“Hello”, “world”, “!”, “Good”, “morning”, “!”}
output: {1, 1, 4, 5, 5, 7}
 */
public class Task2 {
    public static void main(String[] args) {
        String[] stringArray = {"Hello", "world", "!", "Good", "morning", "!"};
        System.out.println(solution(Arrays.asList(stringArray)));;
    }

    public static List<Integer> solution(List<String> stringList) {
        return stringList.stream().map(e->e.length()).sorted().collect(Collectors.toList());
    }
}
