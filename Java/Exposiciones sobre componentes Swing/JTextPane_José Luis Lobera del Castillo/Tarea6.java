// José Luis Lobera del Castillo
// Programación Orientada a Objetos
// java version "1.8.0_241"

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.io.IOException;

//Toda la clase extiende a JPanel
public class Tarea6 extends JPanel {
  //Clase con instrucciones generales
  public Tarea6() {
    setLayout(new FlowLayout());
    //Crea un JTextPane y le da formato
    JTextPane textPane = crearTextPane();

    JScrollPane scroll = new JScrollPane(textPane);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scroll.setPreferredSize(new Dimension(250, 400));
    JPanel p = new JPanel();
    p.add(scroll);
    add(p);
  }

// Metodo para crear JTextPane especifico
  public JTextPane crearTextPane() {
    // Texto que se verá en la pantalla
      String[] texto =
              { "Este es un JTextPane editable, ",                //regular
                "otro ",                                          //italic
                "componente ",                                    //bold
                "de texto ",                                      //small
                "con estilo, ",                                   //large
                "le puedes agregar varios componentes..." + "\n", //regular
                " " + "\n",                                       //button
                "...y varios iconos..." + "\n",                   //regular
                " ",                                              //icon
                "\n \n" + "JTextPane es una subclase de JEditorPane que " +
                  "utiliza StyledEditorKit y StyledDocument, y te da " +
                  "varios metodos para interacctuar con estos objetos."
               };
      // Arreglo con los estilos que le voy a dar
      String[] str_estilos = { "regular", "italic", "bold", "small", "large","regular", "button", "regular", "icon","regular"};
      //Creación del JTextPane y extraccion del documento
      JTextPane textPane = new JTextPane();
      StyledDocument doc = textPane.getStyledDocument();
      //Llamada a metodo para dar estilo
      estilos(doc);

      //Try/Catch por que suele arrojar un BadLocationException
      try {
          for (int i=0;i < texto.length;i++) {
            // Insert string (Donde va a colocar, que va a colocar, como lo va a colocar)
              doc.insertString(doc.getLength(), texto[i],doc.getStyle(str_estilos[i]));
          }
      } catch (BadLocationException ex) {

      }
      // Regresa el JTextPane
      return textPane;
  }
  //Metodo que le da estilo a mi documento
  public void estilos(StyledDocument doc) {
      Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
      //Estilo "default" con font Verdana
      Style regular = doc.addStyle("regular", def);
      StyleConstants.setFontFamily(def, "Verdana");
      //Estilo italico
      Style s = doc.addStyle("italic", regular);
      StyleConstants.setItalic(s, true);
      //Estilo negritas
      s = doc.addStyle("bold", regular);
      StyleConstants.setBold(s, true);
      //Lestras pequeñas
      s = doc.addStyle("small", regular);
      StyleConstants.setFontSize(s, 10);
      //Letras grandes
      s = doc.addStyle("large", regular);
      StyleConstants.setFontSize(s, 20);
      //Estilo de iconos es "default"
      s = doc.addStyle("icon", regular);

      // Insertar el gif
      ImageIcon gif = new ImageIcon(new Object().getClass().getResource("/cat.gif"));
      if (gif != null) {
          StyleConstants.setIcon(s, gif);
      }
      s = doc.addStyle("button", regular);

      //Insertar la imagen
      ImageIcon javalogo = new ImageIcon(new Object().getClass().getResource("/java.png"));
      Image jl = javalogo.getImage().getScaledInstance(50, 75,  java.awt.Image.SCALE_SMOOTH);
      javalogo = new ImageIcon(jl);
      JButton button = new JButton();
      if (javalogo != null) {
          button.setIcon(javalogo);
      }
      StyleConstants.setComponent(s, button);
  }

  public static void main(String[] args){
    JFrame f = new JFrame("JTextPane");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    f.add(new Tarea6());

    f.pack();
    f.setVisible(true);
  }
}
