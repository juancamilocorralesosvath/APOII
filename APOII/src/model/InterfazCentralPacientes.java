package model;

import javax.swing.*;
import java.util.ArrayList;

public class InterfazCentralPacientes extends JFrame {
    private Central central;

    public InterfazCentralPacientes() {
        ArrayList<String> hosp = new ArrayList<>();
        hosp.add("clinica reina sofia");
        hosp.add("clinica nuestra senora de los remedios");
        hosp.add("clinica de occidente");
        hosp.add("Hospital universitario del valle");
        hosp.add("imbanaco");
        hosp.add("fundacion valle del lili");
        System.out.println(hosp);

        // patients creation
        Pacient pacient11 = new Pacient(8, "Vania", hosp.get(4), "magnesium", 2, null);
        Pacient pacient10 = new Pacient(7, "Nelson", hosp.get(3), "", 1, pacient11);
        Pacient pacient9 = new Pacient(6, "Rosario", hosp.get(2), "", 2, pacient10);
        Pacient pacient8 = new Pacient(5, "Ramon", hosp.get(1), "hello world", 1, pacient9);
        Pacient pacient7 = new Pacient(4, "Natalia", hosp.get(0), "awesome discounts", 2, pacient8);
        Pacient pacient6 = new Pacient(3, "Roberto", hosp.get(5), "beautiful day", 1, pacient7);
        Pacient pacient5 = new Pacient(2, "carlos", hosp.get(4), "smart", 1, pacient6);
        Pacient pacient4 = new Pacient(1, "or", hosp.get(3), "smart", 1, pacient5);
        Pacient pacient3 = new Pacient(789, "maria", hosp.get(2), "smart girl", 2, pacient4);
        Pacient pacient2 = new Pacient(456, "perenzejo", hosp.get(1), "smart bouy", 1, pacient3);
        Pacient pacient1 = new Pacient(123, "pepito", hosp.get(0), "smart bouy", 1, pacient2);


        central = new Central(pacient1, 11, hosp);
    }

    public void mostrarDialogoPaciente() {
        DialogoInsertarPaciente dialogo = new DialogoInsertarPaciente(this);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    public static void main(String[] args) {

    }
}
