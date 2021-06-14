import java.util.*;

public class Memorabilia {
    
    public static void main(String[] args) {
        Memorabilia m = new Memorabilia();
    }

    Scanner scan = new Scanner(System.in);
    Random random = new Random();

    //Clientes
    final int CANTIDAD_CLIENTES = 30; 
    String[] nombreClientes = new String[CANTIDAD_CLIENTES]; // Nombre de los clientes
    int[][] idClnt_Tel = new int[CANTIDAD_CLIENTES][2]; // ID Clientes, Teléfono
    boolean[] tienePeliculaPrestado = new boolean[CANTIDAD_CLIENTES]; // Tiene un préstamo activo

    //Películas
    final int CANTIDAD_PELICULAS = 30;
    String[][] nombrePel_Categoria = new String[CANTIDAD_PELICULAS][2]; //Nombre Películas, Categoría
    int[][] idPel_Anio_Prestamo = new int[CANTIDAD_PELICULAS][3]; // ID Películas, Año, Cantidad de Préstamos
    boolean[] disponible = new boolean[CANTIDAD_PELICULAS]; // Disponibilidad de Préstamo

      //Categorías de Películas
      String[] categoriasPelis = new String[5]; // Todas las categorías

    //Préstamos
    int[][] prestamos = new int[30][3];  // ID Películas, ID Clientes, Número de días que se prestará
    String[][] pelicula_cliente = new String[30][2]; // Nombre Películas, Nombre Cliente;



    public Memorabilia() {

        nombrePel_Categoria[0][0] = "Los Indestructibles";
        nombrePel_Categoria[0][1] = "Accion   ";
        nombrePel_Categoria[1][0] = "El Senior de los Anillos";
        nombrePel_Categoria[1][1] = "Sci-Fi   ";
        nombrePel_Categoria[2][0] = "Familia al Instante";
        nombrePel_Categoria[2][1] = "Comedia  ";
        nombrePel_Categoria[3][0] = "Interestelar";
        nombrePel_Categoria[3][1] = "Sci-Fi   ";

        idPel_Anio_Prestamo[0][0] = 100;
        idPel_Anio_Prestamo[0][1] = 1995;
        idPel_Anio_Prestamo[0][2] = 0;
        idPel_Anio_Prestamo[1][0] = 101;
        idPel_Anio_Prestamo[1][1] = 1998;
        idPel_Anio_Prestamo[1][2] = 0;
        idPel_Anio_Prestamo[2][0] = 102;
        idPel_Anio_Prestamo[2][1] = 2000;
        idPel_Anio_Prestamo[2][2] = 0;
        idPel_Anio_Prestamo[3][0] = 103;
        idPel_Anio_Prestamo[3][1] = 1980;
        idPel_Anio_Prestamo[3][2] = 0;

        disponible [0] = true;
        disponible [1] = true;
        disponible [2] = true;
        disponible [3] = true;

        categoriasPelis[0] = "Accion   ";
        categoriasPelis[1] = "Sci-Fi   ";
        categoriasPelis[2] = "Comedia  ";        
        categoriasPelis[3] = "Terror   ";
        categoriasPelis[4] = "Romantica";

        nombreClientes[0] = "Katniss Everdeen";
        nombreClientes[1] = "Peeta Mellark";
        nombreClientes[2] = "Coriolanus Snow";
        nombreClientes[3] = "Haymitch Abernathy";

        tienePeliculaPrestado[0] = false;
        tienePeliculaPrestado[1] = false;
        tienePeliculaPrestado[2] = false;    
        tienePeliculaPrestado[3] = false;
    
        idClnt_Tel[0][0] = 10000;
        idClnt_Tel[1][0] = 10001;
        idClnt_Tel[2][0] = 10002;
        idClnt_Tel[3][0] = 10003; 
        
        idClnt_Tel[0][1] = 77610000;
        idClnt_Tel[1][1] = 77610001;
        idClnt_Tel[2][1] = 77610002;
        idClnt_Tel[3][1] = 77610003; 

        iniciarMenu();
    }

    public void iniciarMenu() {

        System.out.println("\n");
        System.out.println("   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
        System.out.println("       *     *     *     *     *     *     *     *     *     *     *     ");
        System.out.println("   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
        System.out.println("      * *                                                         * *    ");
        System.out.println("        * *                                                     * *      ");
        System.out.println("         * *     A L Q U I L E R   D E   P E L I C U L A S     * *       ");
        System.out.println("          * *                                                 * *        ");
        System.out.println("         * *               M E M O R A B I L I A               * *       ");
        System.out.println("        * *                                                     * *      ");
        System.out.println("      * *                                                         * *    ");
        System.out.println("   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
        System.out.println("       *     *     *     *     *     *     *     *     *     *     *     ");
        System.out.println("   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
        int opcion;

        do {
            System.out.println("\n\nMENU PRINCIPAL\n");
            System.out.println(    "  1. Prestamo de Peliculas");
            System.out.println(    "  2. Devolucion de Peliculas");
            System.out.println(    "  3. Mostrar Peliculas");
            System.out.println(    "  4. Ingreso de Peliculas");
            System.out.println(    "  5. Ordenar las Peliculas Alfabeticamente");
            System.out.println(    "  6. Ingresar Clientes Nuevos");
            System.out.println(    "  7. Mostrar Clientes");
            System.out.println(    "  8. Reportes");
            System.out.println(    "  9. Salir");
            System.out.print(      "Escribe el numero de la opcion que eliges: ");
            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion) {
                case 1:
                    prestamoPeliculas();
                    break;
                case 2:
                    devolucionPeliculas();
                    break;
                case 3:
                    mostrarPeliculas(" - Peliculas -");
                    break;
                case 4:
                    ingresarPeliculas();
                    break;
                case 5:
                    ordenarNombresPeliculas();
                    mostrarPeliculas("Peliculas");
                    break;
                case 6:
                    ingresarClientes();
                    break;
                case 7:
                    mostrarClientes();   
                    break;
                case 8:
                    reportes();  
                    break;
                case 9:
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("\nOpcion Incorrecta.\n");
                    break;
            }

        } while(opcion != 9); 

    }

    public void prestamoPeliculas() {

        mostrarClientes();
        System.out.print("\nEscriba el numero de cliente: ");
        int numCliente = scan.nextInt();

        if (tienePeliculaPrestado[numCliente-1] == false) {
            mostrarPeliculas(" - Peliculas Disponibles -");
            System.out.print("\nEscriba el numero de la pelicula: ");
            int numPelicula = scan.nextInt();
            System.out.print("\nEscriba numero de dias a prestar: ");
            int numDias = scan.nextInt();
            realizarPrestamo((numCliente-1),(numPelicula-1), numDias);

        } else {
            System.out.println("\n  El cliente no puede pedir otra pelicula");
        }
        
    }

    public void realizarPrestamo(int indiceCliente, int indicePelicula, int numeroDias) {

        tienePeliculaPrestado[indiceCliente] = true;
        disponible[indicePelicula] = false;
        idPel_Anio_Prestamo[indicePelicula][2]++;

        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i][0] == 0) {

                prestamos[i][0] = idPel_Anio_Prestamo[indicePelicula][0];
                prestamos[i][1] = idClnt_Tel[indiceCliente][0];
                prestamos[i][2] = numeroDias;
                
                pelicula_cliente[i][0] = nombrePel_Categoria[indicePelicula][0];
                pelicula_cliente[i][1] = nombreClientes[indiceCliente];

                System.out.println("\n   Prestamo realizado!");
                System.out.println(  "   Numero de Prestamo: " + (i+1) + "   Pelicula: " + pelicula_cliente[i][0] + "   Cliente: " + pelicula_cliente[i][1]);
                break;
            }
            
        }
        
    }
    
    public void devolucionPeliculas() {

        System.out.println("\n - Prestamos Activos -\n");

        for (int i = 0; i < prestamos.length; i++) {
            if (pelicula_cliente[i][0] != null) {
                System.out.println("Numero de Prestamo: " + (i+1) + "   ID CLIENTE: " + prestamos[i][1] + "   Pelicula: " + pelicula_cliente[i][0] 
                + "   Cliente: " + pelicula_cliente[i][1]);
            }

        }

        System.out.print("\nIngrese el numero de prestamo: ");
        int numPrestamo = scan.nextInt();

        prestamos[numPrestamo-1][2] = 0;
        pelicula_cliente[numPrestamo-1][0] = "";
        pelicula_cliente[numPrestamo-1][1] = "";

        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
            if (prestamos[numPrestamo-1][1] == idClnt_Tel[i][0]) {
                tienePeliculaPrestado[i] = false;
                prestamos[numPrestamo-1][1] = 0;
                break;
            }
        }

        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if (prestamos[numPrestamo-1][0] == idPel_Anio_Prestamo[i][0]) {
                disponible[i] = true;
                prestamos[numPrestamo-1][0] = 0;
                break;
            }
        }

        System.out.println("\n   Devolucion realizada!");
    }

    public void mostrarPeliculas(String nPelis){

        if (nPelis == " - Peliculas -") {
            System.out.println("\n"+nPelis+"\n");
            for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
                if (idPel_Anio_Prestamo[i][0] != 0) {
                    System.out.println((i+1)+".  Estado: "+ asignarEstado(disponible[i], "Disponible", "Prestada  ")+",   ID: "+idPel_Anio_Prestamo[i][0]+",   Categoria: "+nombrePel_Categoria[i][1]+",   Anio: "+idPel_Anio_Prestamo[i][1]+",   Nombre: "+nombrePel_Categoria[i][0]);
                }
            }

        } 
        
        else if (nPelis == " - Peliculas Disponibles -") {
            System.out.println("\n"+nPelis+"\n");
            for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
                if (idPel_Anio_Prestamo[i][0] != 0 && disponible[i]==true) {
                    System.out.println((i+1)+".   ID: "+idPel_Anio_Prestamo[i][0]+",   Categoria: "+nombrePel_Categoria[i][1]+",   Anio: "+idPel_Anio_Prestamo[i][1]+",   Nombre: "+nombrePel_Categoria[i][0]);
                }
            }
        }

    }

    public void ordenarNombresPeliculas() {
        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
            for (int j = 0; j < CANTIDAD_CLIENTES-1; j++) {
                if ((nombrePel_Categoria[j][0]!=null)&&(nombrePel_Categoria[j+1][0]!=null)&&(nombrePel_Categoria[j][0].compareToIgnoreCase(nombrePel_Categoria[j+1][0])>0)) {
                    String auxiliar = nombrePel_Categoria[j][0];
                    nombrePel_Categoria[j][0] = nombrePel_Categoria[j+1][0];
                    nombrePel_Categoria[j+1][0] = auxiliar;

                    auxiliar = nombrePel_Categoria[j][1];
                    nombrePel_Categoria[j][1] = nombrePel_Categoria[j+1][1];
                    nombrePel_Categoria[j+1][1] = auxiliar;

                    int auxi = idPel_Anio_Prestamo[j][0];
                    idPel_Anio_Prestamo[j][0] = idPel_Anio_Prestamo[j+1][0];
                    idPel_Anio_Prestamo[j+1][0] = auxi;

                    auxi = idPel_Anio_Prestamo[j][1];
                    idPel_Anio_Prestamo[j][1] = idPel_Anio_Prestamo[j+1][1];
                    idPel_Anio_Prestamo[j+1][1] = auxi;

                    auxi = idPel_Anio_Prestamo[j][2];
                    idPel_Anio_Prestamo[j][2] = idPel_Anio_Prestamo[j+1][2];
                    idPel_Anio_Prestamo[j+1][2] = auxi;

                    boolean aux = disponible[j];
                    disponible[j] = disponible[j+1];
                    disponible[j+1] = aux;

                }
            }
        }
    }

    public void mostrarClientes() {

        System.out.println("\n - Clientes -\n");

        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
            if (nombreClientes[i] != null) {
                System.out.println((i+1)+".  Estado de Prestamo: " + asignarEstado(tienePeliculaPrestado[i], "Activo   ", "No Activo")+",  ID: "+idClnt_Tel[i][0]+",   Telefono: "+idClnt_Tel[i][1]+",   Nombre: "+nombreClientes[i]);
            }
        }

    }

    public void ingresarPeliculas() {

        System.out.print("\nIngrese el nombre de la pelicula: ");
        String nombrePelicula = scan.nextLine();
        String categoria = asignarCategoria();
        System.out.print("\nIngrese el anio de la pelicula: ");
        int anioPelicula = scan.nextInt();

        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if (nombrePel_Categoria[i][0]==null) {
                nombrePel_Categoria[i][0] = nombrePelicula;
                nombrePel_Categoria[i][1] = categoria;
                idPel_Anio_Prestamo[i][0] = generarID(999, 100);
                idPel_Anio_Prestamo[i][1] = anioPelicula;
                idPel_Anio_Prestamo[i][2] = 0;
                disponible[i] = true;

                System.out.println("\n   Pelicula ingresada exitosamente!");
                System.out.println("   "+(i+1)+".  ID: "+idPel_Anio_Prestamo[i][0]+",   Nombre: "+nombrePel_Categoria[i][0]+",   Categoria: "+nombrePel_Categoria[i][1]+",  Anio: "+idPel_Anio_Prestamo[i][1]); 

                break;
            }
        }        

    }

    public void ingresarClientes(){
        System.out.print("\nIngrese el nombre del Cliente: ");
        String cliente = scan.nextLine();

        for(int i = 0; i<CANTIDAD_CLIENTES;i++ ){
            if(nombreClientes[i] == null){
                nombreClientes[i] = cliente;
                System.out.print("Ingrese el numero de telefono: ");
                idClnt_Tel[i][1] = scan.nextInt();
                idClnt_Tel[i][0] = generarID(99999, 10000);  
                tienePeliculaPrestado[i] = false;

                System.out.println("\n   Cliente ingresado exitosamente!");
                System.out.println("   "+(i+1)+".  ID: "+idClnt_Tel[i][0]+",   Nombre: "+nombreClientes[i]+",   Telefono: "+idClnt_Tel[i][1]+",  Estado de Prestamo: " + asignarEstado(tienePeliculaPrestado[i], "Activo   ", "No Activo")); 
                break;
            }
        }
    }

    public int generarID(int valorMaximo, int valorMinimo){

        int idAleatorio = 0;
        
        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
        idAleatorio = random.nextInt(valorMaximo-valorMinimo+1) + valorMinimo;
           if (idClnt_Tel[i][0]!=idAleatorio &&  idClnt_Tel[i][0] == 0) {   
               break;
           }
       }  
        return idAleatorio;
    }

    public String asignarEstado(boolean estado, String verdadero, String falso) {
        String estadoR;

        if (estado == true) {
            estadoR = verdadero;
        } else {
            estadoR = falso;
        }
        return estadoR;
    }

    public String asignarCategoria() {

        System.out.println("\nSeleccione una categoria");

        for (int i = 0; i < categoriasPelis.length; i++) {
            System.out.println(" "+(i+1)+". "+categoriasPelis[i]);
        }

        System.out.print("Escriba el numero de la categoria: ");
        int indPelicula = scan.nextInt();
        
        return categoriasPelis[indPelicula-1];
    }

    public void reportes() {

        System.out.println("\nREPORTES");
        System.out.println(  " 1. Cantidad de Peliculas por Categoria");
        System.out.println(  " 2. Peliculas por Categoria Especifica");
        System.out.println(  " 3. Cantidad de Prestamos por Pelicula");
        System.out.println(  " 4. Pelicula Mas Prestada");
        System.out.println(  " 4. Pelicula Menos Prestada");
        System.out.print(    "Seleccione una opcion: ");
        int opcionReporte = scan.nextInt();
        scan.nextLine();

        switch (opcionReporte) {
            case 1:
                System.out.println("\nCantidad de Peliculas por Categoria");
                int[] contadores = new int[5];
                contadoresCategorias(contadores);
                break;
            case 2:
                System.out.println("\nPeliculas por Categoria Especifica");
                buscarCategoriaEspecifica();   
                break;
            case 3:
                System.out.println("\nCantidad de Prestamos por Pelicula");
                mostrarPrestamosPorPelicula();
                break;
            case 4:
                hallarPeliMasPrestada();
                break;
            case 5:
                hallarPeliMenosPrestada();
                break;
            default:
                System.out.println("Numero incorrecto");
                break;
        }

    }

    public void contadoresCategorias(int[] contadores){

        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if (nombrePel_Categoria[i][1] != null && nombrePel_Categoria[i][1].equals(categoriasPelis[0])) {
                contadores[0]++;
            } else if (nombrePel_Categoria[i][1] != null && nombrePel_Categoria[i][1].equals(categoriasPelis[1])) {
                contadores[1]++;
            } else if (nombrePel_Categoria[i][1] != null && nombrePel_Categoria[i][1].equals(categoriasPelis[2])) {
                contadores[2]++;
            } else if (nombrePel_Categoria[i][1] != null && nombrePel_Categoria[i][1].equals(categoriasPelis[3])) {
                contadores[3]++;
            } else if (nombrePel_Categoria[i][1] != null && nombrePel_Categoria[i][1].equals(categoriasPelis[4])) {
                contadores[4]++;
            }
        }

        System.out.println();
        for (int i = 0; i < contadores.length; i++) {
            System.out.println(" - "+categoriasPelis[i]+":   "+contadores[i]);
        }

    }

    public void buscarCategoriaEspecifica() {

        String categ = asignarCategoria();

        System.out.println("\nCategoria de Pelicula: "+categ);

        int contador = 0;
        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if (nombrePel_Categoria[i][1] != null && nombrePel_Categoria[i][1].equals(categ)) {
                System.out.println(" -> "+nombrePel_Categoria[i][0]);
                contador++;           
            }
        }

        if (contador==0) {
            System.out.println("   Aun no hay peliculas de esta categoria.");
        }  
    }

    public void mostrarPrestamosPorPelicula() {

        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if (nombrePel_Categoria[i][0] != null) {
                System.out.println(" * Prestamos: "+idPel_Anio_Prestamo[i][2]+"   Pelicula: "+nombrePel_Categoria[i][0]);
            }
        }

    }

    public void hallarPeliMasPrestada() {
        int mayor=0;
        String masPrestada="";

        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if(nombrePel_Categoria[i][0] != null && idPel_Anio_Prestamo[i][2] > mayor) {
                    mayor = idPel_Anio_Prestamo[i][2];
                    masPrestada = nombrePel_Categoria[i][0];
            }
        }
        System.out.println("\n - Pelicula Mas Prestada -");
        System.out.println("\n     -> " + masPrestada);    
        
    }

    public void hallarPeliMenosPrestada() {
        
        int menor=1000;
        String menosPrestada="";

        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if(nombrePel_Categoria[i][0] != null && idPel_Anio_Prestamo[i][2] < menor) {
                    menor = idPel_Anio_Prestamo[i][2];
                    menosPrestada = nombrePel_Categoria[i][0];
            }
        }  
        System.out.println("\n - Pelicula Menos Prestada -");
        System.out.println("\n     -> " + menosPrestada);

    }

}
