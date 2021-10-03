import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

public class Conjuntos{
	
	static TreeSet<String> a = new TreeSet<>(),b = new TreeSet<>(), c = new TreeSet<>();
	static int i,j;
	static JScrollPane[] sb = new JScrollPane[3];
	static JTextArea[] t = new JTextArea[3];
	static JRadioButton[] bot = new JRadioButton[6];
	static String bl[] = {"A","B","A ∩ B","A ∪ B","A-B","B-A"};
	static ButtonGroup grupo = new ButtonGroup();
	static ImageIcon[] ima = new ImageIcon[6];
	static JLabel foto = new JLabel();
	static JPanel bots = new JPanel(new GridLayout(3,2,5,5)); 
	static String te[] = {}, aux = "";

	public static void main(String args[]){
		
		JFrame v = new JFrame("Arcos Bravo David Gamaliel");
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setLayout(new BorderLayout());
		v.setPreferredSize(new Dimension(980,630));
		v.setResizable(false);
		v.setLocationRelativeTo(null);

		JPanel[] p = new JPanel[3];
		for(i=0;i<3;i++){
			p[i] = new JPanel();
			t[i] = new JTextArea(10,10);
			sb[i] = new JScrollPane(t[i]);
		}

		v.add(p[0],BorderLayout.NORTH);
		v.add(p[1],BorderLayout.CENTER);
		v.add(p[2],BorderLayout.SOUTH);
		
		p[0].setLayout(new GridLayout(1,2,4,4));
		p[1].setLayout(new GridLayout(1,2,4,4));
		p[2].setLayout(new GridLayout(1,2));
	
		for(i=0;i<6;i++){
			final int _i = i;
			bot[i] = new JRadioButton(bl[i]);
			grupo.add(bot[i]);
			ima[i] = new ImageIcon(Conjuntos.class.getResource("/img/"+bl[i]));
			bots.add(bot[i]);	
			bot[i].addActionListener( new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent eve){
					foto.setIcon(ima[_i]);
					a.clear(); b.clear();
					te = t[0].getText().split(" ");
					for(j=0;j<te.length;j++){ a.add(te[j]); }
					te = t[1].getText().split(" ");
					for(j=0;j<te.length;j++){ b.add(te[j]); }
					aux = "";
					t[2].setText("");
					if( _i == 0){ // A
						for(String x : a){ aux+= x + " "; }
					}else if( _i == 1){ // B
						for(String x : b){ aux+= x + " "; }
					}else if(_i == 2){ // A ∩ B
						c.clear();
						for(String x : a){
							if(b.contains(x)){
								c.add(x);
							}
						}
						for(String x : c){ aux+= x + " "; }	
					}else if(_i == 3){ // A ∪ B
						a.addAll(b);
						for(String x : a){ aux+= x + " "; }
					}else if(_i == 4){ // A-B
						for(String x : b){
							if(a.contains(x)){
									a.remove(x);
							}
						}
						for(String x : a){ aux+= x + " "; }
					}else if(_i == 5){ // B-A
						for(String x : a){
							if(b.contains(x)){
									b.remove(x);
							}	
						}
						for(String x : b){ aux+= x + " "; }
					}
					t[2].setText(aux);
				}
			});
		}
		p[0].add(sb[0]); p[0].add(sb[1]);
		p[1].add(bots); p[1].add(foto);
		p[2].add(sb[2]);
		

		v.pack();
		v.setVisible(true);
	}



}
