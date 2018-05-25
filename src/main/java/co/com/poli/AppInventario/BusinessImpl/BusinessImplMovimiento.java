package co.com.poli.AppInventario.BusinessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.poli.AppInventario.Business.IBusinessMovimiento;
import co.com.poli.AppInventario.Business.IBusinessProducto;
import co.com.poli.AppInventario.Dao.IDaoMovimiento;
import co.com.poli.AppInventario.Model.Movimiento;
import co.com.poli.AppInventario.Model.Producto;
import co.com.poli.AppInventario.Utils.Constants;

@Service
public class BusinessImplMovimiento implements IBusinessMovimiento{

	@Autowired
	IDaoMovimiento daoMovimiento;
	
	@Autowired
	IBusinessProducto businessProducto;
	
	@Override
	public List<Movimiento> getMovimientos() {		
		return daoMovimiento.getMovimientos();
	}

	@Override
	public String saveMovimiento(Movimiento movimiento) {
		return validateMovimiento(movimiento, false);
	}

	@Override
	public String updateMovimiento(Movimiento movimiento) { 
		return validateMovimiento(movimiento, true);
	}
	
	private String validateMovimiento(Movimiento movimiento, Boolean isEditing) {
		Producto producto = businessProducto.getProductoById(movimiento.getProducto().getCodigo());
		if(producto != null) {
			if(movimiento.getTipo().equals(Constants.MOVIMIENTO_ENTRADA)) {			
				producto.setExistencia(producto.getExistencia() + movimiento.getCantidad());
			}else {
				if(movimiento.getCantidad() > producto.getExistencia() || movimiento.getCantidad() <= 0) {
					return Constants.ERROR_TRANSACCION;
				}
				producto.setExistencia(producto.getExistencia() - movimiento.getCantidad());
				movimiento.setPrecio(0D);
			}			
			
			if(producto.getExistencia() < 0 && movimiento.getPrecio() <= 0) {
				return Constants.ERROR_TRANSACCION;
			}else {
				if(isEditing) {
					return businessProducto.updateProducto(producto);
				}
				return daoMovimiento.saveMovimiento(movimiento);
			}				
		}else {
			return Constants.NO_HAY_EXISTENCIA;
		}
	}

}
