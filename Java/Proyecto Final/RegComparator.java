
import java.util.*;

public class RegComparator implements Comparator<Registro>{

	public int compare(Registro r1, Registro r2){

		if(r1.getAutor().compareTo(r2.getAutor())>0){
			return 1;
		}else if(r1.getAutor().compareTo(r2.getAutor())<0){
			return -1;
		}else{ // IGUALES :v
			if(r1.getTitle().compareTo(r2.getTitle())>0){
				return 1;
			}else if(r1.getTitle().compareTo(r2.getTitle())<0){
				return -1;
			}else return 0;
		}
	}

}
