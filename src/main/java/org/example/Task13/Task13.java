package org.example.Task13;

import java.util.*;
import java.util.stream.Collectors;

/*
A sequence of data about applicants nameList of type Entrant and a sequence of integers yearList representing years are given.
Each element of the nameList sequence includes the fields <school_number> <year_of_entering> <last_name>.
Get data (a list of YearSchoolStat values) about the number of different schools that applicants graduated from, for each year from the yearList.
YearSchoolStat includes < year_of_entering> <number_of_schools> fields. If in the given year of admission there are no applicants from the listed schools, indicate zero in the field < number_of_schools >.
The YearSchoolStat list must be sorted in ascending order by the number of schools, and for matching values, in ascending order by the year number. For example:
input: { 2001, 1999, 2000, 2002, 2003 }
{ (11, 2003, “Ivanov”), (11, 2001, “Petrov”), (11, 2001, “Pupkin”), (10, 1999, “Zobkin”), (10, 1999, “Zabkin”), (10, 1999, “Ivanov”), (10, 2000, “Petrov”), (14, 2001, “Pupkin”), (15, 2000, “Zobkin”), (10, 2000, “Ivanov”), (12, 2003, “Petrov”), (11, 2003, “Pupkin”), (10, 2003, “Zobkin”), }
output: { (2002, 0), (1999, 1), (2000, 2) (2001, 2) (2003, 3) }
 */
public class Task13 {
    public static void main(String[] args) {
        List<Integer> yearList = Arrays.asList(2001, 1999, 2000, 2002, 2003);
        List<Entrant> nameList = Arrays.asList(
                new Entrant(11, 2003, "Ivanov"),
                new Entrant(11, 2001, "Petrov"),
                new Entrant(11, 2001, "Pupkin"),
                new Entrant(10, 1999, "Zobkin"),
                new Entrant(10, 1999, "Zabkin"),
                new Entrant(10, 1999, "Ivanov"),
                new Entrant(10, 2000, "Petrov"),
                new Entrant(14, 2001, "Pupkin"),
                new Entrant(15, 2000, "Zobkin"),
                new Entrant(10, 2000, "Ivanov"),
                new Entrant(12, 2003, "Petrov"),
                new Entrant(11, 2003, "Pupkin"),
                new Entrant(10, 2003, "Zobkin")
        );
        System.out.println(solution(nameList, yearList));
    }

    public static List<YearSchoolStat> solution(List<Entrant> nameList, List<Integer> yearList) {
        Map<Integer, Set<Integer>> yearMap = nameList.stream().collect(Collectors.groupingBy(Entrant::getYearOfEntering, Collectors.mapping(Entrant::getSchoolNumber, Collectors.toSet())));
        return yearList.stream()
                .map(year -> new YearSchoolStat(year, yearMap.getOrDefault(year, Collections.emptySet()).size()))
                .sorted(Comparator.comparingInt(YearSchoolStat::getNumberOfSchools)
                        .thenComparingInt(YearSchoolStat::getYearOfEntering))
                .collect(Collectors.toList());
    }
}
