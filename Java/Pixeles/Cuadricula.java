import java.io.*;
import java.util.*;

public class Cuadricula{

	public static void main(String args[]) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		if(args.length==0){ System.out.println("Introduzca el nombre del archivo."); return;}	
		
		RandomAccessFile out = new RandomAccessFile("Salida.bmp","rw");
		

		int n = Integer.parseInt(args[0]);
		System.out.println(n);
		
		out.seek(0);
		out.writeShort(0x424d);
			
		out.seek(2);
		out.writeInt(conv(n*n*3 + 54));
	
		out.writeInt(0);

		out.seek(10);
		out.writeInt(0x36000000);
		out.writeInt(0x28000000);

		out.seek(18);
		out.writeInt(conv(n));
		out.writeInt(conv(n));
			
		out.writeShort(0x0100);
		out.writeShort(0x1800);
		//out.writeInt(0);
		
		out.seek(34);
		out.writeInt(conv(n*n*3));

		out.seek(54);	
		for(int i=0;i<n;i++){
			for(int k=0;k<n;k++){
				//byte b = (byte)(((k%2)+i%2)==0?0xff:0X00);
				byte b = (byte)0xff;
				if((i+k)%2==1) b = 0x00;
				for(int j=0;j<3;j++)out.writeByte(b);
			}
		}
		out.close();

	}
	
	public static String getName(String s){
		String arr[] = s.split("[.]");
		return arr[0];
	}


	public static int conv(int i)
	{
	    return((i&0xff)<<24)+((i&0xff00)<<8)+((i&0xff0000)>>8)+((i>>24)&0xff);
	}	

	public static int conv2(int i)
	{
	    return((i&0xff)<<8)+((i>>8)&0xff);
	}

}


