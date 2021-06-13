import java.util.Scanner;

public class Memorabilia {
    
    public static void main(String[] args) {
        Memorabilia m = new Memorabilia();
    }

    Scanner scan = new Scanner(System.in);

    //Clientes
    final int CANTIDAD_CLIENTES = 30;
    String[] nombreClientes = new String[CANTIDAD_CLIENTES];
    int[][] idClnt_Tel = new int[CANTIDAD_CLIENTES][2];
    boolean[] tienePeliculaPrestado = new boolean[CANTIDAD_CLIENTES];

    //Peliculas
    final int CANTIDAD_PELICULAS = 30;
    String[][] nombrePel_Categoria = new String[CANTIDAD_CLIENTES][2];
    int[][] idPel_Anio_Prestamo = new int[CANTIDAD_CLIENTES][3];
    boolean[] disponible = new boolean[CANTIDAD_CLIENTES];
    String[] categoriasPelis = new String[5];

    //Prestamos
    int[][] prestamos = new int[30][3];  // ID Peliculas, ID Clientes, Dias prestamos
    String[][] pelicula_cliente = new String[30][2];



    public Memorabilia() {

        nombrePel_Categoria[0][0] = "Rapido y Furioso";
        nombrePel_Categoria[0][1] = "Accion";
        nombrePel_Categoria[1][0] = "El Senior de los Anillos";
        nombrePel_Categoria[1][1] = "Ciencia Ficcion";
        nombrePel_Categoria[2][0] = "Kung Fu Panda";
        nombrePel_Categoria[2][1] = "Comedia";
        nombrePel_Categoria[3][0] = "Star Wars";
        nombrePel_Categoria[3][1] = "Ciencia Ficcion";

        idPel_Anio_Prestamo[0][0] = 1;
        idPel_Anio_Prestamo[0][1] = 1995;
        idPel_Anio_Prestamo[0][2] = 0;
        idPel_Anio_Prestamo[1][0] = 2;
        idPel_Anio_Prestamo[1][1] = 1998;
        idPel_Anio_Prestamo[1][2] = 0;
        idPel_Anio_Prestamo[2][0] = 3;
        idPel_Anio_Prestamo[2][1] = 2000;
        idPel_Anio_Prestamo[2][2] = 0;
        idPel_Anio_Prestamo[3][0] = 4;
        idPel_Anio_Prestamo[3][1] = 1980;
        idPel_Anio_Prestamo[3][2] = 0;

        disponible [0] = true;
        disponible [1] = false;
        disponible [2] = true;
        disponible [3] = true;

        categoriasPelis[0] = "Accion";
        categoriasPelis[1] = "Ciencia Ficcion";
        categoriasPelis[2] = "Comedia";        
        categoriasPelis[3] = "Terror";
        categoriasPelis[4] = "Romantica";

        iniciarMenu();
    }

    public void iniciarMenu() {

        int opcion;

        do {
            System.out.println("\nMENU PRINCIPAL\n");
            System.out.println(  "  1. Prestamo de Peliculas");
            System.out.println(  "  2. Devolucion de Peliculas");
            System.out.println(  "  3. Mostrar Peliculas");
            System.out.println(  "  4. Ingreso de Peliculas");
            System.out.println(  "  5. Ordenar las Peliculas Alfabeticamente");
            System.out.println(  "  6. Ingresar Clientes Nuevos");
            System.out.println(  "  7. Mostrar Clientes");
            System.out.println(  "  8. Reportes");
            System.out.println(  "  9. Salir");
            System.out.print(    "Escribe el numero de la opcion que eliges: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    //prestamoPeliculas();
                    break;
                case 2:
                    //devolucionPeliculas();
                    break;
                case 3:
                    mostrarPeliculas("Peliculas");
                    break;
                case 4:
                    //ingresarPeliculas();
                    break;
                case 5:
                    ordenarNombres();
                    mostrarPeliculas("Peliculas");
                    break;
                case 6:
                    //ingresarClientes():
                    break;
                case 7:
                    //mostrar clientes();   
                    break;
                case 8:
                    //reportes();  
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

    public void ingresarClientes(){
        System.out.print("Ingrese su nombre: ");
        String cliente = scan.nextLine();

        for(int i = 0; i<CANTIDAD_CLIENTES;i++ ){
            if(nombreClientes[i] == null){
                nombreClientes[i] = cliente;
                System.out.print("Ingrese su telefono: ");
                idClnt_Tel[i][1] = scan.nextInt();
                idClnt_Tel[i][0] = generarID();  
                tienePeliculaPrestado[i] = false; 
            }
        }
    }

    public int generarID(){
        int ID = 0;
        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
        ID = (int)(Math.random()*(999-100)+100);
           if (idClnt_Tel[i][0]!=ID &&  idClnt_Tel[i][0] == 0) {   
               break;
           }
       }  
        return ID;
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
                idPel_Anio_Prestamo[i][0] = generarIdPeliculas();
                idPel_Anio_Prestamo[i][1] = anioPelicula;
                idPel_Anio_Prestamo[i][2] = 0;
                disponible[i] = true;
                break;
            }
        }
        

    }

    public String asignarCategoria() {

        System.out.println("\nSeleccione una categoria");

        for (int i = 0; i < categoriasPelis.length; i++) {
            System.out.println((i+1)+". "+categoriasPelis[i]);
        }

        System.out.print("Escriba el numero de la categoria: ");
        int indPelicula = scan.nextInt();
        
        return categoriasPelis[indPelicula-1];
    }

    public void reportes() {
        /*
        Reportes:
            ○ Cantidad de películas por categoría (puede crear una tabla para llevar el
            control de las categorías)
            ○ Las películas de una categoría en específico.
            ○ Reporte de las películas y la cantidad de veces que se presta
            ○ Reporte de la película más prestada
            ○ Reporte de la película menos prestada
        */
        System.out.println("\nREPORTES");
        System.out.println("1. Cantidad de Peliculas por Categoria");
        System.out.println("2. Peliculas por Categoria");
        System.out.println("3. Cantidad de Prestamos por Pelicula");
        System.out.println("4. Pelicula Mas Prestada y Pelicula Menos Prestada");
        int opcionReporte = scan.nextInt();

        switch (opcionReporte) {
            case 1:
                System.out.println("\nCantidad de Peliculas por Categoria");
                int[] contadores = new int[5];
                contadoresCategorias(contadores);
                break;
            case 2:
                System.out.println("\nPeliculas por Categoria");
                buscarCategoriaEspecifica();   
                break;
            case 3:
                System.out.println("\nCantidad de Prestamos por Pelicula");
                //imprimir con un for nombre de pelicula y numero de prestamos
                mostrarPrestamosPorPelicula();
                break;
            case 4:
                String masPrestada = "", menosPrestada = "";
                manejarCategoria(masPrestada, menosPrestada);
            
                System.out.println("\nPelicula Mas Prestada: " + masPrestada);
                // buscar el elemento mayor -for-
            
                System.out.println("\nPelicula Menos Prestada: " + menosPrestada);
                // buscar el elemento menor -for-
    
                break;
            default:
                System.out.println("Numero incorrecto");
                break;
        }



    }

    public void buscarCategoriaEspecifica() {

        String categ = asignarCategoria();

        System.out.println("Categoria de Pelicula: "+categ);

        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if (nombrePel_Categoria[i][1].equals(categ)) {
                System.out.println(nombrePel_Categoria[i][1]);
            }
        }
    }

    public void contadoresCategorias(int[] contadores){

        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if (nombrePel_Categoria[i][1].equals(categoriasPelis[0])) {
                contadores[0]++;
            } else if (nombrePel_Categoria[i][1].equals(categoriasPelis[1])) {
                contadores[1]++;
            } else if (nombrePel_Categoria[i][1].equals(categoriasPelis[2])) {
                contadores[2]++;
            } else if (nombrePel_Categoria[i][1].equals(categoriasPelis[3])) {
                contadores[3]++;
            } else if (nombrePel_Categoria[i][1].equals(categoriasPelis[4])) {
                contadores[4]++;
            }
        }

        for (int i = 0; i < contadores.length; i++) {
            System.out.println();
            System.out.println(categoriasPelis[i]+":   "+contadores[i]);
        }

    }

    public void mostrarPrestamosPorPelicula() {
        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if (nombrePel_Categoria[i][0] != null) {
                System.out.println("Pelicula: "+nombrePel_Categoria[i][0]+"   Prestamos: "+idPel_Anio_Prestamo[i][2]);
            }
        }
    }

    public void manejarCategoria(String masPrestada, String menosPrestada) {
        int mayor=0, menor=100;

        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if (idPel_Anio_Prestamo[i][2]>mayor) {
                mayor = idPel_Anio_Prestamo[i][2];
                masPrestada = nombrePel_Categoria[i][0];
            }

            if (idPel_Anio_Prestamo[i][2]<menor) {
                menor = idPel_Anio_Prestamo[i][2];
                menosPrestada = nombrePel_Categoria[i][0];
            }
        }
    }

    public void ordenarNombres() {
        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
            for (int j = 0; j < CANTIDAD_CLIENTES-1; j++) {
                if ((nombrePel_Categoria[j][0]!=null)&&(nombrePel_Categoria[j+1][0]!=null)&&(nombrePel_Categoria[j][0].compareToIgnoreCase(nombrePel_Categoria[j+1][0])>0)) {
                    String auxiliar = nombrePel_Categoria[j][0];
                    nombrePel_Categoria[j][0] = nombrePel_Categoria[j+1][0];
                    nombrePel_Categoria[j+1][0] = auxiliar;
                }
            }
        }
    }

    public int generarIdPeliculas(){
        int ID = 0;
       for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
        ID = (int)(Math.random()*(100-1)+1);
           if (idPel_Anio_Prestamo[i][0]!=ID &&  idPel_Anio_Prestamo[i][0] == 0) {   
               break;
           }
       }  
        return ID;
    }

    public void prestamoPeliculas() {

        mostrarClientes();
        System.out.print("Escriba el numero de cliente: ");
        int numCliente = scan.nextInt();

        if (tienePeliculaPrestado[numCliente-1] == false) {
            mostrarPeliculas("Peliculas Disponibles");
            System.out.println("\nEscriba el numero de la pelicula: ");
            int numPelicula = scan.nextInt();
            System.out.print("Escriba numero de dias a prestar: ");
            int numDias = scan.nextInt();
            realizarPrestamo((numCliente-1),(numPelicula-1), numDias);

        } else {
            System.out.println("\nEl cliente no puede pedir otra pelicula");
        }
        
    }

    public void mostrarClientes() {

        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
            if (nombreClientes[i] != null) {
                System.out.println((i+1)+".  ID: "+idClnt_Tel[i][0]+",   Nombre: "+nombreClientes[i]+",   Telefono: "+idClnt_Tel[i][1]+",  Estado de Prestamo: " + asignarEstado(tienePeliculaPrestado[i], "Activo", "No Activo"));
            }
        }
    }

    public void realizarPrestamo(int indiceCliente, int indicePelicula, int numeroDias) {

        tienePeliculaPrestado[indiceCliente] = true;
        disponible[indicePelicula] = false;
        idPel_Anio_Prestamo[indicePelicula][2]++;

        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i][0] == 0) {
                //no hay nada
                prestamos[i][0] = idPel_Anio_Prestamo[indicePelicula][0];
                prestamos[i][1] = idClnt_Tel[indiceCliente][0];
                prestamos[i][2] = numeroDias;
                
                pelicula_cliente[i][0] = nombrePel_Categoria[indicePelicula][0];
                pelicula_cliente[i][1] = nombreClientes[indiceCliente];
            }
            break;
        }
        
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

    public void mostrarPeliculas(String nPelis){

        if (nPelis == "Peliculas") {
            System.out.println("\n"+nPelis+"\n");
            for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
                if (idPel_Anio_Prestamo[i][0] != 0) {
                    System.out.println((i+1)+".  ID: "+idPel_Anio_Prestamo[i][0]+",   Nombre: "+nombrePel_Categoria[i][0]+",   Anio: "+idPel_Anio_Prestamo[i][1]+",   Categoria: "+nombrePel_Categoria[i][1]+",   Estado: "+ asignarEstado(disponible[i], "Disponible", "Prestada"));
                }
            }

        } 
        
        else if (nPelis == "Peliculas Disponibles") {
            System.out.println("\n"+nPelis+"\n");
            for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
                if (idPel_Anio_Prestamo[i][0] != 0 && disponible[i]==true) {            
                    System.out.println((i+1)+".  ID: "+idPel_Anio_Prestamo[i][0]+",   Nombre: "+nombrePel_Categoria[i][0]+",   Anio: "+idPel_Anio_Prestamo[i][1]+",   Categoria: "+nombrePel_Categoria[i][1]);
                }
            }
        }

    }

    public void devolucionPeliculas() {
        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
            if (disponible[i] == true) {
                System.out.println("Nombre: " + nombrePel_Categoria[i][0] + " Cliente: " + nombreClientes[i] + " ID CLIENTE: "
                        + idClnt_Tel[i][0]);
            }

        }
        System.out.println("Ingrese el ID del cliente");
        int idcliente = scan.nextInt();
        for (int i = 0; i < disponible.length; i++) {
            if (idcliente == idClnt_Tel[i][0]) {
                disponible[i] = true;
                tienePeliculaPrestado[i] = false;

            }

        }
    }

}
