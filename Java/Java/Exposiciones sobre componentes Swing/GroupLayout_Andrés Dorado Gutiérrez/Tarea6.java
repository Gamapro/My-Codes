import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tarea6 {
   static JFrame f;
   static JLabel headerLbl;
   static JLabel statusLbl;
   static JPanel controlPanel;
   static JLabel msglabel;

   public static void main(String[] args){
      f = new JFrame("Dorado Gutierrez");
      f.setSize(400,400);
      f.setLayout(new GridLayout(3, 1));
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      headerLbl = new JLabel("",JLabel.CENTER );
      statusLbl = new JLabel("",JLabel.CENTER);        
      statusLbl.setSize(350,100);
      
	  
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      
      f.add(headerLbl);
      f.add(controlPanel);
      f.add(statusLbl);
      headerLbl.setText("Layout in action: GroupLayout");      
      JPanel panel = new JPanel();
      
      panel.setSize(200,200);
      GroupLayout layout = new GroupLayout(panel);
      layout.setAutoCreateGaps(true);
      layout.setAutoCreateContainerGaps(true);
      
      JButton btn1 = new JButton("Button 1");
      JButton btn2 = new JButton("Button 2");
      JButton btn3 = new JButton("Button 3");

      layout.setHorizontalGroup(layout.createSequentialGroup()
         .addComponent(btn1)
         .addGroup(layout.createSequentialGroup()
         .addGroup(layout.createParallelGroup(
         GroupLayout.Alignment.LEADING)
         .addComponent(btn2)
         .addComponent(btn3))));
   
      layout.setVerticalGroup(layout.createSequentialGroup()
         .addComponent(btn1)
         .addComponent(btn2)
         .addComponent(btn3));
      
      panel.setLayout(layout);        
      controlPanel.add(panel);
      f.setVisible(true);  
   }
}
