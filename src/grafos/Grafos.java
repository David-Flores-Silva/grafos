package grafos;

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
	 * metodo que clona un grafo
	 * los primero que hace es crear un objeto de la misma clase
	 * luego renombra los datos de las variables
	 * su numero de vertices y el numero de aristas
	 * y retorna un nuevo grafo que es clonado 
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
	
	
	//
	
	
}	
