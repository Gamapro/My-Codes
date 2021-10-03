import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Spring{	
	public static void main(String args[]){
		JFrame uva = new JFrame("Ejemplo SpringLayout");		

		uva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = uva.getContentPane();
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
	
		JLabel lb = new JLabel("Texto: ");
		JTextField txtFld = new JTextField("",15);
		contentPane.add(lb);
		contentPane.add(txtFld);

		layout.putConstraint(SpringLayout.WEST,lb,5,SpringLayout.WEST,contentPane);
		layout.putConstraint(SpringLayout.NORTH,lb,5,SpringLayout.NORTH,contentPane);
		layout.putConstraint(SpringLayout.WEST,txtFld,5,SpringLayout.EAST,lb);
		layout.putConstraint(SpringLayout.NORTH,txtFld,5,SpringLayout.NORTH,contentPane);
		layout.putConstraint(SpringLayout.EAST,txtFld,-5,SpringLayout.EAST,contentPane);

		uva.pack();
		uva.setVisible(true);
	}
}