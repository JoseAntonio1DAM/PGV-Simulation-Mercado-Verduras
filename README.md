## Descripción del Proyecto
Simulador de un mercado de verduras que implementa el problema clásico productor-consumidor usando hilos en Java.

### Empresa y Producto
- **Empresa**: Mercado Local de Verduras "Huerto Fresco"
- **Producto**: Verduras frescas (10 tipos diferentes)
- **Ubicación**: Puesto de mercado local

### Roles en la Simulación

#### Productor (Granjero)
- Genera diferentes tipos de verduras
- Tiempo de producción variable para cada verdura
- Lleva las verduras al puesto de mercado (almacén compartido)
- Espera si el puesto está lleno

#### Consumidor (Cliente)
- Compra verduras del puesto
- Tiempo de consumo variable
- Espera si no hay verduras disponibles
- Cada cliente tiene una cantidad específica a consumir

#### Recurso Compartido (Puesto de Mercado)
- Almacén con capacidad limitada (5 verduras máximo)
- Sincroniza el acceso de productores y consumidores
- Notifica cuando hay espacio disponible o productos nuevos

### Configuración Inicial
- **Productores**: Paco (10 verduras), Ramón (10 verduras)
- **Consumidores**: Faustino (5 verduras), Mr. Gentleman (10 verduras), Loquendo (5 verduras)
- **Capacidad almacén**: 5 verduras
- **Total producción**: 20 verduras
- **Total consumo**: 20 verduras
