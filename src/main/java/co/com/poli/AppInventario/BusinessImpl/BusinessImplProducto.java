package co.com.poli.AppInventario.BusinessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.poli.AppInventario.Business.IBusinessProducto;
import co.com.poli.AppInventario.Dao.IDaoProducto;
import co.com.poli.AppInventario.Model.Producto;

@Service
public class BusinessImplProducto implements IBusinessProducto{
	
	@Autowired //Anotación con la que inyecto
	IDaoProducto daoProducto;
	
	@Override
	public List<Producto> getProductos() {
		return daoProducto.getProductos();
	}

	@Override
	public Producto getProductoById(String id) {
		return daoProducto.getProductoById(id);
	}
	
	
}
