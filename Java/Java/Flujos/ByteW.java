import java.io.*;

public class ByteW{

	public static void main(String args[]) throws IOException {
		
		DataOutputStream out = new DataOutputStream( new FileOutputStream("x.bin") );
		out.writeInt(8);
		out.writeInt(15);
		out.writeFloat(14.30f);	
		out.writeDouble(111.0);
		out.close();
	}

}

