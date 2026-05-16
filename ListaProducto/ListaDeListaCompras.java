package ListaProducto;

import java.util.ArrayList;

import Producto.Productos;

public class ListaDeListaCompras {
	private ArrayList<ListaCompras> listaDeListas = new ArrayList();

	public void agregarLista(ListaCompras listaCompras) {
		listaDeListas.add(listaCompras);
	}


	public String toString() {
		String ret="";//deberia informar por si mismo o mandar el string para que informe el main?
		if(listaDeListas.isEmpty()) {
			ret= "La lista esta vacia";
		}
		else {
			for(ListaCompras l: listaDeListas) {
				ret+=l.toString();
			}	
		}
		return ret;	
	}

}
