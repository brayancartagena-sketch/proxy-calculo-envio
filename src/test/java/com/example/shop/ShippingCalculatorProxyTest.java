package com.example.shop;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShippingCalculatorProxyTest {
    private final Order order = new Order("o1", "c1", "Medellín", 100, 4);
    private final FeatureFlags flags = new FeatureFlags();
    private final ShippingCalculatorProxy proxy = new ShippingCalculatorProxy(
            new LegacyShippingCalculator(), new SmartShippingCalculator(), flags);

    @Test
    void usesLegacyWhenFlagIsDisabled() {
        assertEquals(10.0, proxy.calculate(order));
    }

    @Test
    void usesSmartWhenFlagIsEnabled() {
        flags.enable("smart-shipping");

        assertEquals(15.0, proxy.calculate(order));
    }

    @Test
    void cachesSmartResultByOrderId() {
        AtomicInteger calls = new AtomicInteger();
        ShippingCalculatorProxy cachedProxy = new ShippingCalculatorProxy(
                new LegacyShippingCalculator(),
                ignored -> {
                    calls.incrementAndGet();
                    return 15.0;
                },
                flags);
        flags.enable("smart-shipping");

        assertEquals(15.0, cachedProxy.calculate(order));
        assertEquals(15.0, cachedProxy.calculate(order));
        assertEquals(1, calls.get());
    }

    @Test
    void doesNotCacheLegacyResultAcrossFlagChange() {
        assertEquals(10.0, proxy.calculate(order));
        flags.enable("smart-shipping");

        assertEquals(15.0, proxy.calculate(order));
    }
}
