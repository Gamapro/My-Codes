import java.io.*;

public class dataInputStream{

	public static void main(String args[]) throws IOException {
		
		DataInputStream in = new DataInputStream( new FileInputStream("x.bin") );
		
		System.out.printf("%d %d %f",in.readInt(),in.readInt(),in.readFloat()); //,in.readDouble());
		
		in.close();
	}

}


