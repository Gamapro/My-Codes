import java.io.*;
import java.util.*;

public class ReadWriteRGB{

	public static void main(String args[]) throws IOException,EOFException {
		
		Scanner sc = new Scanner(System.in);
		if(args.length==0){ System.out.println("Introduzca el nombre del archivo."); return;}	
		
		RandomAccessFile in = new RandomAccessFile(args[0],"rw");
		RandomAccessFile out = new RandomAccessFile(getName(args[0])+".bmp","rw");
		
		int n = (int)Math.sqrt(in.length()/3);
		System.out.println(n);
		
		out.seek(0);
		out.writeShort(0x424d);
			
		out.seek(2);
		out.writeInt(conv((n*n*3)+54*3));
	
		out.writeInt(0x00000000);

		out.seek(10);
		out.writeInt(0x36000000);
		out.writeInt(0x28000000);

		out.seek(18);
		out.writeInt(conv(n));
		out.writeInt(conv(n));
			
		out.writeShort(0x0100);
		out.writeShort(0x1800);
		
		out.seek(34);
		out.writeInt(conv(n*n*3 + 54));

		out.seek(54); in.seek(0);	
		for(int i=0;i<(n*n*3);i++){
			out.write(in.read());
		}
	
		in.close();
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

