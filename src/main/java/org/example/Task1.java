package org.example;
/*
The character C and a sequence of non-empty strings stringList are given. Get a new sequence of strings with more than one character from the stringList, starting and ending with C. For example:
input: Symbol = ‘a’, {“Hello”, “qwerty”, “asda”, “asdfa”, “as”, “a”}
output: {“asda”, “asdfa”}

 */

import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        String[] stringArray = {"Hello", "qwerty", "asda", "asdfa", "as", "a"};
        solution("a", Arrays.asList(stringArray));
    }
    public static void solution(String c, List<String> stringList) {
        stringList.stream().filter(e->e.startsWith(c)).filter(a->a.endsWith(c)).forEach(System.out::println);
    }
}
