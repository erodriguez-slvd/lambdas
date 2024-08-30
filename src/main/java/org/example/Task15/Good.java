package org.example.Task15;

public class Good {
    private int productSku;
    private String countryOfOrigin;

    public Good(int productSku, String countryOfOrigin) {
        this.productSku = productSku;
        this.countryOfOrigin = countryOfOrigin;
    }

    public int getProductSku() {
        return productSku;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }
}
