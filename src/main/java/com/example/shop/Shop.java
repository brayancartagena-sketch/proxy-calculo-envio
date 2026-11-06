package com.example.shop;

public class Shop {
    private final FeatureFlags flags;

    public Shop() {
        this(new FeatureFlags());
        flags.enable(FeatureFlags.SMART_SHIPPING);
    }

    public Shop(FeatureFlags flags) {
        this.flags = flags;
    }

    public Checkout createCheckout() {
        ShippingCalculator calculator = new ShippingCalculatorProxy(
                new LegacyShippingCalculator(), new SmartShippingCalculator(), flags);
        return new Checkout(calculator);
    }
}
