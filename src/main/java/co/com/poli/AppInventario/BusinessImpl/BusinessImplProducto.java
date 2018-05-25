package co.com.poli.AppInventario.BusinessImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.poli.AppInventario.Business.IBusinessProducto;
import co.com.poli.AppInventario.Dao.IDaoMovimiento;
import co.com.poli.AppInventario.Dao.IDaoProducto;
import co.com.poli.AppInventario.Model.Movimiento;
import co.com.poli.AppInventario.Model.Producto;
import co.com.poli.AppInventario.Utils.Constants;

@Service
public class BusinessImplProducto implements IBusinessProducto{
	
	@Autowired
	IDaoProducto daoProducto;
	
	@Autowired
	IDaoMovimiento daoMovimiento;
	
	@Override
	public List<Producto> getProductos() {
		return daoProducto.getProductos();
	}

	@Override
	public Producto getProductoById(String id) {
		return daoProducto.getProductoById(id);
	}

	@Override
	public String saveProducto(Producto producto) {		
		return daoProducto.saveProducto(producto);
	}

	@Override
	public String updateProducto(Producto producto) { 
		return daoProducto.updateProducto(producto);
	}

	@Override
	public String inventarioProducto() {
		Double totalInventario = 0D;
		List<Producto> productos = getProductos();
		for(Producto p : productos) {
			totalInventario += calcularInventario(p.getCodigo());
		}
		totalInventario = totalInventario / productos.size();
		return "El total del inventario es: $" + totalInventario;
	}
	
	private Double calcularInventario(String idProducto) {
		Double totalInventarioProducto = 0D;
		Producto producto = getProductoById(idProducto);
		List<Movimiento> movimientosEntrada = daoMovimiento.getMovimientos().stream().filter(movimiento -> 
			idProducto.equals(movimiento.getProducto().getCodigo()) && movimiento.getTipo().equals(Constants.MOVIMIENTO_ENTRADA))
				.collect(Collectors.toList());		
		for(Movimiento m : movimientosEntrada) {
			totalInventarioProducto += m.getPrecio();
		}			
		if(totalInventarioProducto > 0.0) {
			totalInventarioProducto = totalInventarioProducto / movimientosEntrada.size();		
			totalInventarioProducto = totalInventarioProducto * producto.getExistencia();
		}			
		return totalInventarioProducto;
		
	}
	
}
