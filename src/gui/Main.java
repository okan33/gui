package gui;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                form formProje;
                try {
                    formProje = new form();
                    formProje.setTitle("Okan Acer PROJECT");
                    formProje.setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
