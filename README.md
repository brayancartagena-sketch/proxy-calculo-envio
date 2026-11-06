# Proxy de envíos

Ejercicio en Java sobre el patrón Proxy. El costo de envío depende del peso y
la ciudad; el proxy guarda el cálculo inteligente para cada pedido.

El cálculo inteligente está activo por defecto. Para crear un checkout con el
cálculo anterior, pasa un `FeatureFlags` sin activar `smart-shipping`:

```java
FeatureFlags flags = new FeatureFlags();
Checkout checkout = new Shop(flags).createCheckout();
```

Puedes activar o desactivar la regla con
`flags.enable(FeatureFlags.SMART_SHIPPING)` y
`flags.disable(FeatureFlags.SMART_SHIPPING)`. El historial de Git conserva los
pasos incrementales: extracción de la interfaz, inyección en `Checkout`, proxy
con el flag apagado, reglas del cálculo inteligente por separado, activación y
limpieza del código legado.

Para ejecutar las pruebas:

```bash
mvn test
```
