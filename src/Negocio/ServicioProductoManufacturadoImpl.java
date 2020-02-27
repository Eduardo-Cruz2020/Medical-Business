package Negocio;

import java.util.ArrayList;
import java.util.Iterator;

import Datos.DAOProductoManofacturado;
import Dominio.Producto_Manufacturado;

public class ServicioProductoManufacturadoImpl implements ServicioProductoManufacturado {
	private DAOProductoManofacturado DAOProducto;
	Producto_Manufacturado producto;
	ArrayList<Producto_Manufacturado> productos ; 

	public ServicioProductoManufacturadoImpl(DAOProductoManofacturado daoProductoManufacturado) {
		// creamos conexion al DAO
		DAOProducto = daoProductoManufacturado;
	}
	
	public ArrayList<Producto_Manufacturado> obtenerInformacionProductos(){
		productos = DAOProducto.recuperaTodos();
		return productos;
	}
	/*
	 * Si el ID que recibe este método no esta registrado, crea una
	 *  nueva instancia y llama al DAO para que la agregue a la base de datos.
	 */
	public boolean generaRegistro(int Id, String descripcion,int cantidad, String nombre, String tipo, double costo ) {
		if(verificaID(Id)==true) {
		producto = new Producto_Manufacturado(Id, tipo, descripcion, costo, nombre, cantidad);
		DAOProducto.crea(producto);
		return true;
		}
		return false;
	}
	/*
	 *  método que verifica que no haya dos productos con el mismo id (regla de negocio)
	*/
	public boolean verificaID(int Id) {
		Iterator<Producto_Manufacturado> it = productos.iterator();
		while(it.hasNext()){
		    producto =it.next();
		    if(Id == producto.getId()) //encontro una coincidencia
		    	return false;
		}
		return true;
	}
 
	public boolean eliminaRegistro(int Id) {
		if (verificaID(Id) == true ) {
		return false;
		}
		DAOProducto.borra(Id);
		return true;
	}

}
