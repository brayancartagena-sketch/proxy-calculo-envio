package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShippingCalculatorProxyTest {
    private final Order order = new Order("o1", "c1", "Medellín", 100, 4);
    private final FeatureFlags flags = new FeatureFlags();
    private final ShippingCalculatorProxy proxy = new ShippingCalculatorProxy(
            new LegacyShippingCalculator(), ignored -> 0.0, flags);

    @Test
    void usesLegacyWhenFlagIsDisabled() {
        assertEquals(10.0, proxy.calculate(order));
    }

    @Test
    void usesSmartWhenFlagIsEnabled() {
        flags.enable("smart-shipping");

        assertEquals(0.0, proxy.calculate(order));
    }
}
