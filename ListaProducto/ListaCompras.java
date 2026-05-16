package ListaProducto;

import java.util.ArrayList; //Deberia usar un producto diferente que tiene producto y cantidad deseada, que es una clase intermedia que ayuda a desacoplar

import Producto.ProductoDeCompras;
import Producto.Productos;

public class ListaCompras {
	private ArrayList<ProductoDeCompras> lista= new ArrayList<>();
	
	public void agregarAPedido(ProductoDeCompras produ) {
		lista.add(produ);
	}
	
	public String toString() {
		String ret="";//deberia informar por si mismo o mandar el string para que informe el main?
		if(lista.isEmpty()) {
			ret= "La lista esta vacia";
		}
		else {
			for(ProductoDeCompras p: lista) {
				ret+=p.toString();
			}	
		}
		return ret;	
	}

}