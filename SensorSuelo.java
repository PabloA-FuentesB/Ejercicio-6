/**
 * Clase concreta para un Sensor de Suelo.
 * Hereda de Dispositivo e implementa la interfaz Medible
 */
public class SensorSuelo extends Dispositivo implements Medible {

    private String tipoSuelo;

    public SensorSuelo(int id, String nombre, double consumoElectrico, String tipoSuelo) {
        super(id, nombre, consumoElectrico); // Llama al constructor padre
        this.tipoSuelo = tipoSuelo;
    }

    @Override
    public String medirDatos() {
        // Simula una medición
        double humedad = Math.random() * 50 + 20; // Humedad aleatoria entre 20 y 70
        return String.format("Medición de %s: Humedad %.1f%%", getNombre(), humedad);
    }

    /**
     * Sobrescribe toString para añadir información específica de esta clase
     */
    @Override
    public String toString() {
        return super.toString() + 
               String.format(" | Tipo: Sensor de Suelo | Suelo: %s", tipoSuelo);
    }
}