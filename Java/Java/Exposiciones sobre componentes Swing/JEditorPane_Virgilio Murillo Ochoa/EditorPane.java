import javax.swing.JEditorPane;    
import javax.swing.JFrame;    
import javax.swing.text.EditorKit;
import javax.swing.*;

public class EditorPane {
JFrame myFrame = null;  
    public static void main(String[] args) {
        (new EditorPane()).test();  
    }
     private void test() {    
        myFrame = new JFrame("JEditorPane Test");    
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        myFrame.setSize(400, 200);    
        JEditorPane myPane = new JEditorPane();    
        myPane.setContentType("text/html");    
        myPane.setText("<h1>encabezado</h1><p>texto normal y corriente<p>");
        myFrame.setContentPane(myPane);    
        myFrame.setVisible(true);  
    }
    }   