
public class Registro{

	private String autor;
	private String titulo;
	private String texto;
	
	Registro(){
		this.autor = "Desconocido";
		this.titulo = "Desconocido";
		this.texto = "Desconocido";
	}

	Registro(String autor, String titulo, String texto){
		this.autor = autor;
		this.titulo = titulo;
		this.texto = texto;
	}

	Registro(String s){
		// Aqui va lo chido :'v
		this.autor = "Desconocido";
		this.titulo = "Desconocido";
		this.texto = "Desconocido";
	
		String uno[] = s.split("<autor>");
		s="";
		for(String cala : uno){
			if(cala.contains("</autor>")){
				String aux[] = cala.split("</autor>");
				autor = aux[0];
				for(int j=1;j<aux.length;j++)s+=aux[j];
			}else{
				s+=cala;	
			}
		}
		
		String dos[] = s.split("<titulo>");
		s="";
		for(String cala : dos){
			if(cala.contains("</titulo>")){
				String aux[] = cala.split("</titulo>");
				titulo = aux[0];
				for(int j=1;j<aux.length;j++)s+=aux[j];
			}else{
				s+=cala;
			}
		}
		
		String tres[] = s.split("<texto>");
		String aux = tres[1];
		String cuatro[] = aux.split("</texto>");
		texto = cuatro[0];

	}

	public String getAutor(){
		return this.autor;
	}

	public String getTitle(){
		return this.titulo;
	}

	public String getText(){
		return this.texto;
	}

	public String toString(){
		return "Autor: "+this.autor+"\nTitulo: "+this.titulo+"\nTexto: "+this.texto+"\n";
	}
	
}
