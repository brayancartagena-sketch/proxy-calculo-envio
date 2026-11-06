package com.example.shop;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShippingCalculatorProxyTest {
    private final Order order = new Order("o1", "c1", "Medellín", 100, 4);
    private final ShippingCalculatorProxy proxy = new ShippingCalculatorProxy(
            new SmartShippingCalculator());

    @Test
    void delegatesToSmartCalculator() {
        assertEquals(15.0, proxy.calculate(order));
    }

    @Test
    void cachesSmartResultByOrderId() {
        AtomicInteger calls = new AtomicInteger();
        ShippingCalculatorProxy cachedProxy = new ShippingCalculatorProxy(
                ignored -> {
                    calls.incrementAndGet();
                    return 15.0;
                });

        assertEquals(15.0, cachedProxy.calculate(order));
        assertEquals(15.0, cachedProxy.calculate(order));
        assertEquals(1, calls.get());
    }
}
