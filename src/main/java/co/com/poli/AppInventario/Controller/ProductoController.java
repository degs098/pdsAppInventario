package co.com.poli.AppInventario.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
}

