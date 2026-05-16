package ListaProducto;
import java.util.*;
import Producto.Productos;
public class Lista {
	private ArrayList<Productos> listaProductos= new ArrayList<>();
	
	//listo todos los elementos
	public String listar() {
		String ret="";//deberia informar por si mismo o mandar el string para que informe el main?
		if(listaProductos.isEmpty()) {
			ret= "La lista esta vacia";
		}
		else {
			for(Productos p: listaProductos) {
				ret+=p.toString();
			}	
		}
		return ret;	
	}
	
	//agrega
	public void agregarALista(Productos producto) {
		this.listaProductos.add(producto);
	}
	
	//Busco producto para poder eliminarlo
	public Productos buscarProductoId(int id) { //deberia hacerlo generico para que permita int y string o combiene sobreeescribir?
		Productos produ= null;
		int i=0;
		boolean encontre=false;
		while((listaProductos.size()>i)&&(!encontre)) {
			if(listaProductos.get(i).getId()==id) {
				encontre=true;
				produ=listaProductos.get(i);
			}
			i++;
		}
		return produ;
	}
	
	
	//elimino un objeto de la lista si lo encontre
	public boolean eliminarProducto(int id){//tengo que pensar como hacerlo unico
		Productos eliminar = buscarProductoId(id);
		if(eliminar.getId()>-1) {
			listaProductos.remove(eliminar);
			return true;
		}else return false;
	}
}
