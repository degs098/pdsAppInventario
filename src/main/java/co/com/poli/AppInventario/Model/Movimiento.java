package co.com.poli.AppInventario.Model;

public class Movimiento {

	private String id;
	private Producto producto;
	private Double cantidad;
	private String tipo;
	private Double precio;
	
	public Movimiento() {
	}
	
	public Movimiento(String id, Producto producto, Double cantidad, String tipo, Double precio) {
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.tipo = tipo;
		this.precio = precio;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}
