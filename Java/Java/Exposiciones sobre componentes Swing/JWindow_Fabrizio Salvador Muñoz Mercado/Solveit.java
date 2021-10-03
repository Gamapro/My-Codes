import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 
  
public class Solveit{ 
  static ImageIcon im = new ImageIcon(new Object().getClass().getResource("/mono.gif"));
    public static void main(String[] args) 
    { 
		
		
       JFrame f = new JFrame("JWindow");
	   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        JPanel p = new JPanel(); 
  
        JButton b = new JButton("Generar ventana"); 
  

        p.add(b); 
  
        f.add(p); 
  
       b.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
			
			String s = e.getActionCommand(); 
			
			if (s.equals("Generar ventana")) { 
            
            JWindow w = new JWindow(f); 
  
            // set panel 
            JPanel p = new JPanel(new FlowLayout()); 
  
            // create a label 
            JLabel l = new JLabel("Esta es la ventana generada");
			
  
            // set border 
            p.setBorder(BorderFactory.createLineBorder(Color.black)); 
  
            p.add(l);
			p.add(new JLabel(im));
            w.add(p); 
  
            // set background 
            p.setBackground(Color.white); 
  
            // setsize of window 
            w.setSize(300,245); 
  
            // set visibility of window 
            w.setVisible(true); 
  
            // set location of window 
            w.setLocation(100, 100); 
								} 
			}
			
			});
    
		f.pack();
		f.setVisible(true);
		
	
}

}