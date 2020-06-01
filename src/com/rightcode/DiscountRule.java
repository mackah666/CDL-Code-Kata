package com.rightcode;

public class DiscountRule {
    int discountAmount;

    public int getDiscountAmount() {
        return discountAmount;
    }

    public int getDiscountQuantity() {
        return discountQuantity;
    }

    int discountQuantity;

    public DiscountRule(int discountAmount, int discountQuantity) {
        this.discountAmount = discountAmount;
        this.discountQuantity = discountQuantity;
    }
}
