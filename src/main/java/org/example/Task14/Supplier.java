package org.example.Task14;

public class Supplier {
    private int customerId;
    private int yearOfBirth;
    private String streetOfResidence;

    public Supplier(int customerId, int yearOfBirth, String streetOfResidence) {
        this.customerId = customerId;
        this.yearOfBirth = yearOfBirth;
        this.streetOfResidence = streetOfResidence;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getStreetOfResidence() {
        return streetOfResidence;
    }

    @Override
    public String toString() {
        return "Supplier{" + "customerId=" + customerId + ", yearOfBirth=" + yearOfBirth + ", streetOfResidence='" + streetOfResidence + '\'' + '}';
    }
}
