package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class CheckoutTest {
    @Test
    void legacyImplementsShippingCalculator() {
        assertInstanceOf(ShippingCalculator.class, new LegacyShippingCalculator());
    }

    @Test
    void calculatesTotalUsingLegacyShipping() {
        Order order = new Order("o1", "c1", "Medellín", 100, 4);

        assertEquals(110.0, new Checkout().total(order));
    }
}
