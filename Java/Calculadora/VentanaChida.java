import jv.getContentPane().setBackground(color);ava.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class VentanaChida{
	
	public static void main(String args[]){
			
		JFrame v = new JFrame("TAREA");
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setLayout(new GridLayout(2,1));
		v.setBounds(200,200,100,100);
		int r=197,g=190,b=190;
		v.setSize(800,800);	
		Color color = new Color(r,g,b);
		v.setLocationRelativeTo(null);
		v.setResizable(false);
		v.getContentPane().setBackground(color);
	
		// PRIMER PANEL	
		
		ImageIcon pantalla = new ImageIcon(VentanaChida.class.getResource("/pantalla.png"));
		ImageIcon delay = new ImageIcon(VentanaChida.class.getResource("/delay.png"));
		ImageIcon options = new ImageIcon(VentanaChida.class.getResource("/options.png"));
		ImageIcon alarm = new ImageIcon(VentanaChida.class.getResource("/alarm.png"));
		ImageIcon start = new ImageIcon(VentanaChida.class.getResource("/start.png"));
		ImageIcon action = new ImageIcon(VentanaChida.class.getResource("/action.png"));
		ImageIcon stop = new ImageIcon(VentanaChida.class.getResource("/stop.png"));
		ImageIcon menu = new ImageIcon(VentanaChida.class.getResource("/menu.png"));
		ImageIcon pantallita = new ImageIcon(VentanaChida.class.getResource("/pantallita.png"));
		ImageIcon vacio = new ImageIcon(VentanaChida.class.getResource("/empty.png"));
		ImageIcon war = new ImageIcon(VentanaChida.class.getResource("/war.png"));

		JPanel x = new JPanel();
		x.setLayout(new BorderLayout());
		
		JLabel warning = new JLabel();
		warning.setBackground(new Color(r-30,g-30,b-30));
		warning.setIcon(war);
		JLabel empty = new JLabel();
		empty.setBackground(color);
		empty.setIcon(vacio);
		JPanel pant = new JPanel();
		pant.setLayout(new BorderLayout());
		pant.add(new JLabel(pantallita),BorderLayout.CENTER);
		pant.setBackground(color);	
		JButton men = new JButton();
		men.setBackground(color);
		men.setOpaque(true);
		men.setIcon(menu);
		pant.add(men,BorderLayout.EAST);
		pant.add(empty,BorderLayout.WEST);
		pant.add(warning,BorderLayout.NORTH);
		x.add(pant,BorderLayout.NORTH);
		//x.add(new JLabel(pantalla));
		x.setBackground(color);

		JPanel centro = new JPanel();
		ImageIcon uno = new ImageIcon(VentanaChida.class.getResource("/uno.png"));
		ImageIcon dos = new ImageIcon(VentanaChida.class.getResource("/dos.png"));
		ImageIcon tres = new ImageIcon(VentanaChida.class.getResource("/tres.png"));
		ImageIcon cuatro = new ImageIcon(VentanaChida.class.getResource("/cuatro.png"));
		ImageIcon cinco = new ImageIcon(VentanaChida.class.getResource("/cinco.png"));
		ImageIcon seis = new ImageIcon(VentanaChida.class.getResource("/seis.png"));
		ImageIcon siete = new ImageIcon(VentanaChida.class.getResource("/siete.png"));
		ImageIcon ocho = new ImageIcon(VentanaChida.class.getResource("/ocho.png"));
		ImageIcon nueve = new ImageIcon(VentanaChida.class.getResource("/nueve.png"));		
		ImageIcon cero = new ImageIcon(VentanaChida.class.getResource("/cero.png"));
		ImageIcon enter = new ImageIcon(VentanaChida.class.getResource("/enter.png"));

		centro.setLayout(new GridLayout(3,3));
		JButton bots[] = new JButton[9];
		Color color2 = new Color(r-30,g-30,b-30);
		for(int i = 0;i<9;i++){
			bots[i] = new JButton();
			bots[i].setBackground(color2);
			bots[i].setOpaque(true);
		}
		centro.setBackground(color2);
		
		bots[0].setIcon(uno); centro.add(bots[0]);
		bots[1].setIcon(dos); centro.add(bots[1]);
		bots[2].setIcon(tres); centro.add(bots[2]);
		bots[3].setIcon(cuatro); centro.add(bots[3]);
		bots[4].setIcon(cinco); centro.add(bots[4]);
		bots[5].setIcon(seis); centro.add(bots[5]);
		bots[6].setIcon(siete); centro.add(bots[6]);
		bots[7].setIcon(ocho); centro.add(bots[7]);
		bots[8].setIcon(nueve); centro.add(bots[8]);

		JPanel centro2 = new JPanel();
		
		JButton[] bot2 = new JButton[2];	
		for(int i = 0;i<2;i++){
			bot2[i] = new JButton();
			bot2[i].setBackground(color2);
			bot2[i].setOpaque(true);
		}
		
		bot2[0].setIcon(cero); centro.add(bot2[0]);
		bot2[1].setIcon(enter); centro.add(bot2[1]);

		centro2.setLayout(new FlowLayout());
		centro2.add(bot2[0]);
		centro2.add(bot2[1]);
		centro2.setBackground(color2);

		JPanel centroide = new JPanel();
		//centroide.setLayout(new GridLayout(2,1));
		centroide.setLayout(new BorderLayout());
		centroide.add(centro,BorderLayout.CENTER);
		centroide.add(centro2,BorderLayout.SOUTH);
		centroide.setBackground(color2);
		x.add(centroide,BorderLayout.CENTER);
		//x.add(centroide);

		JPanel izq = new JPanel();
		JButton[] bizq = new JButton[2];	
		for(int i = 0;i<2;i++){
			bizq[i] = new JButton();
			bizq[i].setBackground(color);
			bizq[i].setOpaque(true);
		}
		
		bizq[0].setIcon(delay); centro.add(bizq[0]);
		bizq[1].setIcon(alarm); centro.add(bizq[1]);
		
		JPanel esp = new JPanel();
		esp.setBackground(color);
		esp.setBounds(0,0,0,0);	
		izq.setLayout(new BoxLayout(izq,BoxLayout.PAGE_AXIS));
		//izq.add(esp);
		izq.add(bizq[0]);
		JLabel aux = new JLabel(options); aux.setAlignmentX(Component.LEFT_ALIGNMENT);
		izq.add(aux);
		izq.add(bizq[1]);
		izq.setBackground(color);
		
		x.add(izq,BorderLayout.WEST);
		//x.add(izq);
		
		JPanel der = new JPanel();
		JButton[] bder = new JButton[2];	
		for(int i = 0;i<2;i++){
			bder[i] = new JButton();
			bder[i].setBackground(color);
			bder[i].setOpaque(true);
		}
		
		bder[0].setIcon(start); centro.add(bder[0]);
		bder[1].setIcon(stop); centro.add(bder[1]);
		
		der.setLayout(new BoxLayout(der,BoxLayout.PAGE_AXIS));
		der.add(bder[0]);
		der.add(new JLabel(action));
		der.add(bder[1]);		
		der.setBackground(color);
		
		x.add(der,BorderLayout.EAST);

		v.add(x);
		
		// PANEL ABAJO
		
		JPanel z = new JPanel();
		z.setLayout(new GridLayout(1,2));
		z.setBackground(color);

		// SEGUNDO PANEL
		
		JPanel k = new JPanel();
		k.setLayout(new BoxLayout(k,BoxLayout.PAGE_AXIS));
		k.setBackground(color);

		ImageIcon cone = new ImageIcon(VentanaChida.class.getResource("/cone.png"));
		ImageIcon conefi = new ImageIcon(VentanaChida.class.getResource("/conefi.png"));		
		ImageIcon firing = new ImageIcon(VentanaChida.class.getResource("/firing.png"));
		ImageIcon slow = new ImageIcon(VentanaChida.class.getResource("/slow.png"));
		ImageIcon graf1 = new ImageIcon(VentanaChida.class.getResource("/graf1.png"));
		ImageIcon med = new ImageIcon(VentanaChida.class.getResource("/med.png"));	
		ImageIcon graf2 = new ImageIcon(VentanaChida.class.getResource("/graf2.png"));
		ImageIcon fast = new ImageIcon(VentanaChida.class.getResource("/fast.png"));
		ImageIcon graf3 = new ImageIcon(VentanaChida.class.getResource("/graf3.png"));

		JButton[] vel = new JButton[3];	
		for(int i = 0;i<3;i++){
			vel[i] = new JButton();
			vel[i].setBackground(color);
			vel[i].setOpaque(true);
		}
		vel[0].setIcon(slow);
		vel[1].setIcon(med);
		vel[2].setIcon(fast);

		JButton con2 = new JButton();	
		con2.setBackground(color);
		con2.setOpaque(true);
		con2.setIcon(cone);
		JPanel con = new JPanel();
		con.setLayout(new FlowLayout());
		con.add(con2);
		con.add(new JLabel(conefi));
		con.setBackground(color);
		k.add(con);

		JPanel fir = new JPanel();
		fir.setLayout(new BoxLayout(fir,BoxLayout.X_AXIS));
		fir.setAlignmentX(Component.RIGHT_ALIGNMENT);
		fir.add(new JLabel(firing));
		fir.setBackground(color);
		k.add(fir);
		
		JPanel slo = new JPanel();
		slo.setLayout(new FlowLayout());
		slo.add(vel[0]);
		slo.add(new JLabel(graf1));
		slo.setBackground(color);
		k.add(slo);

		JPanel medi = new JPanel();
		medi.setLayout(new FlowLayout());
		medi.add(vel[1]);
		medi.add(new JLabel(graf2));
		medi.setBackground(color);
		k.add(medi);

		JPanel fa = new JPanel();
		fa.setLayout(new FlowLayout());
		fa.add(vel[2]);
		fa.add(new JLabel(graf3));
		fa.setBackground(color);
		k.add(fa);

		z.add(k);
		
		// TERCER PANEL
		
		JPanel ora = new JPanel();
		ora.setLayout(new GridLayout(3,2));
		ora.setBackground(color);
		ImageIcon ramph = new ImageIcon(VentanaChida.class.getResource("/ramph.png"));
		ImageIcon ramp = new ImageIcon(VentanaChida.class.getResource("/ramp.png"));
		ImageIcon current = new ImageIcon(VentanaChida.class.getResource("/current.png"));
		ImageIcon view = new ImageIcon(VentanaChida.class.getResource("/view.png"));
		ImageIcon review = new ImageIcon(VentanaChida.class.getResource("/review.png"));
		ImageIcon conet = new ImageIcon(VentanaChida.class.getResource("/conet.png"));
		
		JButton[] ya = new JButton[4];	
		for(int i = 0;i<4;i++){
			ya[i] = new JButton();
			ya[i].setBackground(color);
			ya[i].setOpaque(true);
		}
		ya[0].setIcon(ramp);
		ya[1].setIcon(view);
		ya[2].setIcon(review);
		ya[3].setIcon(conet);

		ora.add(new JLabel(ramph));
		ora.add(ya[0]);	
		ora.add(new JLabel(current));
		ora.add(ya[1]);	
		ora.add(ya[2]);	
		ora.add(ya[3]);	

		z.add(ora);

		v.add(z);

		v.pack();
		v.setVisible(true);
	}

}
