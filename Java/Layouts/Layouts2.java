import java.awt.*;
import javax.swing.*;

public class Layouts2
{

	public static void main(String args[])
	{

		JFrame f = new JFrame("Prueba de BorderLayout VAP");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setLayout(new BorderLayout());

		f.add(new JButton("UNO"),BorderLayout.CENTER);
		f.add(new JButton("DOS"),BorderLayout.EAST);
		f.add(new JButton("TRES"),BorderLayout.WEST);
		f.add(new JButton("CUATRO"),BorderLayout.NORTH);
		f.add(new JButton("CINCO"),BorderLayout.SOUTH);
		
		f.pack();
		f.setVisible(true);
	}


		
}
