package org.example.Task15;

import java.math.BigDecimal;

public class CountryStat {
    private String countryOfOrigin;
    private int numberOfStores;
    private BigDecimal minPrice;

    public CountryStat(String countryOfOrigin, int numberOfStores, BigDecimal minPrice) {
        this.countryOfOrigin = countryOfOrigin;
        this.numberOfStores = numberOfStores;
        this.minPrice = minPrice;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public int getNumberOfStores() {
        return numberOfStores;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    @Override
    public String toString() {
        return "CountryStat{" + "countryOfOrigin='" + countryOfOrigin + '\'' + ", numberOfStores=" + numberOfStores + ", minPrice=" + minPrice + '}';
    }
}
