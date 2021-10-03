import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JSlider;
import javax.swing.JFrame;

public class Slider{
	//Se instancian antes para poderlos usar abajo y estaticos (static) también para poder ser usados en nuestro método creado.
	static JSlider slider; 
	static JLabel label; 

	public static void main(String[] args){

		JFrame f = new JFrame("CORRAL CORNEJO");
		f.setSize(400,400);
		JPanel panel = new JPanel();
		//Posicion vertical/horizontal en donde: empieza,termina, empieza al correr el programa
		slider = new JSlider(JSlider.VERTICAL, 0, 100, 25);
		//Se invierte el relleno del JSlider desde donde comienza
		slider.setInverted(true);
		//Pinta las rayas
		slider.setPaintTicks(true); 
		//Espacio entre las rayas grandes
		slider.setMajorTickSpacing(25); 
		//Espacio entre las rayas pequeñas
		slider.setMinorTickSpacing(5); 
		//Los números del Slider
		slider.setPaintLabels(true);
		//Listener
		slider.addChangeListener(new Accion());


		label = new JLabel("Escala de poder");
		
		//Agregar label al panel
		panel.add(label);
		//Agregar slider al panel
		panel.add(slider);


		//Agrega panel a la ventana(JFrame)
		f.add(panel);
		//Visible para nosotros
		f.setVisible(true);
		//Al picarle al "x" se sale del programa
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}

	//Metodo para actualizar el valor del slide en el label
	public static class Accion implements ChangeListener{

		public void stateChanged(ChangeEvent e){	
			//Toma el valor que tiene el Slider y se lo asign a evaluar como entero
			int evaluar = slider.getValue();	
			//Convierte el entero evaluar en String para poderlo imprimir.
			String evaluar1 = Integer.toString(evaluar);

			label.setText(evaluar1);

}

}

}
