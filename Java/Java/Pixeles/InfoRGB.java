import java.io.*;
import java.util.*;

public class InfoRGB{

	public static void main(String args[]) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		if(args.length==0){ System.out.println("Introduzca el nombre del archivo."); return;}	
		//FileInputStream in = new FileInputStream(args[0]);
		//FileOutputStream out = new FileOutputStream(getName(args[0])+".bmp");
		RandomAccessFile in = new RandomAccessFile(args[0],"r");
		RandomAccessFile out = new RandomAccessFile(getName(args[0])+".bmp","rw");
		
		int n = (int)Math.sqrt(in.length()/3);
		System.out.println(n);
		
		out.setLength( n*n + 54);
		
		out.seek(0);
		out.writeBytes(new String("42 4D 76 32"));
	
		out.seek(2);
		out.writeInt(n*n);

		out.seek(10);
		out.writeInt(36);

		// Anchura y altura
		out.seek(18);
		out.writeInt(n);
		out.writeInt(n);

		out.seek(28);




		out.seek(54);	
		for(int i=0;i<n*n;i++){
			out.write(in.read());
		}
		
		in.close();
		out.close();

	}
	
	public static String getName(String s){
		String arr[] = s.split("[.]");
		return arr[0];
	}

}

