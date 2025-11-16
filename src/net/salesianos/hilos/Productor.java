package net.salesianos.hilos;

import java.util.Random;

import net.salesianos.fruteria.Almacen;
import net.salesianos.fruteria.Producto;

public class Productor extends Thread {
    private final Almacen almacen;
    private final String nombre;
    private final int productosAGenerar;
    private final int maxTiempoProduccion;
    private final String[] tiposProducto = {
        "Lechuga", "Tomate", "Zanahoria", "Pepino", "Pimiento", 
        "Cebolla", "Brócoli", "Espinaca", "Calabacín", "Berenjena"
    };
    private final Random random;
    
    public Productor(String nombre, Almacen almacen, int productosAGenerar, int maxTiempoProduccion) {
        super(nombre);
        this.nombre = nombre;
        this.almacen = almacen;
        this.productosAGenerar = productosAGenerar;
        this.maxTiempoProduccion = maxTiempoProduccion;
        this.random = new Random();
    }
    
    @Override
    public void run() {
        System.out.println( nombre + " comenzó a producir " + productosAGenerar + " productos");
        
        for (int i = 0; i < productosAGenerar; i++) {
            try {
                // Simular tiempo de producción
                int tiempoProduccion = random.nextInt(maxTiempoProduccion) + 100;
                Thread.sleep(tiempoProduccion);
                
                // Crear producto
                String tipoProducto = tiposProducto[random.nextInt(tiposProducto.length)];
                Producto producto = new Producto(tipoProducto, nombre, tiempoProduccion);
                
                // Agregar al almacén
                almacen.agregarProducto(producto);
                
            } catch (InterruptedException e) {
                System.out.println(nombre + " interrumpido");
                Thread.currentThread().interrupt();
                break;
            }
        }
        
        System.out.println(  nombre + " terminó de producir");
    }
}
