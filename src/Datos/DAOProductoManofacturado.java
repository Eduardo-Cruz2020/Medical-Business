package Datos;

import java.util.ArrayList;

import Dominio.Producto_Manufacturado;

/**
 * DAO Para la entidad ProductoManufacturado
 * 
 * @author Eduardo
 *
 */
public interface DAOProductoManofacturado {
	
	/**
	 * Este metodo permite agregar un producto a la base de datos
	 * 
	 * @param libro el producto a agregar
	 * @return true si se creo exitosamente, false si no
	 */
	public boolean crea(Producto_Manufacturado productoManofacturado);
	
	/**
	 * Actuliza la cantidad de productos disponibles
	 * @param la cantidad de productos a modificar
	 * @return true si el producto fue actualizado exitosamente
	 */
	public boolean actualizaCantidad(int id, int cantidad);
	
	/**
	 * Regresa la lista de todos los productos
	 * 
	 * @return un ArrayList con todos los productos disponibles
	 */
	public ArrayList<Producto_Manufacturado> recuperaTodos();
	
	/**
	 * Elimina un producto de la base de datos mediante su identificador
	 * @param El identificador del producto a eliminar
	 * @return true si el producto fue borrado exitosamente
	 */
	public boolean borra(int id);

} //Fin de la clase
