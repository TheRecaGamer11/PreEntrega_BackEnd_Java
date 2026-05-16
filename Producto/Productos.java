package Producto;

public class Productos { 
	//declaro constantes
	public static int identificador=1;
	 
	//declaro variables
	private String nombre;
	private double precio;
	private int stock,id;
	//Constructor
	public Productos(String nombre, double precio, int stock) {
		this.nombre= nombre;
		this.precio=precio;
		this.stock=stock;
		this.id=identificador;
		identificador++;
	}
	
	//getters
	public String getNombre() {
		return this.nombre;
	}
	public double getPrecio() {
		return this.precio;
	}
	public int getStock() {
		return this.stock;
	}
	public int getId() {
		return this.id;
	}
	
	//seters, por si el dia de mañana cambian el nombre, el precio o el stock
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public void setPrecio(double precio) {		this.precio=precio;
	}
	public void setStock(int stock) {
		this.stock=stock;
	}
	
	//toString
	public String toString() {
		return "[El producto: "+this.nombre+"vale "+this.precio+"Y hay "+this.stock+"stock disponible .Su identificador es "+this.id+" ]/n";
	}
}
