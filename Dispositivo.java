/**
  Clase base abstracta para todos los dispositivos.
  Contiene atributos comunes y la lógica de comparación para ordenar.
  Implementa Comparable para cumplir el requisito de ordenar por consumo
 */
public abstract class Dispositivo implements Comparable<Dispositivo> {

    // Atributos encapsulados [cite: 41]
    private int id;
    private String nombre;
    private double consumoElectrico;

    public Dispositivo(int id, String nombre, double consumoElectrico) {
        this.id = id;
        this.nombre = nombre;
        this.consumoElectrico = consumoElectrico;
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getConsumoElectrico() {
        return consumoElectrico;
    }

    /**
     * Método de la interfaz Comparable.
     * Compara este dispositivo con otro basado en el consumo eléctrico.
     */
    @Override
    public int compareTo(Dispositivo otro) {
        // Ordena de menor a mayor consumo
        return Double.compare(this.consumoElectrico, otro.consumoElectrico);
    }

    /**
     * Sobrescritura de toString para mostrar la información base
     */
    @Override
    public String toString() {
        return String.format("ID: %d | Nombre: %s | Consumo: %.2fW", 
                             id, nombre, consumoElectrico);
    }
}