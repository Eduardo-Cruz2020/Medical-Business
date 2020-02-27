package Negocio;

import java.util.ArrayList;

import Dominio.Producto_Manufacturado;

public interface ServicioProductoManufacturado {

	boolean generaRegistro(int id, String descripcion, String nombre, String tipo, double precio);

	ArrayList<Producto_Manufacturado> obtenerInformacionProductos();
	
	boolean verificaID (int id);
	
	boolean eliminaRegistro(int id);
	

}
