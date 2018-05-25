package co.com.poli.AppInventario.Business;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.poli.AppInventario.Model.Movimiento;

@Service
public interface IBusinessMovimiento {
	
	public List<Movimiento> getMovimientos();
	public String saveMovimiento(Movimiento movimiento);
	public String updateMovimiento(Movimiento movimiento);
}
