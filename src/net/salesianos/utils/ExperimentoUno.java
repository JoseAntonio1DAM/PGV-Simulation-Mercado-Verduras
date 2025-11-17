package net.salesianos.utils;

import net.salesianos.fruteria.Almacen;
import net.salesianos.hilos.Consumidor;
import net.salesianos.hilos.Productor;

public class ExperimentoUno {
    public static void main(String[] args) {
        System.out.println("🔬 EXPERIMENTO 1: Un productor y un consumidor\n");
        
        Almacen almacen = new Almacen(5);
        
        Productor productor = new Productor("Único Productor", almacen, 5, 500);
        Consumidor consumidor = new Consumidor("Único Consumidor", almacen, 5, 500);
        
        productor.start();
        consumidor.start();
        
        try {
            productor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("\n🏁 Experimento 1 completado");
    }
}
