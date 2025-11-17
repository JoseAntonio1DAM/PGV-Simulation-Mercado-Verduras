## Descripción del Experimento
Este experimento explora el efecto de establecer diferentes prioridades en los hilos. Asignamos prioridad máxima a los productores y prioridad mínima al consumidor para observar cómo el planificador del sistema asigna tiempo de CPU.

# Configuración
Productores: 2 ("Paco-Prioridad-Alta", "Ramón-Prioridad-Alta")

Consumidores: 1 ("Consumidor-Prioridad-Baja")

Prioridades:

Productores: Thread.MAX_PRIORITY (10)

Consumidor: Thread.MIN_PRIORITY (1)

Capacidad del almacén: 5 productos

Productos a generar: 10 (5 cada productor)

Productos a consumir: 10

Tiempo de producción: 100-600ms

Tiempo de consumo: 100-600ms

# Comportamiento Esperado
Los productores tendrán más oportunidades de ejecución

Posible llenado más rápido del almacén

El consumidor podría tener menos turnos de ejecución

Comportamiento similar al Experimento 2 pero por diferente razón

# Capturas de Ejecución
(Incluir aquí capturas de pantalla de la consola)

## Análisis de Resultados
Observaciones:

Los productores completan su trabajo más rápidamente

El consumidor muestra intervalos más largos entre ejecuciones

El almacén se llena rápidamente

Similar al Experimento 2 pero causado por prioridades en lugar de tiempos

Diferencias con Experimento 2:

En Exp. 2 la lentitud era por tiempos de sleep más largos

En Exp. 3 la lentitud es por menos oportunidades de ejecución

Mismo efecto visual pero causas diferentes

## Conclusión: Las prioridades afectan la asignación de tiempo de CPU, pero en sistemas modernos con múltiples núcleos el efecto puede ser menos dramático. La sincronización mediante wait()/notify() sigue funcionando correctamente.