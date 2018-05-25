package co.com.poli.AppInventario.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.poli.AppInventario.Model.Movimiento;

@Repository
public interface IDaoMovimiento {
	
	public List<Movimiento> getMovimientos();
	public Movimiento getMovimientoById(String id);
	public String saveMovimiento(Movimiento movimiento);
	public String updateMovimiento(Movimiento movimiento);

}
