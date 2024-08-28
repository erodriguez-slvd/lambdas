package org.example;
/*
You are given a positive integer K and a sequence of integers integerList.
Calculate the symmetrical difference between two subsets of integer values: the first subset is all even integerList values,
the second subset is the integerList values excluding the first K elements.
In the resulting difference, replace the order with the reversed.
input: number = 5, {1, 2, 3, 4, 5, 6, 7, 8, 9}
output: {9, 7, 4, 2}
 */

import java.util.*;
import java.util.stream.Collectors;

public class Task7 {
    public static void main(String[] args) {
        Integer[] integerArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(solution(5, Arrays.asList(integerArray)));
    }

    public static List<Integer> solution(int k, List<Integer> integerList) {
        Set<Integer> evenIntegers = integerList.stream().filter(n -> n % 2 == 0).collect(Collectors.toSet()); //[2 4 6 8]
        Set<Integer> secondSubset = integerList.stream().skip(k).collect(Collectors.toSet()); //[6 7 8 9]

        Set<Integer> result = new HashSet<>(evenIntegers);
        result.addAll(secondSubset);
        result.removeAll(evenIntegers.stream().filter(secondSubset::contains).collect(Collectors.toList()));
        return result.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}
