package co.com.poli.AppInventario.Model;

public class Producto {
	
	private String codigo;
	private String nombre;
	private Double existencia;
	
	public Producto() {

	}
	
	public Producto(String codigo, String nombre, Double existencia) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.existencia = existencia;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getExistencia() {
		return existencia;
	}
	public void setExistencia(Double existencia) {
		this.existencia = existencia;
	}
	
}
