import java.util.TreeSet;

public class TstTS
{
	public static void main(String args[])
	{
		String []arr = {"estupendo","mermelada","coliflor","sapo","poder","hastiado","percatarse"};

		TreeSet<String> set = new TreeSet<>();

		for(String u:arr)
		{
			System.out.printf("\n %s",u);
			set.add(u);
		}
		System.out.printf("\n------------");	

		for(Object x:set)
			System.out.printf("\n %s",x);
		
		System.out.printf("\n------------\n First:\t\t\t%s",set.first());
		System.out.printf("\n Last: \t\t\t%s",set.last());
		System.out.printf("\n Despues de \"parte\":\t%s",set.ceiling("parte"));
		System.out.printf("\n Antes de \"higo\":\t%s\n",set.floor("higo"));
		
	}
}
