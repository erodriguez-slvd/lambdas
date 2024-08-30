package org.example.Task14;

public class SupplierDiscount {
    private int customerId;
    private String storeName;
    private int discountPercentage;


    public SupplierDiscount(int customerId, String storeName, int discountPercentage) {
        this.customerId = customerId;
        this.discountPercentage = discountPercentage;
        this.storeName = storeName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public String getStoreName() {
        return storeName;
    }
}
