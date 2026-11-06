package com.example.shop;

public class Checkout {
    private final LegacyShippingCalculator calc = new LegacyShippingCalculator();

    public double total(Order order) {
        return order.subtotal() + calc.calculate(order);
    }
}
