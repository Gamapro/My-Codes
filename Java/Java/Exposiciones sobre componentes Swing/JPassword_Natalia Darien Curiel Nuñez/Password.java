import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Password{

  static JPasswordField pass = new JPasswordField(20); //aqui podemos especificar # de caracteres
  static JButton btn = new JButton("Ok");
  static JLabel lbl = new JLabel("Password: ");

public static void main(String args[])
  {

    JFrame f = new JFrame("Ejemplo JPasswordField");
    JPanel panel = new JPanel();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    pass.setEchoChar('*'); // cambia el caracter
    panel.add(pass);
    panel.add(btn);
    panel.add(lbl);


btn.addActionListener(new ActionListener(){

    public void actionPerformed(ActionEvent e){

    String passText = new String(pass.getPassword()); //convierte la contaseña a string

    lbl.setText("Password = "+ passText);

    }

    });

    f.add(panel);
    f.setSize(400, 200);
    f.setVisible(true);

  }
}
