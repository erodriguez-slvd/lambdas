package org.example.Task11;

public class Entrant {
    private final int schoolNumber;
    private final int yearOfEntering;
    private final String lastName;

    public Entrant(int schoolNumber, int yearOfEntering, String lastName) {
        this.schoolNumber = schoolNumber;
        this.yearOfEntering = yearOfEntering;
        this.lastName = lastName;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public int getYearOfEntering() {
        return yearOfEntering;
    }

    public String getLastName() {
        return lastName;
    }
}
