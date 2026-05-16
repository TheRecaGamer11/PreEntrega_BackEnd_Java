package miMain;
import java.util.Scanner;
import ListaProducto.*;
import Producto.ProductoDeCompras;
import Producto.Productos;
public class Main {

	public static void main(String[] args) {
			Scanner sc= new Scanner(System.in);
			Lista sistema = new Lista();
			ListaCompras pedidos= new ListaCompras();
			ListaDeListaCompras todosLosPedidos=new ListaDeListaCompras();
			int opcion = 0;
			
			System.out.println("Bienvenido al sistema de gestion de productos.");
			while(opcion != 7 ) {
				System.out.println("Que desea hacer?");
				System.out.println("Toque 1 si desea agregar un producto");
				System.out.println("Toque 2 si desea listar los productos");
				System.out.println("Toque 3 si desea buscar un producto por id");
				System.out.println("Toque 4 si desea eliminar un producto");
				System.out.println("Toque 5 si desea crear un pedido ");//ni idea a que se refiere
				System.out.println("Toque 6 si desea listar los pedidos");
				System.out.println("toque 7 si desea salir");
				//compruebo si es un numero
				if(!sc.hasNextInt()) {
					System.out.println("Ingreso un caracter no valido, ingrese un numero");
					sc.next();
					continue;//quizas deberia hacer un boolean para que no imprima 2 veces el que desea hacer?
				}
				
				opcion=sc.nextInt();
				sc.nextLine();
				if(opcion>0 && opcion<=7) {//compruebo que hayan ingresado un numero valido
					//caso para cada uno
					switch(opcion) {
					case 1://para facilitarme voy a poner que si ingresa los datos mal tiene que volver a ingresar el numero
						if(caso1(sistema)) {
							System.out.println("Guardado con exito");
						}
						else{continue;}
						break;
					case 2:
						caso2(sistema);break;
					case 3:
						caso3(sistema);break;
					case 4:
						caso4(sistema);break;
						
					case 5:
						caso5(sistema,pedidos,todosLosPedidos);break;
					case 6:
						caso6(pedidos,todosLosPedidos);
						break;
					case 7:
						System.out.println("Programa finalizado");
						break;
					}
				}
				else {
					System.out.println("El numero ingresado no era valido");
				}
			}

		}
	
	private static boolean caso1(Lista sistema) {
		boolean ret= false;
		Scanner sc= new Scanner(System.in);//para facilitar, si ingreso mal los datos, tendra que ingresar todo de nuevo
		System.out.println("Ingrese el nombre ");
		String nombre= sc.nextLine();//para la entrega final, cambiar esto por value object asi no hago las comparaciones aca
		if(!nombre.isBlank()){
			System.out.println("Ingrese el monto");
			double monto= sc.nextDouble();
			if (monto>0) {
				System.out.println("Ingrese el stock");
				int stock = sc.nextInt(); 
				if(stock>0) {
					Productos agregar= new Productos(nombre, monto, stock);
					sistema.agregarALista(agregar);
					ret=true;
				}
				else {System.out.println("El stock debe ser mayor a 0");}	
			}
			else {System.out.println("El monto debe ser mayor a 0");}
		}
		else {System.out.println("El nombre estaba vacio, ingrese un nombre valido");}
		return ret;
	}
	
	private static void caso2(Lista sistema) {
		System.out.println(sistema.listar());
	}

	private static void caso3(Lista sistema) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Si desea buscar un producto ingrese 1, si desea actualizarlo ingrese 2");
		if(sc.hasNextInt()) {
			int unoODos=sc.nextInt();
			Productos a;
			if(unoODos==1) {
				int produBuscado=sc.nextInt();//todo esto deberia comprobarlo, calculo que cambiandolo luego a valueObject no tendria que hacer tanto
				a=sistema.buscarProductoId(produBuscado);
				if(a==null) {
					System.out.println("El producto no existe");
				}else {System.out.println(a.toString());}
		}else {if(unoODos==2) {
			int produBuscado=sc.nextInt();//esto tambien deberia chequearlo
			a=sistema.buscarProductoId(produBuscado);
			System.out.println("Ingrese el monto");
			if(a==null) {
				System.out.println("El producto no existe");
			}else {
				System.out.println("Ingrese el nombre actual");
				String nombre= sc.nextLine();//Esto tambien deberia ser value object
				if(!nombre.isBlank()){
					System.out.println("Ingrese el monto actual");
					double monto= sc.nextDouble();
					if (monto>0) {
						System.out.println("Ingrese el stock actual");
						int stock = sc.nextInt(); 
						if(stock>0) {
							sistema.buscarProductoId(a.getId()).setNombre(nombre);
							sistema.buscarProductoId(a.getId()).setPrecio(monto);
							sistema.buscarProductoId(a.getId()).setStock(stock);
						}
						else {System.out.println("El stock debe ser mayor a 0");}	
					}
					else {System.out.println("El monto debe ser mayor a 0");}
				}
				else {System.out.println("El nombre estaba vacio, ingrese un nombre valido");}
				}
			}
		}
			}
		else System.out.println("Ingrese un numero");
		}

	private static boolean caso4(Lista sistema) {
		boolean ret=false;
		Scanner sc= new Scanner(System.in);
		System.out.println("Ingrese el id del producto que desea eliminar");
		if (!sc.hasNextInt()) {
            System.out.println("Ingresá un ID válido.");
            sc.next();
		}else {
		int id= sc.nextInt();
		sc.nextLine();
		if(sistema.eliminarProducto(id)) {
			return true;
		}
		}
		return ret;
		}
	
	private static void caso5(Lista sistema,ListaCompras pedidos,ListaDeListaCompras todosLosPedidos) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Ingrese el id buscado o -1 si desea terminar la compra");
		int id= sc.nextInt();
		while(id != -1) {
			if (id>-1) {
				Productos produ=sistema.buscarProductoId(id);
				if(produ != null)
					System.out.println("Ingrese la cantidad requerida");
					int cantidadRequerida = sc.nextInt(); 
					if(cantidadRequerida>0) {
						if(produ.getStock()>=cantidadRequerida) {
							ProductoDeCompras agregar =new ProductoDeCompras(id , produ.getNombre() , cantidadRequerida , produ.getPrecio());
							pedidos.agregarAPedido(agregar);
						}
						else {System.out.println("El stock debe ser mayor a 0");}	
					}
					else {System.out.println("El monto debe ser mayor a 0");}
			}
			else {System.out.println("El nombre estaba vacio, ingrese un nombre valido");}
			System.out.println("Ingrese el id buscado o -1 si desea terminar la compra");
			id= sc.nextInt();
		}
		todosLosPedidos.agregarLista(pedidos);
	}
	private static void caso6(ListaCompras pedidos, ListaDeListaCompras todosLosPedidos) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Ingrese 1 si desea que listemos la ultima lista de productos o 2 si desea listar todas7");
		if (!sc.hasNextInt()){
			int cual= sc.nextInt();
			if(cual==1) {
				System.out.println(pedidos.toString());//creo quelo hice mal
			}
			else {if(cual==2) {
				System.out.println(todosLosPedidos.toString());//este tambien
			}else {System.out.println("Ingreso un numero invalido");}
			}
		}
	}
}

	


	
