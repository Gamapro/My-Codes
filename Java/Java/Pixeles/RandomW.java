import java.io.RandomAccessFile;
import java.util.*;

public class RandomW{

	public static void main(String args[]){
		RandomAccessFile f = new RandomAccessFile("prueba.dat","rw");
		
		f.seek(100);
		byte out = 5;
		for(int i = 0){
		f.write(out+i);	
		}

		f.close();
	}

}
