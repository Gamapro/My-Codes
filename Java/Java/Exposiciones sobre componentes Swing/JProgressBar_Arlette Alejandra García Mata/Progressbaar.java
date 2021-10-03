//ejemplo 1
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
public class Progressbaar { 
  
  
    public static void main(String args[]) 
    { 
  
       JFrame  f = new JFrame("ProgressBar"); 
       JPanel p = new JPanel(); 
  
        // create a progressbar 
        JProgressBar b = new JProgressBar(0,200); 
  
        b.setStringPainted(true); 
  
        p.add(b); 
        f.add(p); 
  
        f.setSize(100, 100); 
        f.setVisible(true); 
  
    } 
}
 /* //ejemplo 2
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
public class Progressbaar { 
  
  
    public static void main(String args[]) 
    { 
  
       JFrame  f = new JFrame("ProgressBar"); 
       JPanel p = new JPanel(); 
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setLayout(new GridLayout(2,3,1,1));


       JButton d = new JButton("AUMENTAR");
       d.setSize(1,1);
  
        // create a progressbar 
        JProgressBar b = new JProgressBar(0,100); 
        b.setValue(40);

        d.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
// agregaremos 10 cada que preionamos el boton
               b.setValue(b.getValue() + 10);
           }
        });
  
        b.setStringPainted(true); 
  
        p.add(b); 
        f.add(p); 
        f.add(d);
  
        f.setSize(100, 100); 
        f.setVisible(true); 
  
    } 
}

//Ejemplo 3
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
public class ProgresssBaar{ 
  
    static JFrame  f = new JFrame("ProgressBar"); 
    static JPanel p = new JPanel(); 
    static JButton d = new JButton("Iniciar");
    static JProgressBar b = new JProgressBar(0,100);
    static Timer t = null;
    static int i =0; 
    public static void main(String args[]) 
    { 
       

       
       f.setLayout(new GridLayout(2,3,2,2));
       b.setValue(0);
       f.add(b);
       f.add(d);
        
        
        d.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               if(t==null && i==0){ 
                    t = new Timer(100, new ActionListener(){ 
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        i++; 
                        if(i==100){ 
                            t.stop(); 
                            d.setText("Reiniciar");  
                        }

                        b.setValue(i); 
                    }
                    });
                    t.start(); 
                }
                else{ 
                    i=0; 
                    d.setText("Iniciar"); 
                    b.setValue(i); 
                    t.stop(); 
                    t = null; 
                }

           }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true); 
        f.setSize(200,100);
  

        
  
    } 
}*/