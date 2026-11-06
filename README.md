# Taller: Proxy para migrar el cálculo de envío

Proyecto de práctica con Java 17 y JUnit 5. El cliente `Checkout` usa la
abstracción `ShippingCalculator`; el Proxy permite introducir el cálculo nuevo
gradualmente y, en el estado final, evita repetir cálculos para el mismo
`order.id()`.

Ejecuta la suite con `mvn test`. La historia se construye en commits pequeños
sobre `main`, manteniendo las pruebas verdes en cada paso.
