import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.imageio.*;
import java.io.*;

public class Pila{

	static Stack<String> p = new Stack<>();
	static JButton but[] = new JButton[2];
	static String labe[] = {"Push","Pop"};
	static int i,j;
	static JTextField[] tf = new JTextField[2]; 
	static JTextArea t = new JTextArea(15,15);
	static JScrollPane sb  = new JScrollPane(t);
	static JPanel pan[] = new JPanel[2];

	public static void main(String[] args){
		
		JFrame v = new JFrame("Arcos Bravo");
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setLayout(new FlowLayout());
		v.setPreferredSize(new Dimension(280, 360));
		v.setResizable(false);
		v.setLocationRelativeTo(null);

		for(int i=0;i<2;i++){
			tf[i] = new JTextField("...",10);
			but[i] = new JButton(labe[i]);
			pan[i] = new JPanel(new FlowLayout());
			final int _i = i;
			but[i].addActionListener( new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent eve){
					if(_i==0){ // PUSH
						String s = tf[0].getText();
						p.push(s);
						String pex = "";
						Stack<String> sta = new Stack<>();
						for(String x : p)sta.push(x);
						while(!sta.empty()){ pex+=sta.peek()+"\n"; sta.pop(); }
						t.setText(pex);
						//t.setText(p.toString());
						tf[0].setText("");
					}else{  // POP
						String s = "";
						if(!p.empty()){
							s = p.peek();
							p.pop();
						}
						String pex = "";
						Stack<String> sta = new Stack<>();
						for(String x : p)sta.push(x);
						while(!sta.empty()){ pex+=sta.peek()+"\n"; sta.pop(); }
						t.setText(pex);
						//t.setText(p.toString());
						tf[1].setText(s);
					}
				}
			});
		}
		
		pan[0].add(tf[0]); pan[0].add(but[0]);
		pan[1].add(but[1]); pan[1].add(tf[1]); 
		v.add(pan[0]); v.add(pan[1]); v.add(sb);

		v.pack();
		v.setVisible(true);
	}

}

