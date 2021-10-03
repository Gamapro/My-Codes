import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.util.*;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class TreeExample
{
	static JTree tree;
	static JLabel sel;
	
	public static void main(String[] args) {
		JFrame f= new JFrame("Maria Cristina Velazquez Garcia");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("IIA");
		DefaultMutableTreeNode semestre1 = new DefaultMutableTreeNode("1 Semestre");
		semestre1.add(new DefaultMutableTreeNode("Calculo"));
		semestre1.add(new DefaultMutableTreeNode("Algebra"));
		semestre1.add(new DefaultMutableTreeNode("Fisica"));
		semestre1.add(new DefaultMutableTreeNode("Analisis y diseño de algorit"));
		semestre1.add(new DefaultMutableTreeNode("Quimica"));
		semestre1.add(new DefaultMutableTreeNode("Historia"));
		
		DefaultMutableTreeNode semestre2 = new DefaultMutableTreeNode("2 Semestre");
		semestre2.add(new DefaultMutableTreeNode("Calculo"));
		semestre2.add(new DefaultMutableTreeNode("Algebra"));
		semestre2.add(new DefaultMutableTreeNode("Mecanica"));
		semestre2.add(new DefaultMutableTreeNode("POO"));
		semestre2.add(new DefaultMutableTreeNode("Estructuras I"));
		semestre2.add(new DefaultMutableTreeNode("Persona"));
		
		DefaultMutableTreeNode semestre3 = new DefaultMutableTreeNode("3 Semestre");
		semestre3.add(new DefaultMutableTreeNode("Calculo"));
		semestre3.add(new DefaultMutableTreeNode("Algebra"));
		semestre3.add(new DefaultMutableTreeNode("Mecanica"));
		semestre3.add(new DefaultMutableTreeNode("POO"));
		semestre3.add(new DefaultMutableTreeNode("Estructuras I"));
		semestre3.add(new DefaultMutableTreeNode("Persona"));
		root.add(semestre1);
		root.add(semestre2);
		root.add(semestre3);
		tree= new JTree(root);
		
		ImageIcon imageIcon= new ImageIcon(TreeExample.class.getResource("calendario/leaf.jpg"));
	    DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setLeafIcon(imageIcon);
		
		tree.setCellRenderer(renderer);
		tree.setShowsRootHandles(true);
		//tree.setRootVisible(false);
		f.add(new JScrollPane(tree),BorderLayout.CENTER);
		
		sel= new JLabel();
		f.add(sel, BorderLayout.SOUTH);
		
    tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        sel.setText(e.getPath().toString());
    }
    });
		f.setSize(300,300);
		f.setVisible(true);
	        
  }
}
