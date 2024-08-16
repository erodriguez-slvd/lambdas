package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
A sequence of non-empty strings stringList is given, containing only uppercase letters of the Latin alphabet.
For all strings starting with the same letter, determine their total length and obtain a sequence of strings of the form “S-C”,
where S is the total length of all strings from stringList that begin with the character C.
Order the resulting sequence in descending order of the numerical values of the sums, and for equal values of the sums, in ascending order of the C character codes. For example:
input: {“ABC”, “A”, “BCD”, “D”}
output: {“4-A”, “3-B”, “1-D”}
 */
public class Task9 {
    public static void main(String[] args) {
        String[] stringArray = {"ABC", "A", "BCD", "D"};
        System.out.println(solution(Arrays.asList(stringArray)));
    }

    /*
    Collectors.groupingBy(classifier, toList() method:
    Returns a Collector implementing a "group by" operation on input elements of type T,
    grouping elements according to a classification function, and returning the results in a Map.
    The classification function maps elements to some key type K.
    The collector produces a Map<K, List<T>> whose keys are the values resulting from applying the classification function to the input elements,
    and whose corresponding values are Lists containing the input elements which map to the associated key under the classification function.
     */
    public static List<String> solution(List<String> stringList) {
        Map<Character, Integer> letterAndLengthMap = stringList.stream().collect(Collectors.groupingBy(s->s.charAt(0), Collectors.summingInt(String::length))); //key=letter, value=counter
        return letterAndLengthMap.entrySet().stream()
                .map(entry->entry.getValue()+"-"+ entry.getKey())
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}
