package org.example.Task11;

public class YearSchoolStat {
    private final int yearOfEntering;
    private final int numberOfSchools;

    public YearSchoolStat(int yearOfEntering, int numberOfSchools) {
        this.yearOfEntering = yearOfEntering;
        this.numberOfSchools = numberOfSchools;
    }

    @Override
    public String toString() {
        return "YearSchoolStat{" + "yearOfEntering=" + yearOfEntering + ", numberOfSchools=" + numberOfSchools + '}';
    }

    public int getYearOfEntering() {
        return yearOfEntering;
    }

    public int getNumberOfSchools() {
        return numberOfSchools;
    }
}
