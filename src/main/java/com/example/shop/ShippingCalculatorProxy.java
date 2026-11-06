package com.example.shop;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ShippingCalculatorProxy implements ShippingCalculator {
    private final ShippingCalculator legacy;
    private final ShippingCalculator smart;
    private final FeatureFlags flags;
    private final ConcurrentMap<String, Double> smartResults = new ConcurrentHashMap<>();

    public ShippingCalculatorProxy(ShippingCalculator legacy,
                                   ShippingCalculator smart,
                                   FeatureFlags flags) {
        this.legacy = legacy;
        this.smart = smart;
        this.flags = flags;
    }

    @Override
    public double calculate(Order order) {
        if (!flags.isEnabled("smart-shipping")) {
            return legacy.calculate(order);
        }
        return smartResults.computeIfAbsent(order.id(), ignored -> smart.calculate(order));
    }
}
