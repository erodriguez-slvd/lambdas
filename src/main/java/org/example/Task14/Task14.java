package org.example.Task14;

import org.example.Task13.Entrant;
import org.example.Task13.YearSchoolStat;

import java.util.*;
import java.util.stream.Collectors;

/*
A sequence of customer information for a supplierList of type Supplier and a sequence of discounts for customers in various stores, supplierDiscountList of type SupplierDiscount is given.
Each element of the supplierList sequence includes the fields <customer_ID>, <year_of_birth>, <street_of_residence>.
Each element of the supplierDiscountList sequence includes the fields <customer_ID>, <store_name>, <discount_percentage>.
Get a list (maxDiscountOwner values) of all stores and for each store find a customer who has the maximum discount in it.
If for a certain store there are several customers with the maximum discount, then take the data on the consumer with the minimum code.
Sort the list by store names in ascending alphabetical order. Call stream() for both lists. For example:
input: { Supplier(1, 1993, “Sumskaya”) Supplier(2, 1994, “Pushkinskaya”) Supplier(3, 1995, “Beketova”) Supplier(4, 1996, “Amosova”) Supplier(5, 1996, “Amosova”)
SupplierDiscount(1, 9, “Posad”) SupplierDiscount(2, 9, “Posad”) SupplierDiscount(3, 10, “Colins”) SupplierDiscount(4, 10, “Colins”) SupplierDiscount(5, 10, “Denim”) }
output: { (“Colins”, new Supplier(3, 1995, “Beketova”)) (“Denim”, new Supplier(5, 1996, “Amosova”)) (“Posad”, new Supplier(1, 1993, “Sumskaya”)) }
 */
public class Task14 {
    public static void main(String[] args) {
        List<Supplier> supplierList = Arrays.asList(
                new Supplier(1, 1993, "Sumskaya"),
                new Supplier(2, 1994, "Pushkinskaya"),
                new Supplier(3, 1995, "Beketova"),
                new Supplier(4, 1996, "Amosova"),
                new Supplier(5, 1996, "Amosova")
        );
        List<SupplierDiscount> supplierDiscountList = Arrays.asList(
                new SupplierDiscount(1, "Posad", 9),
                new SupplierDiscount(2, "Posad", 9),
                new SupplierDiscount(3, "Colins", 10),
                new SupplierDiscount(4, "Colins", 10),
                new SupplierDiscount(5, "Denim", 10)
        );
        System.out.println(solution(supplierList, supplierDiscountList));
    }

    public static Map<String, Supplier> solution(List<Supplier> supplierList, List<SupplierDiscount> supplierDiscountList) {
        return new TreeMap<>(supplierDiscountList.stream()
                .collect(Collectors.groupingBy(SupplierDiscount::getStoreName,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(SupplierDiscount::getDiscountPercentage)
                                        .thenComparingInt(supplierDiscount -> (-1) * supplierDiscount.getCustomerId())),
                                Optional::get)))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e -> supplierList.stream()
                                .filter(s -> s.getCustomerId() == e.getValue().getCustomerId())
                                .findFirst()
                                .get())));
    }
}
