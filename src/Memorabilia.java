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
    String[] categorias = new String[10];

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
        System.out.print("\nIngrese la categoria de la pelicula: ");
        String categoria = scan.nextLine();
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


            /*
        •	Préstamo de películas: Para esto debe mostrar las películas disponibles y tomar que el cliente solo puede prestar una película a la vez. Si el cliente la acepta guardar en la tabla de préstamo la cantidad de días. El cliente cambia de estado y la película también como no disponible.

1.	Public boolean buscar()(películas disponibles)
2.	Public boolean ClienteFalsoPeliculaPrestado()
3.	Public void LLenarFilaPrestamo()
4.	Public void CambiarEstadocliente()
5.	Public void CambiarEstadoPelicula()

•	Devolución de películas: Para esto debe mostrar las películas prestadas incluyendo nombre de la película y el nombre del cliente. Seleccionar la película a devolver y modificar el estado del cliente y la película, dejando en disponibilidad.
1.	public void mostrarPeliculasprestadas()(matriz String de préstamos)
2.	llamar métodos     boolean [][] m = new boolean [filas][columnas];
3.	matrices boelanas para reconocer si están disponibles
4.	public void SeleccionarPelicula()
5.	llamar estadocliente y estadopelicula

•	Mostrar las películas: mostrar todos los datos de las películas.
1.	Public void imprimir()(nombre categoria año)
•	Ingreso de Películas: crear nuevas películas, insertarlas al final del arreglo. No se pueden crear dos películas con el mismo id.
1.	Public void llenarNuevapelicula()
2.	Public void verificadorIDpelicula()
•	Ordenar las películas de forma ascendente respecto al nombre.

        */



}
