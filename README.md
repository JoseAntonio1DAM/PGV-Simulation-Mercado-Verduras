## Experimento UNO

En este experimento probamos el caso más básico del problema productor-consumidor: un solo productor y un solo consumidor. Esto nos permite observar el comportamiento fundamental sin la complejidad de múltiples hilos compitiendo.

# Configuración
Productores: 1 ("Único Productor")

Consumidores: 1 ("Único Consumidor")

Capacidad del almacén: 5 productos

Productos a generar: 5

Productos a consumir: 5

Tiempo de producción: 100-600ms

Tiempo de consumo: 100-600ms

# Comportamiento Esperado
Dado que tenemos un productor y un consumidor con tiempos similares, esperamos:

Un flujo equilibrado de producción y consumo

Pocas o ninguna espera por sincronización

El almacén no debería llenarse completamente

Ejecución secuencial casi perfecta

# Capturas de Ejecución

![Imagen de la consola](./resources/image.png)

## Análisis de Resultados
Observaciones:

El productor y consumidor trabajan de manera coordinada

No se producen situaciones de espera prolongada

El almacén mantiene un nivel balanceado de productos

La simulación termina correctamente con 0 productos en almacén

#### Conclusión: El caso básico funciona correctamente, demostrando la sincronización adecuada entre un único productor y consumidor.