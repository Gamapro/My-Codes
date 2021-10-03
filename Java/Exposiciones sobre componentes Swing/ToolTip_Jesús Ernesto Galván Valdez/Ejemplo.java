import java.awt.*;
import javax.swing.*;
public class ToolTipTextSample extends JFrame {

    private JLabel label;
    private JTextField textField;
    private JButton button;

    public ToolTipTextSample() {
        setTitle("Ejemplo ");
        setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addComponents();
    }

    private void addComponents(){
        label = new JLabel("Usuario:");
        label.setToolTipText("Introduce de nombre usuario");

        textField = new JTextField(10);
        textField.setToolTipText("Nombre de usuario");

        button = new JButton("Aceptar");
        button.setToolTipText("Pulsa el botón aceptar");

        add(label);
        add(textField);
        add(button);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try{
                    new ToolTipTextSample();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}