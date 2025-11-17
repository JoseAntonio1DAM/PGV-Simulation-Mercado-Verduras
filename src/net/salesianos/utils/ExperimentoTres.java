package net.salesianos.utils;

import net.salesianos.fruteria.Almacen;
import net.salesianos.hilos.Consumidor;
import net.salesianos.hilos.Productor;

public class ExperimentoTres {
     public static void main(String[] args) {
        System.out.println(" EXPERIMENTO 3: Prioridades en hilos\n");
        
        Almacen almacen = new Almacen(5);
        
        Productor paco = new Productor("Paco-Prioridad-Alta", almacen, 5, 500);
        Productor ramon = new Productor("Ramón-Prioridad-Alta", almacen, 5, 500);
        Consumidor consumidor = new Consumidor("Consumidor-Prioridad-Baja", almacen, 10, 500);
        
        // Establecer prioridades
        paco.setPriority(Thread.MAX_PRIORITY);
        ramon.setPriority(Thread.MAX_PRIORITY);
        consumidor.setPriority(Thread.MIN_PRIORITY);
        
        System.out.println("Prioridades - Productores: " + paco.getPriority() + 
                          ", Consumidor: " + consumidor.getPriority());
        
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
        
        System.out.println("\n Experimento 3 completado");
    }
}
