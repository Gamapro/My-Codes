import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Scanner;

public class Set
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String st = "";
		HashSet<String> a = new HashSet<>();
		LinkedHashSet<String> b = new LinkedHashSet<>();
		TreeSet<String> c = new TreeSet<>();

		System.out.printf("\nIntroduzca las cadenas que" +
						  "\ndesee almacenar. Termine con \"FIN\"\n");

		while(st.compareTo("FIN")!=0)
		{
			st = in.nextLine();
			a.add(st);
			b.add(st);
			c.add(st);
		}

		a.remove("FIN");
		b.remove("FIN");
		c.remove("FIN");
		
		System.out.printf("\nElementos HashSet:\n");

		for(Object x:a.toArray())
			System.out.println("\t"+x);	

		System.out.printf("\nElementos LinkedHashSet:\n");

		for(Object x:b)
			System.out.println("\t"+x);	


		System.out.printf("\nElementos TreeSet:\n");
		
		for(Object x:c)
			System.out.println("\t"+x);
		


	}

}
