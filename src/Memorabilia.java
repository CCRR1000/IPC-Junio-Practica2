import java.util.Scanner;

public class Memorabilia {
    
    public static void main(String[] args) {
        Memorabilia m = new Memorabilia();
    }

    Scanner scan = new Scanner(System.in);

    //Clientes
    final int CANTIDAD_CLIENTES = 30;
    String[] nombreClientes = new String[CANTIDAD_CLIENTES];
    int[][] id_tel_clientes = new int[CANTIDAD_CLIENTES][2];
    boolean[] tienePeliculaPrestado = new boolean[CANTIDAD_CLIENTES];

    //Peliculas
    final int CANTIDAD_PELICULAS = 30;
    String[][] nombre_Categoria = new String[CANTIDAD_CLIENTES][2];
    int[][] id_anio_prestamo = new int[CANTIDAD_CLIENTES][3];
    boolean[] disponible = new boolean[CANTIDAD_CLIENTES];
    String[] categorias = new String[5];

    //Prestamos
    int[][] prestamos = new int[30][3];  // ID Peliculas, ID Clientes, Dias prestamos
    String[][] pelicula_cliente = new String[30][2];



    public Memorabilia() {

        //Arreglos para borrar

        nombre_Categoria[0][0] = "Rapido y Furioso";
        nombre_Categoria[0][1] = "Accion";
        nombre_Categoria[1][0] = "El Senior de los Anillos";
        nombre_Categoria[1][1] = "Ciencia Ficcion";
        nombre_Categoria[2][0] = "Kung Fu Panda";
        nombre_Categoria[2][1] = "Comedia";
        nombre_Categoria[3][0] = "Star Wars";
        nombre_Categoria[3][1] = "Ciencia Ficcion";

        id_anio_prestamo[0][0] = 1;
        id_anio_prestamo[0][1] = 1995;
        id_anio_prestamo[0][2] = 0;
        id_anio_prestamo[1][0] = 2;
        id_anio_prestamo[1][1] = 1998;
        id_anio_prestamo[1][2] = 0;
        id_anio_prestamo[2][0] = 3;
        id_anio_prestamo[2][1] = 2000;
        id_anio_prestamo[2][2] = 0;
        id_anio_prestamo[3][0] = 4;
        id_anio_prestamo[3][1] = 1980;
        id_anio_prestamo[3][2] = 0;

        disponible [0] = true;
        disponible [1] = false;
        disponible [2] = true;
        disponible [3] = true;

        categorias[0] = "Accion";
        categorias[1] = "Ciencia Ficcion";
        categorias[2] = "Comedia";        
        categorias[3] = "Terror";
        categorias[4] = "Romantica";

        iniciarMenu();
    }

    public void iniciarMenu() {

 /*       System.out.println("\nMenu");
        System.out.println("1.Prestamos de Peliculas");
        System.out.println("2.");
        System.out.println("3.");
        System.out.println("4.");
        System.out.println("5.");
        System.out.println("6.");
        System.out.println("7.");
        System.out.println("8.");
        System.out.println("9.");
        System.out.print("Escribe el numero de la opcion que eliges: ");
        int opcion = scan.nextInt();
*/
        prestamoPeliculas();

    }

    public void ingresoPeliculas() {

        System.out.print("\nIngrese el nombre de la pelicula: ");
        String nombrePelicula = scan.nextLine();
        String categoria = asignarCategoria();
        System.out.print("\nIngrese el anio de la pelicula: ");
        int anioPelicula = scan.nextInt();

        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if (nombre_Categoria[i][0]==null) {

                nombre_Categoria[i][0] = nombrePelicula;
                nombre_Categoria[i][1] = categoria;
                id_anio_prestamo[i][0] = generarIdPeliculas();
                id_anio_prestamo[i][1] = anioPelicula;
                id_anio_prestamo[i][2] = 0;
                disponible[i] = true;
                break;
            }
        }
        

    }

    public String asignarCategoria() {

        System.out.println("\nSeleccione una categoria");

        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i+1)+". "+categorias[i]);
        }

        System.out.print("Escriba el numero de la categoria: ");
        int indPelicula = scan.nextInt();
        
        return categorias[indPelicula-1];
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
            if (nombre_Categoria[i][1].equals(categ)) {
                System.out.println(nombre_Categoria[i][1]);
            }
        }
    }

    public void contadoresCategorias(int[] contadores){

        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if (nombre_Categoria[i][1].equals(categorias[0])) {
                contadores[0]++;
            } else if (nombre_Categoria[i][1].equals(categorias[1])) {
                contadores[1]++;
            } else if (nombre_Categoria[i][1].equals(categorias[2])) {
                contadores[2]++;
            } else if (nombre_Categoria[i][1].equals(categorias[3])) {
                contadores[3]++;
            } else if (nombre_Categoria[i][1].equals(categorias[4])) {
                contadores[4]++;
            }
        }

        for (int i = 0; i < contadores.length; i++) {
            System.out.println();
            System.out.println(categorias[i]+":   "+contadores[i]);
        }

    }

    public void mostrarPrestamosPorPelicula() {
        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if (nombre_Categoria[i][0] != null) {
                System.out.println("Pelicula: "+nombre_Categoria[i][0]+"   Prestamos: "+id_anio_prestamo[i][2]);
            }
        }
    }

    public void manejarCategoria(String masPrestada, String menosPrestada) {
        int mayor=0, menor=100;

        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if (id_anio_prestamo[i][2]>mayor) {
                mayor = id_anio_prestamo[i][2];
                masPrestada = nombre_Categoria[i][0];
            }

            if (id_anio_prestamo[i][2]<menor) {
                menor = id_anio_prestamo[i][2];
                menosPrestada = nombre_Categoria[i][0];
            }
        }
    }

    public void ordenarString() {
        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
            for (int j = 0; j < CANTIDAD_CLIENTES-1; j++) {
                if ((nombre_Categoria[j][0]!=null)&&(nombre_Categoria[j+1][0]!=null)&&(nombre_Categoria[j][0].compareToIgnoreCase(nombre_Categoria[j+1][0])>0)) {
                    String auxiliar = nombre_Categoria[j][0];
                    nombre_Categoria[j][0] = nombre_Categoria[j+1][0];
                    nombre_Categoria[j+1][0] = auxiliar;
                }
            }
        }
    }


    public int generarIdPeliculas(){
        int ID = 0;
       for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
        ID = (int)(Math.random()*(100-1)+1);
           if (id_anio_prestamo[i][0]!=ID &&  id_anio_prestamo[i][0] == 0) {   
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
            imprimirPeliculasDisponibles();
            System.out.println("\nEscriba el numero de la pelicula: ");
            int numPelicula = scan.nextInt();
            System.out.print("Escriba numero de dias a prestar: ");
            int numDias = scan.nextInt();
            realizarPrestamo((numCliente-1),(numPelicula-1), numDias);

        } else {
            System.out.println("\nEl cliente no puede pedir otra pelicula");
        }
        
    }

    public void realizarPrestamo(int indiceCliente, int indicePelicula, int numeroDias) {

        tienePeliculaPrestado[indiceCliente] = true;
        disponible[indicePelicula] = false;
        id_anio_prestamo[indicePelicula][2]++;

        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i][0] == 0) {
                //no hay nada
                prestamos[i][0] = id_anio_prestamo[indicePelicula][0];
                prestamos[i][1] = id_tel_clientes[indiceCliente][0];
                prestamos[i][2] = numeroDias;
                
                pelicula_cliente[i][0] = nombre_Categoria[indicePelicula][0];
                pelicula_cliente[i][1] = nombreClientes[indiceCliente];
            }
            break;
        }
        
    }

    public void mostrarClientes() {

        for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
            if (nombreClientes[i] != null) {
                System.out.println((i+1)+".  ID: "+id_tel_clientes[i][0]+",   Nombre: "+nombreClientes[i]+",   Telefono: "+id_tel_clientes[i][1]+",  Estado de Prestamo: "+estadoCliente(tienePeliculaPrestado[i]));
            }
        }
    }

    public String estadoCliente(boolean estado) {
        String estadoCliente;

        if (estado == true) {
            estadoCliente = "Activo";
        } else {
            estadoCliente = "No activo";
        }
        return estadoCliente;
    }


    public void imprimirPeliculasDisponibles(){

        System.out.println("Peliculas Disponibles");

        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if (id_anio_prestamo[i][0] != 0 && disponible[i]==true) {            
                System.out.println((i+1)+".  ID: "+id_anio_prestamo[i][0]+",   Nombre: "+nombre_Categoria[i][0]+",   Anio: "+id_anio_prestamo[i][1]+",   Categoria: "+nombre_Categoria[i][1]);
            }
        }

    }

    public void mostrarTodasPeliculas(){

        System.out.println("Peliculas");

        for (int i = 0; i < CANTIDAD_PELICULAS; i++) {
            if (id_anio_prestamo[i][0] != 0) {
                System.out.println((i+1)+".  ID: "+id_anio_prestamo[i][0]+",   Nombre: "+nombre_Categoria[i][0]+",   Anio: "+id_anio_prestamo[i][1]+",   Categoria: "+nombre_Categoria[i][1]+",   Estado: "+estadoPelicula(disponible[i]));
            }
        }

    }

    public String estadoPelicula(boolean estado) {
        String estadoPelicula;

        if (estado == true) {
            estadoPelicula = "Disponible";
        } else {
            estadoPelicula = "Prestada";
        }
        return estadoPelicula;
    }


}
