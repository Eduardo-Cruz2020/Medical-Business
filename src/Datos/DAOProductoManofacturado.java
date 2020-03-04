package Datos;

import java.util.ArrayList;

import Dominio.Producto_Manufacturado;

/**
 * DAO Para la entidad ventas
 * 
 * @author Eduardo
 *
 */
public interface DAOProductoManofacturado {
	
	/**
	 * Este metodo permite agregar una venta
	 * 
	 * @param venta
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Producto_Manufacturado productoManofacturado);
	
	/**
	 * Este metodo crea venta a partir de su nombre
	 * 
	 * @param nombre el nombre del venta a buscar
	 * @return una referencia al venta o null si no se encontro
	 */
	public Producto_Manufacturado recupera(int Id_Manofacturado);
	
	/**
	 * Actualiza  Ventas
	 * 
	 * @param libro
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean actualizaCantidad(int id, int cantidad
			);

	/**
	 * Retira un venta
	 * 
	 * @param venta de la venta  a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Producto_Manufacturado productoManofacturado);
	
	/**
	 * Regresa la lista de todas las ventas
	 * 
	 * @return un ArrayList con todos los libros de la libreria
	 */
	public ArrayList<Producto_Manufacturado> recuperaTodos();

	public boolean borra(int id);


}
