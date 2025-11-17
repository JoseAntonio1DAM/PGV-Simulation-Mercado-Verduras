package net.salesianos.utils;

import net.salesianos.fruteria.Almacen;
import net.salesianos.hilos.Consumidor;
import net.salesianos.hilos.Productor;

public class ExperimentoDos {
     public static void main(String[] args) {
        System.out.println(" EXPERIMENTO 2: Producción rápida vs consumo lento\n");
        
        Almacen almacen = new Almacen(5);
        
        // Productores rápidos (100-300ms)
        Productor paco = new Productor("Paco-Rápido", almacen, 5, 200);
        Productor ramon = new Productor("Ramón-Rápido", almacen, 5, 200);
        
        // Consumidores lentos (500-1000ms)
        Consumidor consumidor = new Consumidor("Consumidor-Lento", almacen, 10, 500);
        
        paco.start();
        ramon.start();
        consumidor.start();
        
        try {
            paco.join();
            ramon.join();
            consumidor.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("\n Experimento 2 completado");
    }
}
