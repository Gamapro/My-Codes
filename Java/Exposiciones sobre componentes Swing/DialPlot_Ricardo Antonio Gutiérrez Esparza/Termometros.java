import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.plot.dial.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.*;
import org.jfree.data.general.*;

public class Termometros{
	public static void main(String args[]){
		JFrame f = new JFrame("Gutierrez Esparza");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		DialPlot celsiusDial = new DialPlot(new DefaultValueDataset(30));
		celsiusDial.setDialFrame(new StandardDialFrame());
		celsiusDial.addScale(0,new StandardDialScale(-10.0,120.0,225.0,-270.0,10.0,5));
		celsiusDial.addPointer(new DialPointer.Pointer());  
		celsiusDial.setBackground(new DialBackground());
		celsiusDial.addLayer(new DialValueIndicator(0));
		
		DialPlot farDial = new DialPlot(new DefaultValueDataset(86));
		farDial.setDialFrame(new StandardDialFrame());
		farDial.addScale(0,new StandardDialScale(-10.0,120.0,225.0,-270.0,10.0,5));
		farDial.addPointer(new DialPointer.Pin());  
		farDial.setBackground(new DialBackground());
		farDial.addLayer(new DialValueIndicator(0));
		
		JPanel cPanel = new JPanel();
		JPanel fPanel = new JPanel();
		cPanel.setLayout(new BoxLayout(cPanel,BoxLayout.Y_AXIS));
		fPanel.setLayout(new BoxLayout(fPanel,BoxLayout.Y_AXIS));
		
		ChartPanel cChartPanel = new ChartPanel(new JFreeChart("Celsius",celsiusDial));
		ChartPanel fChartPanel = new ChartPanel(new JFreeChart("Fahrenheit",farDial));
		cChartPanel.setPreferredSize(new Dimension(500,500));
		fChartPanel.setPreferredSize(new Dimension(500,500));
		cPanel.add(cChartPanel);
		fPanel.add(fChartPanel);
		
		JTextField cText= new JTextField("30.0",10);
		JTextField fText= new JTextField("86.0",10);
		JButton b1 = new JButton("Convertir a Fahrenheit");
		JButton b2 = new JButton("Convertir a Celsius");
		
		c.gridx=0;c.gridy=0;
		c.gridwidth=6;c.gridheight=6;
		f.add(cPanel,c);
		c.gridx=6;c.gridy=0;
		c.gridwidth=6;c.gridheight=6;
		f.add(fPanel,c);
		JPanel bPanel = new JPanel();
		bPanel.add(cText);
		bPanel.add(b1);
		bPanel.add(b2);
		bPanel.add(fText);
		c.gridx=0;c.gridy=6;
		c.gridwidth=12;c.gridheight=2;
		f.add(bPanel,c);
		
		class butAct implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				double tempCel;
				double tempFar;
				if(e.getSource()==b1){
					tempCel=Double.parseDouble(cText.getText());
					tempFar=(tempCel*9)/5+32;
				}
				else{
					tempFar=Double.parseDouble(fText.getText());
					tempCel=(tempFar-32)*5/9;
				}
				tempCel = (double)(Math.round(tempCel * 100.0) / 100.0);
				tempFar = (double)(Math.round(tempFar * 100.0) / 100.0);
				cText.setText(tempCel+"");
				fText.setText(tempFar+"");
				celsiusDial.setDataset(new DefaultValueDataset(tempCel));
				farDial.setDataset(new DefaultValueDataset(tempFar));
				
			}
		}
		b1.addActionListener(new butAct());
		b2.addActionListener(new butAct());
		f.pack();
		f.setVisible(true);
	}
}