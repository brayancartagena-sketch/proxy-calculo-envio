package com.example.shop;

public class SmartShippingCalculator implements ShippingCalculator {
    @Override
    public double calculate(Order order) {
        double base = order.weightKg() * 2.5;
        return order.city().equals("Bogotá") ? base : base + 5;
    }
}
