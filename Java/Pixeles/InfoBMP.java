//Obtiene información de un archivo .bmp leyendo el encabezado

import java.io.RandomAccessFile;

public class InfoBMP
{
	public static void main(String args[])
	{
		if(args.length==0)
		{
			System.out.printf("\nPor favor, indique el nombre del archivo como argumento.\n");
			return;
		}
		try
		{
			RandomAccessFile raf = new RandomAccessFile(args[0],"r");
			if(raf.readShort()!=0x424d)
			{	
				System.out.printf("\n El archivo especificado no es del tipo .BMP");
				return;
			}
			
			System.out.printf("\nNombre del archivo: %s\n",args[0]);
			System.out.printf("Tamaño del archivo: %d bytes\n",conv(raf.readInt()));
			raf.seek(18);
			System.out.printf("Ancho de la imagen: %d pixeles\n",conv(raf.readInt()));
			System.out.printf("Alto de la imagen: %d pixeles\n",conv(raf.readInt()));
			raf.seek(28);
			System.out.printf("Color de %d bits\n",conv2(raf.readShort()));
			
		}
		catch(Exception e)
		{
				System.out.printf("\nError %s\n",e);
		}
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
