package com.example.shop;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ShippingCalculatorProxy implements ShippingCalculator {
    private final ShippingCalculator smart;
    private final ConcurrentMap<String, Double> smartResults = new ConcurrentHashMap<>();

    public ShippingCalculatorProxy(ShippingCalculator smart) {
        this.smart = smart;
    }

    @Override
    public double calculate(Order order) {
        return smartResults.computeIfAbsent(order.id(), ignored -> smart.calculate(order));
    }
}
