package com.example.shop;

public class Checkout {
    private final ShippingCalculator calc;

    public Checkout(ShippingCalculator calc) {
        this.calc = calc;
    }

    public double total(Order order) {
        return order.subtotal() + calc.calculate(order);
    }
}
