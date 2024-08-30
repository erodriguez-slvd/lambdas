package org.example.Task15;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
A sequence of information about goods goodList of type Good and a sequence of prices of goods in various stores storePriceList of type StorePrice are given.
Each element of the goodList sequence includes the <product_SKU>, , <country_of_origin> fields.
Each element of the storePriceList sequence includes the <product_SKU>, <store_Title>, fields.
For each country of origin get the number of stores offering goods manufactured in that country, as well as the minimum price for goods from this country for all stores (CountryStat values).
If no product is found for a certain country that is presented in any store, then the number of stores and the minimum price are assumed to be 0. Sort the list by country of origin.
Look at the template on the end of the task before solving the problem. For example:
input: { Good(1, “milk”, “Poland”), Good(2, “milk”, “Russia”) }, { StorePrice(1, “BigShop”, BigDecimal(“12.50”)), StorePrice(1, “SushiBar”, BigDecimal(“10.50”)), StorePrice(2, “BigShop”, BigDecimal(“12.50”)) }
output: { CountryStat(“Poland”, 2, BigDecimal(“10.50)), CountryStat(“Russia”, 1, BigDecimal(“12.50")) }
An example of solving a task in AutoCode.
Task. Given a sequence of strings stringList. Get a new list of non-empty strings from stringList.
public static List<String> getStringList(List<String> stringList){
    return stringList.stream()
            .filter(string -> !string.isEmpty())
            .collect(Collectors.toList());
}
Consider that the values have already been set for stringList, and the assignment of new values is an error. Return the result of solving the problem via the function.
Look at the template on the end of the task before solving the problem. 1
 */
public class Task15 {
    public static void main(String[] args) {
        List<Good> goodList = Arrays.asList(
                new Good(1, "Poland"),
                new Good(2, "Russia"));

        List<StorePrice> storePriceList = Arrays.asList(
                new StorePrice(1, "BigShop", new BigDecimal("12.50")),
                new StorePrice(1, "SushiBar", new BigDecimal("10.50")),
                new StorePrice(2, "BigShop", new BigDecimal("12.50")));
        System.out.println(solution(goodList, storePriceList));
    }

    public static List<CountryStat> solution(List<Good> goodList, List<StorePrice> storePriceList) {
        Map<String, List<StorePrice>> storesByCountry = storePriceList.stream()
                .collect(Collectors.groupingBy(storePrice -> goodList.stream()
                        .filter(good -> good.getProductSku() == storePrice.getProductSku())
                        .map(Good::getCountryOfOrigin)
                        .findFirst()
                        .orElse("")));
        return storesByCountry.entrySet().stream()
                .map(entry -> {
                    String country = entry.getKey();
                    List<StorePrice> stores = entry.getValue();
                    int storeCount = stores.size();
                    BigDecimal minPrice = stores.stream()
                            .map(StorePrice::getPrice)
                            .min(BigDecimal::compareTo)
                            .orElse(BigDecimal.ZERO);
                    return new CountryStat(country, storeCount, minPrice);
                })
                .sorted(Comparator.comparing(CountryStat::getCountryOfOrigin))
                .collect(Collectors.toList());
    }
}
