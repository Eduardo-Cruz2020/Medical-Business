package Dominio;

public class Producto_Manufacturado {
	
	public Producto_Manufacturado(Integer id, String nombre, String tipo, Double costo, String descripcion, int cantidad) {
		super();
		Id = id;
		Tipo = tipo;
		Descripcion = descripcion;
		Costo = costo;
		Nombre = nombre;
		this.Cantidad=cantidad;
	}
	public Producto_Manufacturado() {
		// TODO Auto-generated constructor stub
	}
	private Integer Id;
	private String Tipo;
	private String Descripcion;
	private Double Costo;
	private String Nombre;
	private int Cantidad;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(int id_Manufacturado) {
		Id = id_Manufacturado;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public void setCantidad(int cantidad) {
			this.Cantidad = cantidad;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Double getCosto() {
		return Costo;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCosto(double costo) {
		Costo = costo;
	}
	
}
