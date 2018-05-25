package co.com.poli.AppInventario.Data;

import java.util.ArrayList;
import java.util.List;

import co.com.poli.AppInventario.Model.Producto;

public class DataProducto {

	private static List<Producto> list;
	
	static {
		list = new ArrayList<Producto>() {
			
			private static final long serialVersionUID = 1L;

			{
				add(new Producto("10", "Agua", 15D));
				add(new Producto("11", "Mango", 12D));
				add(new Producto("12", "Pera", 25D));
			}
		};
	}
	
	public static List<Producto> getProductos() {
		return list;
	}
	
	public static void setProductos(List<Producto> newList) {
		list = newList;
	}
}
