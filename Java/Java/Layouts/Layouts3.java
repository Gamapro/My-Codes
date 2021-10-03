import java.awt.*;
import javax.swing.*;

public class Layouts3
{

	public static void main(String args[])
	{
		JFrame f = new JFrame("Prueba de GridLayout VAP");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		f.setLayout(new GridLayout(4,4));

		f.add(new JButton("UNO"));
		f.add(new JButton("DOS"));
		f.add(new JButton("TRES"));
		f.add(new JButton("CUATRO"));
		f.add(new JButton("CINCO"));
		
		f.pack();
		f.setVisible(true);
	}

		
}