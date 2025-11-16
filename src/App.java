import net.salesianos.fruteria.Almacen;
import net.salesianos.hilos.Consumidor;
import net.salesianos.hilos.Productor;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(" INICIANDO SIMULADOR DE MERCADO DE VERDURAS\n");
        
        // Configuración
        int capacidadAlmacen = 5;
        Almacen almacen = new Almacen(capacidadAlmacen);
        
        // Crear productores
        Productor paco = new Productor("Paco", almacen, 10, 1000);
        Productor ramon = new Productor("Ramón", almacen, 10, 1000);
        
        // Crear consumidores
        Consumidor faustino = new Consumidor("Faustino", almacen, 5, 800);
        Consumidor gentleman = new Consumidor("Mr. Gentleman", almacen, 10, 800);
        Consumidor loquendo = new Consumidor("Loquendo", almacen, 5, 800);
        
        // Iniciar hilos
        paco.start();
        ramon.start();
        
        faustino.start();
        gentleman.start();
        loquendo.start();
        
        // Esperar a que todos terminen
        try {
            paco.join();
            ramon.join();
            
            faustino.join();
            gentleman.join();
            loquendo.join();
        } catch (InterruptedException e) {
            System.out.println("Simulación interrumpida");
            Thread.currentThread().interrupt();
        }
        
        System.out.println("\n SIMULACIÓN COMPLETADA");
        System.out.println(" Productos restantes en almacén: " + almacen.getCantidadProductos());
    }
}
