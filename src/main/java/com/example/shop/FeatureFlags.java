package com.example.shop;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FeatureFlags {
    public static final String SMART_SHIPPING = "smart-shipping";

    private final Set<String> enabled = ConcurrentHashMap.newKeySet();

    public void enable(String name) {
        enabled.add(name);
    }

    public void disable(String name) {
        enabled.remove(name);
    }

    public boolean isEnabled(String name) {
        return enabled.contains(name);
    }
}
