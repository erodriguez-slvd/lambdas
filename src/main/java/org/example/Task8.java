package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
You are given a positive integer K and integer D and a sequence of integers integerList.
Compute a union of two subsets of integers: the first subset is all values of integerList greater than D, the second subset is an integer list of values starting with an element with ordinal number K inclusive (the numbering of elements in the integer list starting from 0).
Sort the resulting sequence in descending order. For example:
input: D = 3, K = 4, integerList{-10, 3, -3, 4, 55, 6}
output: {55, 6, 4}
 */
public class Task8 {
    public static void main(String[] args) {
        Integer[] integerArray = {-10, 3, -3, 4, 55, 6};
        System.out.println(solution(3, 4, Arrays.asList(integerArray)));
    }

    public static List<Integer> solution(int d, int k, List<Integer> integerList) {
        Set<Integer> result = integerList.stream().filter(e -> e > d).collect(Collectors.toSet());
        result.addAll(integerList.stream().skip(k).collect(Collectors.toSet()));
        return result.stream().sorted(Comparator.reverseOrder()).toList();
    }
}
