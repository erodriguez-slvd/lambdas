package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
A sequence of positive integer values integerList is given. Get sequence of string representations of only odd integerList values and sort in ascending order. For example:
input: {1, 2, 3, 4, 5, 6}
output: {“1”, “3", “5”}
 */
public class Task5 {
    public static void main(String[] args) {
        Integer[] intArray = {1,2,3,4,5};
        System.out.println(solution(Arrays.asList(intArray)));
    }

    public static List<Integer> solution(List<Integer> integerList) {
        return integerList.stream().filter(e-> e%2!=0).collect(Collectors.toList());
    }
}
