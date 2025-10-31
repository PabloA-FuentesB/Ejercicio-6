import java.util.ArrayList;

/**
 * Clase concreta para una Estación Meteorológica.
 * [cite_start]Implementa Medible y Registrable[cite: 7, 32].
 */
public class EstacionMeteorologica extends Dispositivo implements Medible, Registrable {

    private ArrayList<String> logEventos;

    public EstacionMeteorologica(int id, String nombre, double consumoElectrico) {
        super(id, nombre, consumoElectrico);
        this.logEventos = new ArrayList<>();
    }

    @Override
    public String medirDatos() {
        double temp = Math.random() * 15 + 10; // Temp aleatoria entre 10 y 25
        double viento = Math.random() * 20;
        String reporte = String.format("Medición de %s: Temp: %.1f°C, Viento: %.1f km/h", 
                                       getNombre(), temp, viento);
        registrarEvento("Medición realizada: " + reporte); // Usa su propia capacidad
        return reporte;
    }

    @Override
    public void registrarEvento(String evento) {
        this.logEventos.add(evento);
    }

    @Override
    public String toString() {
        return super.toString() + 
               String.format(" | Tipo: Estación Meteorológica | Eventos: %d", logEventos.size());
    }
}