/**
 * Define el "contrato" para dispositivos que pueden ejecutar una acción.
 */
public interface Accionable {
    /**
     * Ejecuta una acción específica.
     * @param accion La descripción de la acción a realizar (ej. "regar").
     * @return Un String con el resultado de la acción (ej. "Regando Parcela 5").
     */
    String ejecutarAccion(String accion);
}