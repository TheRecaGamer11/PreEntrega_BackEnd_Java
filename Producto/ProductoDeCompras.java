package Producto;

public class ProductoDeCompras{
	private int id;
	private String nombre;
	private int cantidadComprada;
	private double cuantoGaste;

	public ProductoDeCompras(int id, String nombre, int cantComprada,double precio) {
		this.id= 0;
		this.nombre="";
		this.cantidadComprada=0;
		this.cuantoGaste=this.cantidadComprada*precio;
	}
	public String toString() {
		return "[se compraron "+this.cantidadComprada+"de el producto con nombre "+this.nombre+"e id: "+this.id+"y con monto"+this.cuantoGaste;
	}
}

