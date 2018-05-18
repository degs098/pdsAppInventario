package co.com.poli.AppInventario.Business;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.poli.AppInventario.Model.Producto;

@Service
public interface IBusinessProducto {
	public List<Producto> getProductos();
	public Producto getProductoById(String id);
}
