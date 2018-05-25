package co.com.poli.AppInventario.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.poli.AppInventario.Dao.IDaoMovimiento;
import co.com.poli.AppInventario.Data.DataMovimiento;
import co.com.poli.AppInventario.Model.Movimiento;

@Repository
public class DaoImplMovimiento implements IDaoMovimiento{
	
	@Override
	public List<Movimiento> getMovimientos() {		
		List<Movimiento> lista = new ArrayList<Movimiento>();
		try {
			lista = DataMovimiento.getMovimientos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@Override
	public Movimiento getMovimientoById(String id) {
		List<Movimiento> lista = getMovimientos();
		Movimiento movimiento = new Movimiento();
		for(Movimiento p : lista) {
			if(p.getId().equals(id)) {
				movimiento = p;
				break;
			}
		}
		return movimiento;		
	}
	
	@Override
	public String saveMovimiento(Movimiento movimiento) {
		List<Movimiento> lista = DataMovimiento.getMovimientos();
		try {
			lista.add(movimiento);
			DataMovimiento.setMovimientos(lista);
			return "Movimiento agregado";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error al agregar el movimiento";
		}		
	}

	@Override
	public String updateMovimiento(Movimiento movimiento) {
		List<Movimiento> lista = DataMovimiento.getMovimientos();
		Movimiento movimientoExist = getMovimientoById(movimiento.getId());
		if(movimientoExist != null) {
			try {
				Integer index = lista.indexOf(movimientoExist);
				lista.set(index, movimiento);
				DataMovimiento.setMovimientos(lista);
				return "Movimiento actualizado";
			} catch (Exception e) {
				e.printStackTrace();
				return "Error al actualizar el movimiento";
			}				
		}else {
			return "No existe el movimiento";
		}
	}

	@Override
	public String deleteMovimiento(String id) {
		try {
			
			return "Movimiento eliminado";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error al eliminar el movimiento";
		}		
	}

}
