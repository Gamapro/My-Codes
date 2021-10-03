import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class test {
    static MaskFormatter formato(String formatoStr) {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter(formatoStr);
            mask.setPlaceholderCharacter('_'); 
        } catch (java.text.ParseException exc) {
            System.err.println("formato invalido ");
        }
        return mask;
    }

    static JFormattedTextField JFTF = new JFormattedTextField(formato(" ## / ?? / ####  ##:##"));
    static JTextField nombre = new JTextField("tu nombre");
    static JLabel texto = new JLabel("------");
   
    public static void main(String[] args) {
        JFrame pantalla = new JFrame("Franz Rivera Tellez :)");
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla.setLayout(new GridLayout(4, 1, 10, 10));
        pantalla.add(JFTF);
        JButton btn = new JButton("holas");
        pantalla.add(nombre);
        pantalla.add(texto);
        pantalla.add(btn);


        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText(nombre.getText() + " ingreso el dia: " + JFTF.getValue()+" ");
                System.out.println(JFTF.getValue());
                System.out.println(JFTF.isEditValid());                
            }
        });

        pantalla.setSize(300, 300);
        pantalla.setVisible(true);
    }

}