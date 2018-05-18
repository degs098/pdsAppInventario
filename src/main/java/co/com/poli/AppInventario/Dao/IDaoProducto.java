package co.com.poli.AppInventario.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.poli.AppInventario.Model.Producto;

@Repository
public interface IDaoProducto {
	
	public List<Producto> getProductos();
	public Producto getProductoById(String id);

}
