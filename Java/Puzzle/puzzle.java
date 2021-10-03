import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

public class puzzle{
	
	static JButton bot[][] = new JButton[2][2]; 
	static int state[][] = new int[2][2];
	static int i,j;

	public static void main(String args[]){
		
		JFrame v = new JFrame("Arcos Bravo");
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setLayout(new GridLayout(2,2));
		v.setBounds(100,100,0,0);
		v.setLocationRelativeTo(null);

		ImageIcon img[][] = new ImageIcon[2][2];
		for(i=0;i<2;i++){
			for(j=0;j<2;j++){
				final int _i = i, _j = j;
				bot[i][j] = new JButton();
				state[i][j] = 0;
				bot[i][j].setOpaque(true);
				bot[i][j].setIcon(new ImageIcon(puzzle.class.getResource("/"+i+j+0)));
				bot[i][j].addActionListener(
					new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e){
							state[_i][_j] = (state[_i][_j]+1)%2;
							bot[(_i+1)%2][(_j+1)%2].setIcon(		
								new ImageIcon(puzzle.class.getResource("/"+((_i+1)%2)+((_j+1)%2)+state[_i][_j]))
							);
						}
					}	
				);
			}
		}
		
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				v.add(bot[i][j]);
			}
		}
		
		v.pack();
		v.setVisible(true);	
	}

}	
