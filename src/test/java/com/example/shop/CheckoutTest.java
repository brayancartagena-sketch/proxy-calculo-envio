package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutTest {
    @Test
    void acceptsAnyShippingCalculator() {
        Order order = new Order("o1", "c1", "Medellín", 100, 4);

        assertEquals(107.0, new Checkout(ignored -> 7.0).total(order));
    }
}
