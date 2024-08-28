package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
A sequence of non-empty strings of Latin alphabet characters stringList is given.
Select the last character from each string, converting it to uppercase.
Return sorted sequence of characters in descending order by initial string length. For example:
input: {“asnsbiu”, “asdsad”, “asnsb”, “asdf”, “asdfb”, “as”, “a”, “aop”}
output: {‘U’, ‘D’, ‘B’, ‘B’, ‘F’, ‘P’, ‘S’, ‘A’}
 */
public class Task10 {
    public static void main(String[] args) {
        String[] stringArray = {"asnsbiu", "asdsad", "asnsb", "asdf", "asdfb", "as", "a", "aop"};
        System.out.println(solution(Arrays.asList(stringArray)));
    }

    public static List<String> solution(List<String> stringList) {
        return stringList.stream().sorted(Comparator.comparingInt(String::length).reversed()).map(e -> String.valueOf(e.charAt(e.length() - 1)).toUpperCase()).collect(Collectors.toList());
    }
}
