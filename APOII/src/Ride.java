import java.text.SimpleDateFormat;
import java.util.Date;

public class Ride {

    // ----------------------------------
    // CONSTANTS
    // ----------------------------------
    // en este caso, no es necesario poner algun numero dentro de los
    // corchetes al declaralos como fijo
    // arreglo de constantes. Ni los valores ni el tamano del
    // arreglo se pueden modificar.
    public static final char[] LETTERS = new char[] {'A', 'B', 'C', 'D', 'E'};
    public static final int ROWS = 15;

    // --------------------------
    // ATTRIBUTES
    // -----------------------------
    private Chair[][] chairs;
    // --------------------------
    // METHODS
    // ------------------------
    private void initializeChairs(){
        chairs = new Chair[ROWS][LETTERS.length];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < LETTERS.length; j++) {
                chairs[i][j] = new Chair(i, LETTERS[j]);
            }

        }
    }

    // metodo que permite cambiar el formato de una fecha
    public String formatoFecha(String cadena){
        SimpleDateFormat formato1 = new SimpleDateFormat("dd.MMM.yy 'at' HH:mm:ss");
        Date fecha = formato1.parse(cadena);

        SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return formato2.format(fecha);
    }

    public Date createDate(int year, int month, int day, int hours, int minutes){

    }

    public Chair getChair(String chairName){

    }

    public Date getDate(){

    }

    public String getDateHour(){

    }

    // asigna una silla al pasajero que se recie comom parametro,
    // si el pasajero con esa cedula ya tiene una reserva en el mismo vuelo,
    // el metodo lanza una excepcion.
    // si la silla esta ocupada, el metodo lanza una excepcion
    //
    public void chairBooking(String nChair, String name, int id){

    }

    // inserta el vuelo que llega como parametro despues del actual.
    // hay que tener en cuenta el enlace doble y los casos
    // en los cuales se trate del primer o ultimo nodo.
    public void insertAfter(Ride ride){

    }

    // Inserta el vuelo que llega como parametro
    // pero antes del actual.
    // hay que tener en cuenta el enlace doble y los casos
    // en los cuales se trate del primer o ultimo nodo.
    public void insertBefore(Ride ride){

    }
    // verifica que en el vuelo no haya dos reservas con el
    // mismo numero de identidad.
    public void verifyInvariant(){

    }

}












