package com.example.shop;

public class Shop {
    public Checkout createCheckout() {
        ShippingCalculator calculator = new ShippingCalculatorProxy(new SmartShippingCalculator());
        return new Checkout(calculator);
    }
}
