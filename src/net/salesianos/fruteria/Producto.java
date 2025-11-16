package net.salesianos.fruteria;

public class Producto {
    private static int contadorId = 1;
    private final int id;
    private final String tipo;
    private final String productor;
    private final int tiempoProduccion;
    
    public Producto(String tipo, String productor, int tiempoProduccion) {
        this.id = contadorId++;
        this.tipo = tipo;
        this.productor = productor;
        this.tiempoProduccion = tiempoProduccion;
    }
    
    // Getters
    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public String getProductor() { return productor; }
    public int getTiempoProduccion() { return tiempoProduccion; }
    
    @Override
    public String toString() {
        return String.format("Producto%d[%s, producido por: %s, tiempo: %dms]", 
                           id, tipo, productor, tiempoProduccion);
    }
}
