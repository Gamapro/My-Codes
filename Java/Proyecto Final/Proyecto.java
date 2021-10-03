import java.io.*;
import java.util.*;

public class Proyecto{

	static File f;
	static FileReader in;
	static FileWriter out;
	static ArrayList<Registro> reg = new ArrayList<Registro>(), rec = new ArrayList<Registro>();
	static RegComparator compa = new RegComparator();
	static HashMap<String,ArrayList<Registro> > map = new HashMap<String,ArrayList<Registro> >();
	static TreeSet<String> set = new TreeSet<>();
	static int ind,ind2;

	public static void main(String args[]){
		try{
			try{
				f = new File(args[0]);
				in = new FileReader(f);
			}catch(Exception ex){
				System.out.println("Por favor, introduzca el nombre del archivo.");
				return;
			}
			out = new FileWriter("Salida.htm");
			out.write("<html style=\"background-color:aquamarine;\">\n<body>\n<a name=\"ini\">\n");
			out.write("</br></br>\n\n");

			// Leer y parsear los datos
			readF(in,out,f);

			// Ordenarlos con el RegComparator
			reg.sort(compa);	
			
			// Separar autores y obras
			for(String nom : set){
				map.put(nom,new ArrayList<Registro>());
			}
			for(Registro r : reg){
				rec = map.get(r.getAutor()); 
				rec.add(r);
				map.put(r.getAutor(), rec);
			}

			// INDICE DE AUTORES
			
			out.write("<center><h2>Índice de autores</h2></center>\n");
			ind = 0;
			for(String nom : set){
				out.write("<center><p style=\"margin-left: 0px\"><a href = #a"+(ind++)+">"+nom+"</a></p></center>\n");
			}
			out.write("<br><br><hr style=\"height:1px;border-width:0;color:black;background-color:black\"><br><br>\n\n");

			// INDICE DE AUTORES
			
			out.write("<center><h2>Índice de obras</h2></center>\n");
			ind = ind2 = 0;
			for(String nom : set){
				out.write("<center><p style=\"margin-left: 0px\"><a name=\"a"+(ind++)+"\"><b>"+nom+"</b></a></p></center>\n");
				rec = map.get(nom);
				for(int i=0;i<rec.size();i++){
					out.write("<center><p style=\"margin-left: 0px\"><a href = #o"+(ind2++)+">"+rec.get(i).getTitle()+"</a></p></center>\n");
				}
			}
			out.write("<br><br><hr style=\"height:1px;border-width:0;color:black;background-color:black\"><br><br>\n\n");

			// OBRAS
			ind=0;
			for(String nom : set){
				rec = map.get(nom);
				for(Registro r : rec){
					out.write("<center><a name=\"o"+(ind++)+"\"><h3>"+r.getTitle()+"</h3></a></center>\n");
					out.write("<center><h5>"+r.getAutor()+"</h5></center>\n");
					
					out.write("<big><p>"+r.getText()+"</p></big>\n");

					out.write("<center><a href=#ini>[inicio]</a></center>\n");
					out.write("<br><br><hr style=\"height:1px;border-width:0;color:black;background-color:black\"><br><br>\n\n");
				}
			}

			out.write("\n</body>\n</html>");
			
			out.close();
			in.close();
		
		}catch(IOException ex){
			System.out.print("No fue posible crear el archivo HTML.\n" + ex.getClass()+": "+ex.getMessage());
		}
	}

	public static void readF(FileReader in,FileWriter out,File f) throws IOException{ 
		int len = (int)f.length();
		char arr[] = new char[len];
		in.read(arr,0,len);
		String lect = new String(arr);
		String coso[] = lect.split("<registro>");
		for(int i=1;i<coso.length;i++){
			coso[i] = fuchi(coso[i]);
			Registro r = new Registro(coso[i]);
			reg.add(r);
			set.add(r.getAutor());
		}
		return;
	}

	public static String fuchi(String hola){
		String helpme[] = hola.split("</registro>");
		return helpme[0];
	}

}

