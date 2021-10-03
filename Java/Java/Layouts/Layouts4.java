import java.awt.*;
import javax.swing.*;

public class Layouts4
{

	public static void main(String args[])
	{
		JFrame f = new JFrame("Prueba de BoxLayout VAP");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//El constructor requiere argumentos adicionales
		f.setLayout(new BoxLayout(f.getContentPane(),BoxLayout.Y_AXIS));

		f.add(new JButton("UNO"));
		f.add(new JButton("DOS"));
		f.add(new JButton("TRES"));
		f.add(new JButton("CUATRO"));
		f.add(new JButton("CINCO"));
		
		f.pack();
		f.setSize(200,200);
		f.setVisible(true);
	}

}