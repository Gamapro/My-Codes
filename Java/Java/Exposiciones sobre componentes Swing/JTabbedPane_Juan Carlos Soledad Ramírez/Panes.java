import java.awt.*;
import javax.swing.*;

public class Panes extends JFrame {

    private static final long serialVersionUID = 1L;

    static JTabbedPane pane = new JTabbedPane();
    
    static JPanel panel1;
    static JPanel panel2;
    static JPanel panel3;
    static JPanel panel4;

    static JLabel label1 = new JLabel("Windows");
    static JLabel label2 = new JLabel("Mac");
    static JLabel label3 = new JLabel("Android");
    static JLabel label4 = new JLabel("Configuracion");

    static ImageIcon im, win, mac, and;

    public Panes(){
        super("JTabbedPane Example");
        setDefaultCloseOperation(3);

        im = new ImageIcon(getClass().getResource("/settings.png"));
        win = new ImageIcon(getClass().getResource("/windows.png"));
        mac = new ImageIcon(getClass().getResource("/mac.png"));
        and = new ImageIcon(getClass().getResource("/android.png"));

        panel1 = new JPanel(new BorderLayout());
        panel2 = new JPanel(new BorderLayout());
        panel3 = new JPanel(new BorderLayout());
        panel4 = new JPanel(new BorderLayout());
        
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setHorizontalAlignment(SwingConstants.CENTER);

        panel1.add(label1,BorderLayout.NORTH);
        panel1.add(new JLabel(win),BorderLayout.CENTER);
        panel2.add(label2,BorderLayout.NORTH);
        panel2.add(new JLabel(mac),BorderLayout.CENTER);
        panel3.add(label3,BorderLayout.NORTH);
        panel3.add(new JLabel(and),BorderLayout.CENTER);
        panel4.add(label4,BorderLayout.NORTH);
        
        String p1 = new String("Pestana Uno");
        String p2 = new String("Pestana Dos");
        String p3 = new String("Pestana Tres");
        String p4 = new String("Pestana Cuatro");

        pane.addTab(p1, panel1);
        pane.setToolTipTextAt(0, "Windows");
        pane.addTab(p2, panel2);
        pane.setToolTipTextAt(1, "Mac");
        pane.addTab(p3, panel3);
        pane.setToolTipTextAt(2, "Android");
        pane.addTab(p4,im, panel4);
        pane.setToolTipTextAt(3, "Configuracion");

        add(pane);
        pack();
        setSize(600, 400);

        try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } 
        catch (Exception e) { 
            System.out.println("Look and Feel not set"); 
        } 
    }

    public static void main(String[] args) {
        Panes panes = new Panes();
        panes.setVisible(true);
    }
}