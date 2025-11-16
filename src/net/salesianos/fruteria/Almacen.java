package net.salesianos.fruteria;

import java.util.LinkedList;
import java.util.Queue;

public class Almacen {
    private final int capacidadMaxima;
    private final Queue<Producto> productos;
    
    public Almacen(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.productos = new LinkedList<>();
    }
    
    public synchronized void agregarProducto(Producto producto) throws InterruptedException {
        while (productos.size() >= capacidadMaxima) {
            System.out.println("  Almacén lleno. " + Thread.currentThread().getName() + " esperando...");
            wait();
        }
        
        productos.offer(producto);
        System.out.println( Thread.currentThread().getName() + " agregó: " + producto);
        System.out.println(" Productos en almacén: " + productos.size() + "/" + capacidadMaxima);
        
        notifyAll(); // Notificar a los consumidores que hay productos disponibles
    }
    
    public synchronized Producto tomarProducto(String consumidor) throws InterruptedException {
        while (productos.isEmpty()) {
            System.out.println(" Almacén vacío. " + consumidor + " esperando productos...");
            wait();
        }
        
        Producto producto = productos.poll();
        System.out.println(" " + consumidor + " consumió: " + producto);
        System.out.println(" Productos en almacén: " + productos.size() + "/" + capacidadMaxima);
        
        notifyAll(); // Notificar a los productores que hay espacio disponible
        return producto;
    }
    
    public synchronized int getCantidadProductos() {
        return productos.size();
    }
    
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}
