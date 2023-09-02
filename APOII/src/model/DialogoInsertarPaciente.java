package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoInsertarPaciente extends JDialog implements ActionListener {

    //----------------------------------
    // constantes
    //-----------------------------------
    private final static String AGREGAR = "Agregar";
    private final static String CANCELAR = "Cancelar";
    //----------------------------------------
    //Atributos
    //----------------------------------------
    private InterfazCentralPacientes principal;

    public DialogoInsertarPaciente(InterfazCentralPacientes ventana) {
        super(ventana, true);
        principal = ventana;
        pack();
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals(AGREGAR)) {
            System.out.println("agregar");
        } else {
            dispose();
        }
    }

    public static void main(String[] args) {

    }
}
