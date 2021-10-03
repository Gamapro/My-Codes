//Ejemplo de lectura en archivos

import java.io.*;

public class FileR
{
	public static void main(String args[])
	{
		try
		{
			
			FileReader in = new FileReader("Texto.txt");
			
			int x = 13;
			while(x!=-1)
			{
				System.out.printf("%c",x);
				x = in.read();
			}
			
			
			/*
			File f = new File("Texto.txt");
			FileReader in = new FileReader(f);
			
			char arr[] = new char[(int) f.length()];
			in.read(arr,0,arr.length);
			System.out.printf("%s",new String(arr));
			*/

			in.close();
		}
		catch(IOException e)
		{
			System.out.println("No fue posible realizar la operaci�n");
		}
	}
	
}
		
