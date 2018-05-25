package co.com.poli.AppInventario.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.poli.AppInventario.Dao.IDaoProducto;
import co.com.poli.AppInventario.Data.DataProducto;
import co.com.poli.AppInventario.Model.Producto;

@Repository
public class DaoImplProducto implements IDaoProducto{

	@Override
	public List<Producto> getProductos() {
		List<Producto> lista = new ArrayList<Producto>();
		try {
			lista = DataProducto.getProductos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Producto getProductoById(String id) {
		List<Producto> lista = getProductos();
		Producto producto = new Producto();
		for(Producto p : lista) {
			if(p.getCodigo().equals(id)) {
				producto = p;
				break;
			}
		}
		return producto;		
	}

	@Override
	public String saveProducto(Producto producto) {
		List<Producto> lista = DataProducto.getProductos();
		try {
			lista.add(producto);
			DataProducto.setProductos(lista);
			return "Producto agregado";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error al agregar el producto";
		}		
	}
	
	@Override
	public String updateProducto(Producto producto) {
		List<Producto> lista = DataProducto.getProductos();
		Producto productExist = getProductoById(producto.getCodigo());
		if(productExist != null) {
			try {
				Integer index = lista.indexOf(productExist);
				lista.set(index, producto);
				DataProducto.setProductos(lista);
				return "Producto actualizado";
			} catch (Exception e) {
				e.printStackTrace();
				return "Error al actualizar el producto";
			}				
		}else {
			return "No existe el producto";
		}
		
	}

}
