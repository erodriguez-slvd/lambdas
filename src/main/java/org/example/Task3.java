package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
A sequence of non-empty strings stringList is given. Get a new sequence of strings, where each string consists of the first and last characters of the corresponding string in the stringList sequence. For example:
input: {“asd”, “a”, “basdw”}
output: {“ad”, “aa”, “bw”}
 */
public class Task3 {
    public static void main(String[] args) {
        String[] stringArray = {"asd", "a", "basdw"};
        solution(Arrays.asList(stringArray));
    }
    public static void solution(List<String> stringList) {
        stringList.stream().map(e->{
            if (e.length()==1){
                return e+e;
            }else {
                return ""+e.charAt(0)+e.charAt(e.length()-1);
            }
        }).toList().forEach(System.out::println);
    }
}
