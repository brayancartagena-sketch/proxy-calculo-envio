package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopTest {
    private final Order order = new Order("o1", "c1", "Medellín", 100, 4);

    @Test
    void enablesSmartShippingForCheckout() {
        assertEquals(115.0, new Shop().createCheckout().total(order));
    }

    @Test
    void usesLegacyShippingWhenSmartShippingIsDisabled() {
        FeatureFlags flags = new FeatureFlags();

        assertEquals(110.0, new Shop(flags).createCheckout().total(order));
    }

    @Test
    void canSwitchBackToLegacyShippingAfterEnablingSmartShipping() {
        FeatureFlags flags = new FeatureFlags();
        Shop shop = new Shop(flags);
        flags.enable(FeatureFlags.SMART_SHIPPING);
        assertEquals(115.0, shop.createCheckout().total(order));

        flags.disable(FeatureFlags.SMART_SHIPPING);

        assertEquals(110.0, shop.createCheckout().total(order));
    }
}
