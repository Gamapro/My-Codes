import java.awt.*;
import javax.swing.*;

public class VentanaPrueba{
	
	public static void main(String args[]){
		JFrame w = new JFrame("CARO-CHAN");
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//w.setLayout(new BorderLayout());
		w.setLayout(new GridLayout(2, 2));
		w.add(new JButton("1"));
		w.add(new JButton("2"));
		w.add(new JButton("3"));
		
		/*
		JPanel chiquito = new JPanel();
		chiquito.setLayout(new GridLayout(3,1));	
		chiquito.add(new Button("4"));
		JPanel chico2 = new JPanel();
		chico2.setLayout(new GridLayout(1,3));
		chico2.add(new Button("5"));
		chico2.add(new Button("6"));
		chico2.add(new Button("7"));

		chiquito.add(chico2);
		chiquito.add(new Button("8"));
		*/

		JPanel chiquito = new JPanel();
		chiquito.setLayout(new BorderLayout());
		chiquito.add(new Button("6"),BorderLayout.CENTER);
		chiquito.add(new Button("4"),BorderLayout.NORTH);
		chiquito.add(new Button("5"),BorderLayout.EAST);
		chiquito.add(new Button("7"),BorderLayout.WEST);
		chiquito.add(new Button("8"),BorderLayout.SOUTH);
		w.add(chiquito);

		w.pack();
		w.setVisible(true);
	} 

}
