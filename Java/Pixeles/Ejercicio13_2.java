import java.io.*;
import java.util.*;
import java.text.*;

public class Ejercicio13_2{

	public static void main(String args[]) throws IOException {
		
		DataOutputStream out = new DataOutputStream(new FileOutputStream("Fecha.bin"));
			
		SimpleDateFormat form = new SimpleDateFormat("dd MM yyyy");
		Calendar cal = new GregorianCalendar();
		System.out.println(form.format(cal.getTime()));
		String s = form.format(cal.getTime());
		String arr[] = s.split(" ");
	   	for(String num : arr){
			out.writeInt(Integer.parseInt(num));	
		}	

		out.close();
	}

}


