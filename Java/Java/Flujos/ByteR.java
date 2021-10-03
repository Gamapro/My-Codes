import java.io.*;

public class ByteR{

	public static void main(String args[]) throws IOException {
		FileOutputStream out = new FileOutputStream("x.bin");

		out.write((byte)128);
		out.write(255);
		out.write(100);
		out.close();
	}

}
