import java.awt.*;
import javax.swing.*;

public class SimpleSwing{

	public static void main(String args[]){
		JFrame f = new JFrame("Hola prros"); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setLayout(new FlowLayout());
		
		f.add(new JLabel("+MENSAJE UNO"));
		f.add(new JButton("Boton uno"));
		f.add(new JButton("Boton dos"));
		f.add(new JButton("BOton Tres"));
		f.add(new JLabel("Mensaje 2"));
		
		f.pack();
		f.setVisible(true);
   	}

}
