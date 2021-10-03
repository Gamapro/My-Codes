import java.io.*;
import java.util.*;

public class Ejercicio13{

	public static void main(String args[]) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		String s;
		if(args.length > 0) s = args[0];
		else s = sc.nextLine();

		FileInputStream in = new FileInputStream(s);
		FileOutputStream out = new FileOutputStream("Salida."+getExt(s));
		
		for(int i=0;i<=54;i++){
			out.write(in.read());
		}

		ArrayList<Byte> arr = new ArrayList<Byte>();
		
		while(in.available()>0){
			arr.add((byte)in.read());
		}
		
		for(int i=arr.size()-1;i>=0;i--){
			out.write(arr.get(i));
		}
		
		in.close();
		out.close();
	}

	public static String getExt(String s){
		String[] arr = s.split("[.]");
		return arr[arr.length-1];
	}

}


