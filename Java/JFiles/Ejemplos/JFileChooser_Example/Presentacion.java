import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FileChooser{
    public static void main(String args[]) {

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));

        chooser.setDialogTitle("DialogTitle");

        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("Directorio: " + chooser.getCurrentDirectory());
        }
    }
}
