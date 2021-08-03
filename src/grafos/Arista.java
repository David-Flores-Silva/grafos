package grafos;

public class Arista {
	public int costo=0;
	public int desde;
	public int hasta;
	
	public Arista(int desde, int hasta, int costo) {
		this.desde = desde;
		this.hasta = hasta;
		this.costo = costo;
	}
	
	public String toString() {
		return "costo = "+costo;
	}
	
	
	
}
