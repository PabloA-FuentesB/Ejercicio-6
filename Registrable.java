/**
 * Define el "contrato" para dispositivos que pueden guardar un log de eventos.
 */
public interface Registrable {
    /**
     * Guarda un evento en el log interno del dispositivo.
     * @param evento El evento a registrar (ej. "Medición realizada a las 10:00").
     */
    void registrarEvento(String evento);
}