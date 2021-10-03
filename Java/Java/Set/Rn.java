import java.util.Random;
import java.util.HashSet;

public class Rn
{
	public static void main(String a[])
	{
		HashSet<Integer> s = new HashSet<Integer>();
		Random rnd = new Random();

		while(s.size()<50)
		{	
			s.add( rnd.nextInt(90)+10 );		
		}

		System.out.println();
			
		for(Object x:s)
		{
			System.out.printf("%d\t",x);
		}

	}
}
