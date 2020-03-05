package Negocio;

import java.util.ArrayList;

import Dominio.Producto_Manufacturado;

public interface ServicioProductoManufacturado {
	
	/**
	 * Si el ID que recibe este método no esta registrado, crea una
	 * nueva instancia y llama al DAO para que la agregue a la base de datos.
	 * @param los datos del producto a crear  (int, String, int, String, String,  double)
	 * @return true si el registro se llevo a cabo exitosamente, false si no
	 */
	boolean generaRegistro(int id, String descripcion,int cantidad, String nombre, String tipo, double precio);
	
	/**
	 * Obtiene la lista de todos los productos que hay en la base datos 
	 * @return un ArrayList con la informcion de los productos
	 */
	ArrayList<Producto_Manufacturado> obtenerInformacionProductos();
	
	/**
	 *  método que verifica que no haya dos productos con el mismo id (regla de negocio)
	 *  @param int , el id a verificar
	 *  @return true si se respeta la regla de negocio (no se encontro una coincidencia), false en caso contrario
	*/
	boolean verificaID (int id);
	
	/**
	 *  método que llama al DAO para eliminar un producto
	 *  @param int , el id del producto a eliminar
	 *  @return true si se elimino exitosamente el producto, false si no es asi
	*/
	boolean eliminaRegistro(int id);
	
	/**
	 *  método que llama al DAO para actualizar la cantidad de productos disponibles
	 *  @param int , el id del producto a actualizar . int la  cantidad a agregar  
	 *  @return true si se actualizo exitosamente el producto, false si no es asi
	*/
	boolean actualizaCantidad(int id, int cantidad);
	

}
