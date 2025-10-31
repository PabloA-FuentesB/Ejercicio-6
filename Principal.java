import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * (VISTA) ÚNICA clase responsable de interactuar con el usuario.
 * AHORA TAMBIÉN ES EL PUNTO DE ENTRADA (main) DE LA APLICACIÓN.
 */
public class Principal {

    private Scanner scanner;

    public Principal() {
        this.scanner = new Scanner(System.in);
    }

    // --- PUNTO DE ENTRADA DE LA APLICACIÓN ---
    /**
     * Punto de entrada de la aplicación.
     * Crea e "inyecta" las dependencias del MVC y luego inicia el Controlador.
     */
    public static void main(String[] args) {
        // 1. Crear la Vista (una instancia de esta misma clase)
        Principal vista = new Principal();
        
        // 2. Crear el Modelo
        CatalogoDispositivos modelo = new CatalogoDispositivos();
        
        // 3. Crear el Controlador e inyectar Modelo y Vista
        Controlador controlador = new Controlador(modelo, vista);
        
        // 4. Iniciar la aplicación
        controlador.run();
    }
    // ------------------------------------------


    /**
     * Muestra el menú principal y lee la opción del usuario.
     * @return La opción elegida (1-5).
     */
    public int mostrarMenu() {
        System.out.println("\n--- SISTEMA DE GESTIÓN AGRO-TECNOLÓGICA ---");
        System.out.println("1. Listar todos los equipos");
        System.out.println("2. Buscar equipo por ID");
        System.out.println("3. Buscar equipo por Nombre");
        System.out.println("4. Ordenar equipos por consumo eléctrico");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");

        int opcion = -1;
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            // Error si el usuario no ingresa un número
        }
        scanner.nextLine(); // Limpiar el buffer
        return opcion;
    }

    public int solicitarId() {
        System.out.print("Ingrese el ID del equipo: ");
        int id = -1;
        try {
            id = scanner.nextInt();
        } catch (InputMismatchException e) {
            // Error
        }
        scanner.nextLine(); // Limpiar buffer
        return id;
    }

    public String solicitarNombre() {
        System.out.print("Ingrese el Nombre del equipo: ");
        return scanner.nextLine();
    }

    /**
     * Muestra una lista de dispositivos.
     * @param lista La lista polimórfica de dispositivos.
     */
    public void mostrarDispositivos(ArrayList<Dispositivo> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay dispositivos en el catálogo.");
            return;
        }
        System.out.println("\n--- CATÁLOGO DE DISPOSITIVOS ---");
        for (Dispositivo d : lista) {
            // Llama al método toString() de cada objeto (polimorfismo)
            System.out.println(d.toString());
        }
    }

    /**
     * Muestra un único dispositivo o un mensaje de no encontrado.
     * @param d El dispositivo a mostrar (puede ser null).
     */
    public void mostrarDispositivo(Dispositivo d) {
        if (d != null) {
            System.out.println("\n--- EQUIPO ENCONTRADO ---");
            System.out.println(d.toString());
            // Aquí se podría verificar "instanceof" para mostrar acciones
            if (d instanceof Medible) {
                System.out.println("  -> Capacidad: Medible");
            }
            if (d instanceof Accionable) {
                System.out.println("  -> Capacidad: Accionable");
            }
            if (d instanceof Registrable) {
                System.out.println("  -> Capacidad: Registrable");
            }
        } else {
            mostrarError("Equipo no encontrado.");
        }
    }

    public void mostrarMensaje(String msj) {
        System.out.println("\n[SISTEMA] " + msj);
    }

    public void mostrarError(String err) {
        System.out.println("\n[ERROR] " + err);
    }

    public void cerrarScanner() {
        this.scanner.close();
    }
}