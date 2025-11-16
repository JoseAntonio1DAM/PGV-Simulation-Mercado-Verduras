package net.salesianos.hilos;

import java.util.Random;

import net.salesianos.fruteria.Almacen;
import net.salesianos.fruteria.Producto;

public class Consumidor extends Thread {
     private final Almacen almacen;
    private final String nombre;
    private final int productosAConsumir;
    private final int maxTiempoConsumo;
    private final Random random;
    
    public Consumidor(String nombre, Almacen almacen, int productosAConsumir, int maxTiempoConsumo) {
        super(nombre);
        this.nombre = nombre;
        this.almacen = almacen;
        this.productosAConsumir = productosAConsumir;
        this.maxTiempoConsumo = maxTiempoConsumo;
        this.random = new Random();
    }
    
    @Override
    public void run() {
        System.out.println( nombre + " listo para consumir " + productosAConsumir + " productos");
        
        for (int i = 0; i < productosAConsumir; i++) {
            try {
                // Tomar producto del almacén
                Producto producto = almacen.tomarProducto(nombre);
                
                // Simular tiempo de consumo
                int tiempoConsumo = random.nextInt(maxTiempoConsumo) + 100;
                Thread.sleep(tiempoConsumo);
                
                System.out.println( nombre + " terminó de consumir " + producto.getTipo() + " en " + tiempoConsumo + "ms");
                
            } catch (InterruptedException e) {
                System.out.println( nombre + " interrumpido");
                Thread.currentThread().interrupt();
                break;
            }
        }
        
        System.out.println( nombre + " terminó de consumir");
    }
}
