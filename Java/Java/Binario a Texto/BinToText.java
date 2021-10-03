import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

public class BinToText{
	
	static JComboBox com = new JComboBox();
	static JTextArea text[] = new JTextArea[2];
	static JScrollPane[] sb = new JScrollPane[2];
	static JPanel p[] = new JPanel[2];
	static int i = 0;
	static JLabel lb[] = new JLabel[2];
	static JButton bots[] = new JButton[3]; 
	//static char[] a = {' ','\n','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
	//static String[] b = {" ","\n",".-", "-...", "-.-.", "-..",".", "..-.", "--.", "....","..", ".---", "-.-", ".-..", "--", "-.","---", ".--.","--.-", ".-.","...", "-","..-", "...-",".--", "-..-","-.--", "--..","-----",".----","..---","...--","....-",".....","-....","--..","---..","----."};

	public static void main(String args[]){
		
		JFrame v = new JFrame("Arcos Bravo David Gamaliel");
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		for(i=0;i<2;i++){
			lb[i] = new JLabel();
			p[i] = new JPanel(new BorderLayout());
			text[i] = new JTextArea(10,25);
			sb[i] = new JScrollPane(text[i]);
			p[i].add(lb[i],BorderLayout.NORTH);
			p[i].add(sb[i],BorderLayout.CENTER);
		}
		lb[0].setText("TEXT"); lb[1].setText("BIN");
		
		JPanel p2 = new JPanel(); p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
		for(int index=0;index<3;index++){
			bots[index] = new JButton();
			final int i = index;
			bots[index].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent even){
					if(i==0){
						String s = text[i].getText(), fin="";
						for(int _i=0;_i<s.length();_i++){
						   	fin+=Integer.toBinaryString(s.charAt(_i))+" ";
						}
						text[(i+1)%2].append(fin);
					}else if(i==1){
						String aux = text[i].getText(),fin="";
						String s2[] = aux.split(" ");
						String s = "";
						for(String s3 : s2){
							s+=(char)Integer.parseInt(s3,2);
						}
						text[(i+1)%2].append(s);
					}else{
						for(int j=0;j<2;j++) text[j].setText("");
					}
				}
			});
			p2.add(bots[index]); if(index!=2)p2.add(new JPanel());
		}
		bots[0].setText("TEXT TO BIN"); bots[1].setText("BIN TO TEXT");
		bots[2].setText("     CLEAR     ");
		
		v.add(p[0]);
		v.add(p2);
		v.add(p[1]);
		v.setBounds(200,400,15,15);
		v.setLocationRelativeTo(null);
		v.pack();
		v.setVisible(true);	
	}

}	
