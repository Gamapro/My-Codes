//Ejemplo de File y FilenameFilter

import java.io.*;

public class TFile
{
	public static void main(String args[])
	{
		if(args.length<1)
		{
			System.out.printf("Introduzca como argumento el nombre del archivo.\n");
			return;
		}
			
		File f = new File(args[0]);
		
		
		FilenameFilter filtro = new FilenameFilter()
		{
			@Override
			public boolean accept(File dir, String name)
			{
				if(args.length<2) return true;
				return name.contains(args[1]);
			}
			
		};
		
		System.out.printf("�Existe %s? %s\n",args[0], f.exists()?"S�":"No");
		System.out.printf("�Es archivo o carpeta? %s\n", f.isFile()?"Archivo":"Carpeta");
		System.out.printf("Longitud: %d\n\n",f.length());
		
		if(f.isDirectory())
		{
			System.out.printf("Contenido filtrado:\n");
			String arr[] = f.list(filtro);
			
			for(String x:arr)
				System.out.println("   "+x);
		}
	}
}

	
