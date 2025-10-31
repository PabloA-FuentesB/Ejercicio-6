import java.util.ArrayList;

/**
 * Clase concreta para un Dron.
 * [cite_start]Es un dispositivo complejo que implementa las tres interfaces[cite: 7, 32].
 */
public class Dron extends Dispositivo implements Medible, Accionable, Registrable {

    private double nivelBateria;
    private ArrayList<String> logEventos;

    public Dron(int id, String nombre, double consumoElectrico, double bateriaInicial) {
        super(id, nombre, consumoElectrico);
        this.nivelBateria = bateriaInicial;
        this.logEventos = new ArrayList<>();
    }

    @Override
    public String medirDatos() {
        // El dron mide su propia batería
        String reporte = String.format("Medición de %s: Nivel de Batería: %.1f%%", 
                                       getNombre(), nivelBateria);
        registrarEvento("Reporte de batería.");
        return reporte;
    }

    @Override
    public String ejecutarAccion(String accion) {
        if (nivelBateria > 10) {
            nivelBateria -= 5; // Simula gasto de batería
            String resultado = String.format("Dron %s ejecutando: %s. Batería restante: %.1f%%", 
                                             getNombre(), accion, nivelBateria);
            registrarEvento("Acción: " + accion);
            return resultado;
        } else {
            String error = String.format("Acción '%s' fallida. Batería baja (%.1f%%).", 
                                         accion, nivelBateria);
            registrarEvento(error);
            return error;
        }
    }

    @Override
    public void registrarEvento(String evento) {
        this.logEventos.add(evento);
    }

    @Override
    public String toString() {
        return super.toString() + 
               String.format(" | Tipo: Dron | Batería: %.1f%%", nivelBateria);
    }
}