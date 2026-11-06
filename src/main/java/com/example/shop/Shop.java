package com.example.shop;

public class Shop {
    public Checkout createCheckout() {
        FeatureFlags flags = new FeatureFlags();
        flags.enable("smart-shipping");

        ShippingCalculator calculator = new ShippingCalculatorProxy(
                new LegacyShippingCalculator(), new SmartShippingCalculator(), flags);
        return new Checkout(calculator);
    }
}
