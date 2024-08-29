package org.example.Task12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
A sequence of positive integers integerList1 and integerList2 are given. All values in each sequence are different.
Get a set (list of NumberPair values) of all value pairs that satisfy the following conditions:
the first element of the pair belongs to the sequence integerList1, the second belongs to integerList2, and both elements end with the same digit.
The NumberPair type includes <value_1> <value_2> fields.
The resulting NumberPair list must be sorted in ascending order by the first field, and if they are equal, by the second. For example:
input: {1, 2, 33, 44}, {11, 22, 13}
output: {NumberPair(1, 11), NumberPair(2, 22), NumberPair(33, 13)}
 */
public class Task12 {
    public static void main(String[] args) {
        List<Integer> integerList1 = Arrays.asList(1, 2, 33, 44);
        List<Integer> integerList2 = Arrays.asList(11, 22, 13);
        System.out.println(solution(integerList1, integerList2));
    }

    /*
    - Stream flatMap(map function): Returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element.
    - comparing(comparison parameter): Accepts a function that extracts a Comparable sort key from a type T, and returns a Comparator<T> that compares by that sort key.
    - thenComparing(comparison parameter): Returns a lexicographic-order comparator with a function that extracts a Comparable sort key.
     */

    public static List<NumberPair> solution(List<Integer> integerList1, List<Integer> integerList2) {
        return integerList1.stream().flatMap(value1 -> integerList2.stream().filter(value2 -> value1 % 10 == value2 % 10).map(value2 -> new NumberPair(value1, value2)))
                .sorted(Comparator.comparing(NumberPair::getValue1).thenComparing(NumberPair::getValue2)).collect(Collectors.toList());
    }
}
