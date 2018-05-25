package co.com.poli.AppInventario.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.poli.AppInventario.Business.IBusinessProducto;
import co.com.poli.AppInventario.Model.Producto;

@Controller
@RequestMapping("productos")
public class ProductoController {
	
	@Autowired
	IBusinessProducto businessProducto;
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<Producto> getProductos(){
		return businessProducto.getProductos();
	}
	
	@RequestMapping(value="", method= RequestMethod.POST)
	public @ResponseBody String saveProducto(@RequestBody Producto producto){
		return businessProducto.saveProducto(producto);
	}
	
	@RequestMapping(value="", method= RequestMethod.PUT)
	public @ResponseBody String updateProducto(@RequestBody Producto producto){
		return businessProducto.updateProducto(producto);
	}
	
	@RequestMapping(value="/inventario", method= RequestMethod.GET)
	public @ResponseBody String getInventarioProductos(){
		return businessProducto.inventarioProducto();
	}
	
}

