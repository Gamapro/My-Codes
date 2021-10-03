import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.RenderingHints;

public class ArcosBravo{
		
	static JTextArea[] t = new JTextArea[4];
	static String lab[] = {"A","B","C","D","El polinomio es: ","-------"};
	static JScrollPane[] sb = new JScrollPane[4];
	static JButton mostrar = new JButton("Mostar");
	static JPanel[] jp = new JPanel[2];
	static int i,j,pot; static int[] co = new int[4];
	static boolean si;
	static JLabel l = new JLabel();
	static JLabel[] eti = new JLabel[4];
	static JPanel[] pan = new JPanel[4];
	static String[] pots = {"","x","x²","x³"};

	public static void main(String args[]){
		JFrame f = new JFrame("Arcos Bravo David Gamaliel");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		
		for(i=0;i<2;i++){ jp[i] = new JPanel(); }
	    jp[0].setLayout(new GridLayout(2,5,5,5));
	 	jp[1].setLayout(new FlowLayout(FlowLayout.CENTER));	
		
		for(i=0;i<4;i++){
			pan[i] = new JPanel(new GridLayout(2,1));
			eti[i] = new JLabel(lab[i]);
			t[i] = new JTextArea("0",1,5);
			pan[i].add(eti[i]); pan[i].add(t[i]);
			jp[0].add(pan[i]);
			co[i]=0;
		}
		
		mostrar.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent even){
				String s = "",aux=""; si=true;
				for(i=0;i<4&&si;i++){
				   	s= t[i].getText(); pot=1;
					co[i]=0;
					try {
						co[i] = Integer.parseInt(s);
					} catch (NumberFormatException nfe){
						si = false;
					}
					if(i>0 && si && co[i]>=0)aux+="+";
					aux+=s+pots[i]+" ";
				}
				if(si) { l.setText(lab[4]+aux);
					ScatterPlot show = new ScatterPlot(co);
					show.show();
				}
				else l.setText("Ingrese coeficientes validos");
		}});

		l.setText(lab[4]+lab[5]);	
		jp[1].add(mostrar); jp[1].add(l);
		f.add(jp[0],BorderLayout.NORTH);
		f.add(jp[1],BorderLayout.SOUTH);
		
		f.setPreferredSize(new Dimension(400,170));
		f.setBounds(200,400,15,15);
		f.setLocationRelativeTo(null);
		f.pack();
		f.setVisible(true);

	}	
}

