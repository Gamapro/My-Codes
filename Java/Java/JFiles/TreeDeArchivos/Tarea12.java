import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.tree.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.io.IOException;

public class Tarea12{
		
	static JButton bot = new JButton("Seleccionar carpeta ...");
	static JTree tree = new JTree(new DefaultMutableTreeNode("..."));
	static JScrollPane sb = new JScrollPane(tree);
	static DefaultTreeCellRenderer r = new DefaultTreeCellRenderer();

	public static void main(String args[]){
		
		JFrame v = new JFrame("Arcos Bravo David Gamaliel");
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setLayout(new BorderLayout());
		v.setPreferredSize(new Dimension(650,400));
		v.setResizable(false);
		v.setLocationRelativeTo(null);

		r.setLeafIcon(new DefaultTreeCellRenderer().getOpenIcon());
		tree.setCellRenderer(r);

		bot.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent eve){
				FileChooser cosa = new FileChooser();
				tree.setModel(cosa.createTree());
				//tree = cosa.createTree();
			}	
		});
		
		v.add(sb,BorderLayout.CENTER);
		v.add(bot,BorderLayout.NORTH);
		
		v.pack();
		v.setVisible(true);
	}

}



