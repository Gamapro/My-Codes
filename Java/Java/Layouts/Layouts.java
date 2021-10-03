import java.awt.*;
import javax.swing.*;

public class Layouts
{

	public static void main(String args[])
	{
		JFrame f = new JFrame("Prueba de FlowLayout VAP");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setLayout(new FlowLayout(FlowLayout.LEADING,2,2));

		f.add(new JButton("UNO"));
		f.add(new JButton("DOS"));
		f.add(new JButton("TRES"));
		f.add(new JButton("CUATRO"));
		f.add(new JButton("CINCO"));
		
		f.pack();
		f.setVisible(true);
	}

	
}