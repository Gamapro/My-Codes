import javax.swing.JFileChooser;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Presentacion {
    public static void main(String s[]) {

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));

        chooser.setDialogTitle("De la Mora Alvarez Jose Miguel");

        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("Directorio: " + chooser.getCurrentDirectory());
        }
    }
}
