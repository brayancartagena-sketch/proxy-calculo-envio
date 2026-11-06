# Taller: Proxy para migrar el cálculo de envío

Proyecto de práctica con Java 25 (LTS) y JUnit 5. El cliente `Checkout` usa la
abstracción `ShippingCalculator`; durante la migración el Proxy delega según un
feature flag. En el estado final, el cálculo inteligente queda activo y el
Proxy evita repetir cálculos para el mismo `order.id()`.

Ejecuta la suite con `mvn test`. La historia se construye en commits pequeños
sobre `main`, manteniendo las pruebas verdes en cada paso.
