/**
 * (CONTROLADOR) Conecta la Vista (Principal) con el Modelo (CatalogoDispositivos).
 * [cite_start]Contiene la lógica de la aplicación (el bucle del menú)[cite: 34].
 */
public class Controlador {

    private CatalogoDispositivos modelo;
    private Principal vista;

    public Controlador(CatalogoDispositivos modelo, Principal vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    /**
     * Inicia la ejecución del programa.
     */
    public void run() {
        // Carga los datos iniciales al arrancar 
        modelo.cargarDatosIniciales();
        
        // Bucle controlado por variable, NO "while(true)" 
        boolean seguir = true; 
        
        while (seguir) {
            int opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1: // Listar
                    vista.mostrarDispositivos(modelo.getDispositivos());
                    break;
                
                case 2: // Buscar por ID
                    int id = vista.solicitarId();
                    if (id != -1) {
                        vista.mostrarDispositivo(modelo.buscar(id));
                    } else {
                        vista.mostrarError("ID inválido. Debe ser un número.");
                    }
                    break;

                case 3: // Buscar por Nombre
                    String nombre = vista.solicitarNombre();
                    vista.mostrarDispositivo(modelo.buscar(nombre));
                    break;
                
                case 4: // Ordenar por Consumo
                    modelo.ordenarPorConsumo();
                    vista.mostrarMensaje("Catálogo ordenado por consumo eléctrico.");
                    vista.mostrarDispositivos(modelo.getDispositivos());
                    break;
                
                case 5: // Salir
                    seguir = false;
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;

                default:
                    vista.mostrarError("Opción no válida. Intente de nuevo.");
            }
        }
        
        vista.cerrarScanner();
    }
}