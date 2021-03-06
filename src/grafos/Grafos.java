package grafos;

import grafos.Vertice;
import grafos.Arista;
import java.awt.List;
import java.util.*; //nos sire para usar la clase Vector
public class Grafos {
	public Vector lista_vert; 	// es el numero de vertices que presenta el grafo
	public int numAristas = 0;  	// es el numero de aristas que presenta el grafo
	
	
	//constructor inicial que llama al metodo initial()
	public Grafos() { 
		init();
	}
	
	//el metodo init() convierte a la variable lista_vert
	//en un objeto de la clase vetor que usamos del paquete java.util.*;
	public void init() {
		lista_vert = new Vector();
	}
	
	/*
	  metodo que clona un grafo
	  los primero que hace es crear un objeto de la misma clase
	  luego renombra los datos de las variables
	  su numero de vertices y el numero de aristas
	  y retorna un nuevo grafo que es clonado 
	*/
	public Grafos clonar() { 
		Grafos g = new Grafos();
		g.lista_vert = (Vector)lista_vert.clone();
		g.numAristas = numAristas;
		return g;
	}
	
	
	//retorna la cantidad de aristas en el grafo
	public int cantVertices() {
		return lista_vert.size();
	}
	
	/* 	metodo de tipo arista que tiene la funcoin de siesq 
		la cantidad de vertices aun es mayor q la variable desde
		y siesq la variable hasta tambien es menor q la cantidad de vertices
		entonces llamanos a los emtods para que se guarde los dato
		y retornamos el objeto arista 
	*/
	public Arista arista(int desde, int hasta) {
		Arista a = null;
		Vertice v;
		int cantVert = cantVertices();
		
		if(desde < cantVert && hasta < cantVert) {
			v = vertice(desde);
			a = v.adyacente(hasta);
		}
		return a;
	}
	
	
	
	// este metodo nos retorna los elemtosAt casteado a un objeto de tipo vertice
	public Vertice vertice(int k) {
		return (Vertice)lista_vert.elementAt(k);
	}
	
	
	
	//el costo es lo que nos costaria ir desde una arista hasta otra arista
	public int costo(int desde, int hasta) {
		Arista a = arista(desde, hasta);
		int r = 0;
		
		if( a != null ) {
			r = a.costo;
		}
		
		return r;
	}
	
	
	/*metodo que une dos aristas
		como primer parametros recibe un desde que es la arista de inicio
		como segundo parametro recibe una arista de destino 
		como tercer paremetro recibe el costo que hay de ir desde
		el primer parametro hasta el segundo parametro 
	*/
	public int unirAristas(int desde, int hasta, int costo) {
		Arista newArista = new Arista(desde, hasta, costo);
		unirAristas(desde, hasta, newArista);
		return ++numAristas;
	}
	
	
	/*metodo que une dos aristas
		como primer parametros recibe un desde que es la de inicio
		como segundo parametro recibe una arista de destino 
		como tercer paremetro recibe un valor de tipo Arista que es la arista que se tendra que conectar
	 */
	public void unirAristas(int desde, int hasta, Arista a) {
		if( desde >= cantVertices() ) {
			lista_vert.setSize(desde+1);
		}
		
		if( hasta >= cantVertices() ) {
			lista_vert.setSize(hasta+1);
		}
		
		if( vertice(desde) == null ) {
			lista_vert.set(desde, new Vertice(null));
		}
		
		if( vertice(hasta) == null ) {
			lista_vert.set(hasta, new Vertice(null));
		}
		
		vertice(desde).unirAristas(a);
	}
	
	
	public void separarAristas(int desde, int hasta) {
		if(cantVertices() > desde) {
			vertice(desde).separarAristas(hasta);
		}
	}
	
	
	
	public int agregarVertice(String id) {
		Vertice newVertice = new Vertice(id);
		lista_vert.add(newVertice);
		
		return cantVertices()-1;
	}
	
	public void agregarVertice(String id, int pos) {
		if(pos >= cantVertices() ) {
			lista_vert.setSize(pos+1);
		}
		
		Vertice newVertice = new Vertice(id);
		lista_vert.set(pos, newVertice);
	}
	
	
	
	
	
	
	
}	
