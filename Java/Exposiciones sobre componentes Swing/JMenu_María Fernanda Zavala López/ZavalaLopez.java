import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ZavalaLopez 
{
    static JFrame marco = new JFrame(); //Creación de la ventana
    static JMenuBar barra = new JMenuBar(); //Creación de la Barra de menu
    static JMenu menu1 = new JMenu("Colores", false); //Creación del menu archivo
    static JMenu menu2 = new JMenu("Editar", true); //Creación del menu editar
    static JMenuItem item1 = new JMenuItem("Rojo"); //Creación de un item para el menu archivo
    static JMenuItem item2 = new JMenuItem("Verde"); //Creación de un item para el menu archivo
    static JMenuItem item3 = new JMenuItem("Azul"); //Creación de un item para el menu archivo
    static JMenuItem item4 = new JMenuItem("vacio"); //Creación de otro item pata el menu de archivo para editar
   
    public static void main(String[] args)
	{
        //configuraciones de rutina
        marco.setTitle("MENU");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLocationRelativeTo(null);
        marco.setSize(250, 100);
        marco.setLayout(null);
       
        menu1.add(item1);
        menu1.addSeparator(); //agrega un separador
        menu1.add(item2);
	menu1.addSeparator(); //agrega un separador
        menu1.add(item3);  
        barra.add(menu1);
       
        item4.setEnabled(false); //deshabilita este item
        menu2.add(item4);
        barra.add(menu2);
       

		
		item1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				marco.getContentPane().setBackground( Color.red);
			}
		});
		
		item2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				marco.getContentPane().setBackground( Color.green);
			}
		});
		item3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				marco.getContentPane().setBackground( Color.blue);
			}
		});


        barra.setBounds(5,5,230,12); //configuracion de la posicion y tamaño
        marco.add(barra);
       
        marco.setVisible(true);
    }
}