package co.com.poli.AppInventario.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.poli.AppInventario.Business.IBusinessMovimiento;
import co.com.poli.AppInventario.Model.Movimiento;

@Controller
@RequestMapping("movimientos")
public class MovimientoController {
	
	@Autowired
	IBusinessMovimiento businessMovimiento;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public @ResponseBody List<Movimiento> getMovimientos(){
		return businessMovimiento.getMovimientos();
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public @ResponseBody String saveMovimiento(@RequestBody Movimiento movimiento){
		return businessMovimiento.saveMovimiento(movimiento);				
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	public @ResponseBody String updateMovimiento(@RequestBody Movimiento movimiento){
		return businessMovimiento.updateMovimiento(movimiento);				
	}
	
	
}
