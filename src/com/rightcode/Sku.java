package com.rightcode;

public class Sku {
    int price;

    DiscountRule discountRule;

    public int getPrice() {
        return price;
    }
    public Character getScanCode() {
        return scanCode;
    }

    Character scanCode;

    public DiscountRule getDiscountRule() {
        return discountRule;
    }

    public Sku(Character scanCode, int price, DiscountRule discountRule) {
        this.price = price;
        this.discountRule = discountRule;
        this.scanCode = scanCode;
    }
}
