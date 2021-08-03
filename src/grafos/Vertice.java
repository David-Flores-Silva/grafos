package grafos;

import java.util.*;

public class Vertice {
	public String id;
	public ArrayList<Arista>  lista_ady;
	public boolean visitado;
	
	
	public Vertice(String id) {
		nombrar(id);
		lista_ady= new ArrayList<>();
		visitado = false;
	}
	
	public void unirAristas ( Arista a ) {
        ListIterator Litr = lista_ady.listIterator(0);
        int pos = 0;
				
        while (Litr.hasNext()) {
            Arista ari = (Arista) Litr.next();
			
            if (a.hasta < ari.hasta) {
                break;
            }		  
            pos++;			
        }
		
        lista_ady.add(pos,a);
    }
	
	public void separarAristas ( int to) {
	    ListIterator Litr = lista_ady.listIterator(0);
		
        while (Litr.hasNext()) {
            Arista a = (Arista) Litr.next();
			
            if (a.hasta == to) {
                Litr.remove();
                break;
            }		    
        }
    }
	
	public Arista adyacente(int to) {
        ListIterator AdyItr =  lista_ady.listIterator(0);
        Arista a=null;
			
        while ( AdyItr.hasNext() ) {
            a = (Arista) AdyItr.next();
            if (a.hasta == to){
                return a;
            }
        }		
	
	    return null;
    }

    public void nombrar (String id) { 
        this.id = id; 
	}
}
