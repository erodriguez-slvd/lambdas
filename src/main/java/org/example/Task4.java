package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
A positive integer K and a sequence of non-empty strings stringList are given. Strings of the sequence contain only numbers and capital letters of the Latin alphabet. Get from stringList all strings of length K ending in a digit and sort them in ascending order. For example:
input: number = 2, {“8DC3”, “4F”, “B”, “3S”, “S3”, “A1", “2A3G”, “1B”}
output: {“A1”, “S3"}
 */
public class Task4 {
    public static void main(String[] args) {
        String[] stringArray = {"8DC3", "4F", "B", "3S", "S3", "A1", "2A3G", "1B"};
        System.out.println(solution(2, Arrays.asList(stringArray)));
    }

    public static List<String> solution(int k, List<String> stringList) {
        return stringList.stream().filter(e -> e.length() == k && Character.isDigit(e.charAt(e.length() - 1))).sorted().collect(Collectors.toList());
    }
}
