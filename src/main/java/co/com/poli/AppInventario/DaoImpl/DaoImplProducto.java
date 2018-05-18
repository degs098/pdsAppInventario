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

}
