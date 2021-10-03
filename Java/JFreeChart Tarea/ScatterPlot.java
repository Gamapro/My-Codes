import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.RenderingHints;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.FastScatterPlot;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.renderer.*;

public class ScatterPlot{
	
	public static float func(float x){
		float err = 0;
		int alt = (int) Math.random()*1000;
	    err = (float)Math.random()*(float)(0.1);
		//err = (float)Math.random()*alt;
		float rand = (float)Math.random();
		int sign = rand <= (float).3 ? 1 : rand>=.6 ? -1 : 0;
		//return x +sign*err;  // LINEA RECTA
		//return x*x + sign*err; // PARABOLA
		return (float) Math.cos(x)/(10) +sign*err;
		//return (float)Math.sqrt(x) + sign*err;  // RAIZ
		//return (float)Math.random() * 100  + sign*err;
	}

	public static float[][] generar_datos(float[][] data){
		// GENERAR X's y Y's
		for(int i=0;i<data[0].length;i++){
			data[0][i] = (float)Math.random() * 50;
			data[1][i] = func(data[0][i]);
		}
		return data;
	}
	
	public static void main(String args[]){
		JFrame v = new JFrame("Arcos Bravo David Gamaliel");
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		int N = 50000;
		float [][] data = new float[2][N];
		generar_datos(data);

		NumberAxis X = new NumberAxis("X-AXIS");
        X.setAutoRangeIncludesZero(true);
        NumberAxis Y = new NumberAxis("Y-AXIS");
        Y.setAutoRangeIncludesZero(true);

		FastScatterPlot plt = new FastScatterPlot(data,X,Y);
		JFreeChart c = new JFreeChart("DATOS",plt);
		
		plt.setPaint(Color.BLUE);	
		//plt.setData(data);
		plt.zoom(.5);
		//plt.setBackgroundPaint(new Color(255,255,255));
		//plt.setDomainGridlinesVisible(false);
		//plt.setRangeGridlinesVisible(false);
		c.getRenderingHints().put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		ChartPanel charto = new ChartPanel(c);
		charto.setPreferredSize(new java.awt.Dimension(1000,800));
		charto.setMinimumDrawHeight(10);
        charto.setMaximumDrawHeight(2000);
        charto.setMinimumDrawWidth(20);
        charto.setMaximumDrawWidth(2000);

		v.add(charto);
		v.setBounds(200,400,15,15);
		v.setLocationRelativeTo(null);
		v.pack();
		v.setVisible(true);

	}	
}
