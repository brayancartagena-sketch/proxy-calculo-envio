package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopTest {
    @Test
    void enablesSmartShippingForCheckout() {
        Order order = new Order("o1", "c1", "Medellín", 100, 4);

        assertEquals(115.0, new Shop().createCheckout().total(order));
    }
}
