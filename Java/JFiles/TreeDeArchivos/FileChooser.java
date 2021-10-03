import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.io.File;
import javax.swing.tree.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class FileChooser{

	public FileChooser(){ }

	private void addNodes(DefaultMutableTreeNode padre, File f){
		File[] hijos = f.listFiles( new FileFilter(){
			@Override
			public boolean accept(File f){ return f.isDirectory(); }
		});
		for(File file : hijos){
			DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(bonito(file));
			padre.add(hijo);
			addNodes(hijo,file);
		}
	}

	private String bonito(File f){
		String s = f.toString();
		String arr[] = s.split("/");
		return arr[arr.length-1];
	}

    public DefaultTreeModel createTree(){
		
		JTree tree = new JTree();
        JFileChooser chooser = new JFileChooser();
		DefaultTreeCellRenderer r = new DefaultTreeCellRenderer();
		DefaultMutableTreeNode aux = new DefaultMutableTreeNode();

		r.setLeafIcon(new DefaultTreeCellRenderer().getOpenIcon());
		tree.setCellRenderer(r);

        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Seleccione un directorio");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(true);

        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            //System.out.println("Directorio: " + chooser.getCurrentDirectory());
			File f = chooser.getSelectedFile();
			DefaultMutableTreeNode root = new DefaultMutableTreeNode(bonito(f));
			tree.setModel(new DefaultTreeModel(root));
			addNodes(root,f);
			aux = root;
		}
			
		return new DefaultTreeModel(aux);
    }

}
