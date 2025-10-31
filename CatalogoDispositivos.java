import java.util.ArrayList;
import java.util.Collections;

/**
 * (MODELO) [cite_start]Gestiona la única lista polimórfica de dispositivos[cite: 25, 30].
 * Contiene la lógica de negocio (buscar, ordenar, cargar).
 */
public class CatalogoDispositivos {

    // La única lista polimórfica requerida
    private ArrayList<Dispositivo> dispositivos;

    public CatalogoDispositivos() {
        this.dispositivos = new ArrayList<>();
    }

    /**
     * [cite_start]Carga el catálogo inicial con al menos 10 equipos diversos[cite: 13].
     */
    public void cargarDatosIniciales() {
        dispositivos.add(new SensorSuelo(101, "Sensor Humedad A", 5.5, "Arcilloso"));
        dispositivos.add(new EstacionMeteorologica(201, "Estación Central", 25.0));
        dispositivos.add(new Dron(301, "Dron Riego 1", 150.0, 100.0));
        dispositivos.add(new SensorSuelo(102, "Sensor pH B", 4.0, "Arenoso"));
        dispositivos.add(new Dron(302, "Dron Monitoreo", 120.5, 100.0));
        dispositivos.add(new EstacionMeteorologica(202, "Estación Norte", 22.0));
        dispositivos.add(new SensorSuelo(103, "Sensor Temp. A", 5.0, "Limoso"));
        dispositivos.add(new Dron(303, "Dron Fumigador", 175.0, 100.0));
        dispositivos.add(new SensorSuelo(104, "Sensor Humedad B", 5.5, "Arcilloso"));
        dispositivos.add(new EstacionMeteorologica(203, "Estación Sur", 23.5));
    }

    /**
     * Devuelve la lista completa de dispositivos.
     */
    public ArrayList<Dispositivo> getDispositivos() {
        return this.dispositivos;
    }

    /**
     * Busca un dispositivo por su ID.
     * @param id El ID a buscar.
     * @return El Dispositivo encontrado, o null si no existe.
     */
    public Dispositivo buscar(int id) {
        for (Dispositivo d : dispositivos) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null; // No encontrado
    }

    /**
     * [cite_start]Busca un dispositivo por su Nombre (Sobrecarga de método)[cite: 23].
     * @param nombre El nombre a buscar (ignora mayúsculas/minúsculas).
     * @return El Dispositivo encontrado, o null si no existe.
     */
    public Dispositivo buscar(String nombre) {
        for (Dispositivo d : dispositivos) {
            if (d.getNombre().equalsIgnoreCase(nombre)) {
                return d;
            }
        }
        return null; // No encontrado
    }

    /**
     * Ordena la lista interna de dispositivos usando el método compareTo 
     * (definido en Dispositivo) [cite_start][cite: 16].
     */
    public void ordenarPorConsumo() {
        // Collections.sort usa el método compareTo de la interfaz Comparable
        Collections.sort(dispositivos);
    }
}