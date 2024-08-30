package org.example.Task15;

import java.math.BigDecimal;

public class StorePrice {
    private int productSku;
    private String storeTitle;
    private BigDecimal price;

    public StorePrice(int productSku, String storeTitle, BigDecimal price) {
        this.productSku = productSku;
        this.storeTitle = storeTitle;
        this.price = price;
    }

    public int getProductSku() {
        return productSku;
    }

    public String getStoreTitle() {
        return storeTitle;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
