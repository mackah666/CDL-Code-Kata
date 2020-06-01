package com.rightcode;

public class Sku {
    int price;

    public int getPrice() {
        return price;
    }
    public Character getScanCode() {
        return scanCode;
    }

    Character scanCode;

    public Sku(Character scanCode, int price) {
        this.price = price;
        this.scanCode = scanCode;
    }
}
