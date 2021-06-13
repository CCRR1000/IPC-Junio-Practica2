
public class Memorabilia {
    
    public static void main(String[] args) {
        Memorabilia m = new Memorabilia();
    }

    public Memorabilia() {
        //Clientes
        final int CANTIDAD_CLIENTES = 30;
        String[] nombreClientes = new String[CANTIDAD_CLIENTES];
        int[][] id_tel_clientes = new int[CANTIDAD_CLIENTES][2];
        boolean[] tienePeliculaPrestado = new boolean[CANTIDAD_CLIENTES];

        //Peliculas
        final int CANTIDAD_PELICULAS = 30;
        String[][] nombre_Categoria = new String[CANTIDAD_CLIENTES][20];
        int[][] id_anio_prestamo = new int[CANTIDAD_CLIENTES][3];
        boolean[] disponible = new boolean[CANTIDAD_CLIENTES];

        //Prestamos
        int[][] prestamos = new int[30][3];  // ID Peliculas, ID Clientes, Dias prestamos
        String[][] pelicula_cliente = new String[30][2];



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
