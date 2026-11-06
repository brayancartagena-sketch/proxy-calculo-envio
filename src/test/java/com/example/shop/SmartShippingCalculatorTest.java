package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmartShippingCalculatorTest {
    @Test
    void chargesOnlyWeightForBogota() {
        Order order = new Order("o1", "c1", "Bogotá", 100, 4);

        assertEquals(10.0, new SmartShippingCalculator().calculate(order));
    }

    @Test
    void addsSurchargeOutsideBogota() {
        Order order = new Order("o1", "c1", "Medellín", 100, 4);

        assertEquals(15.0, new SmartShippingCalculator().calculate(order));
    }
}
