import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ej_JOptPan
{
	static JButton bot[] = new JButton[4];
	static JOptionPane opa[] = new JOptionPane[4];
	static String opc[] = {"Opcion 1","Opcion 2","Opcion 3"};
	static JLabel pru[] = new JLabel[3];
	
	public static void main(String[]args)
	{
		JFrame f = new JFrame("Ejemplos JOptionPane");
		f.setLayout(new GridLayout(2,3));
		
		for(int i=0;i<3;i++)
		{
			pru[i] = new JLabel("Texto Prueba " + (i+1));
		}
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2,1));
		p.add(pru[0]);
		p.add(pru[1]);
		
		opa[0] = new JOptionPane();
		
		bot[0] = new JButton("OptionDialog");
		bot[1] = new JButton("InputDialog");
		bot[2] = new JButton("ConfirmDialog");
		bot[3] = new JButton("MessageDialog");
		
		for(int i=0;i<4;i++)
		{
			if(i==2) f.add(p);
			bot[i].setBackground(Color.WHITE);
			f.add(bot[i]);
		}
		
		f.add(pru[2]);
		
		bot[0].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				pru[0].setText(opc[opa[0].showOptionDialog(f,"Mensaje","Titulo",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,new ImageIcon(new Object().getClass().getResource("/1.png")),opc,"Opcion 1")]);
			}
		});/**/
		
		bot[1].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				pru[1].setText(opa[1].showInputDialog(f,"Mensaje","Titulo",JOptionPane.QUESTION_MESSAGE));
			}
		});
		
		bot[2].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				pru[2].setText(opa[2].showConfirmDialog(f,"Mensaje","Titulo",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE)+"");
			}
		});
		
		bot[3].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				opa[3].showMessageDialog(f,"Mensaje","Titulo",JOptionPane.QUESTION_MESSAGE);
			}
		});
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(750,500);
		f.setResizable(false);
		f.setVisible(true);
	}
}