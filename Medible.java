/**
 * Define el "contrato" para dispositivos que pueden reportar mediciones.
 */
public interface Medible {
    /**
     * Reporta los datos medidos por el dispositivo.
     * @return Un String con los datos de la medición (ej. "Humedad: 30%").
     */
    String medirDatos();
}