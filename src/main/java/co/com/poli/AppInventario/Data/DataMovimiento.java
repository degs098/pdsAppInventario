package co.com.poli.AppInventario.Data;

import java.util.ArrayList;
import java.util.List;

import co.com.poli.AppInventario.Model.Movimiento;

public class DataMovimiento {

private static List<Movimiento> list;
	
	static {
		list = new ArrayList<Movimiento>();
	}
	
	public static List<Movimiento> getMovimientos() {
		return list;
	}
	
	public static void setMovimientos(List<Movimiento> newList) {
		list = newList;
	}
}
