package Negocio;

import java.util.ArrayList;
import java.util.Iterator;

import Datos.DAOProductoManofacturado;
import Dominio.Producto_Manufacturado;

/**
 * Clase que sirve de intermediaria entre los modulos de  capas de datos y la capa de servicio
 */
public class ServicioProductoManufacturadoImpl implements ServicioProductoManufacturado {
	//DAO en la capa de datos
	private DAOProductoManofacturado DAOProducto;
	Producto_Manufacturado producto;
	ArrayList<Producto_Manufacturado> productos ; 
	
	/**
	 * This is the default constructor
	 */
	public ServicioProductoManufacturadoImpl(DAOProductoManofacturado daoProductoManufacturado) {
		// creamos conexion al DAO
		DAOProducto = daoProductoManufacturado;
	} //Fin del constructor
	
	/**
	 * Obtiene la lista de todos los productos que hay en la base datos 
	 * @return un ArrayList con la informcion de los productos
	 */
	public ArrayList<Producto_Manufacturado> obtenerInformacionProductos(){
		productos = DAOProducto.recuperaTodos();
		return productos;
	} //Fin del metodo obtenerInformacionProductos
	
	/**
	 * Si el ID que recibe este método no esta registrado, crea una
	 * nueva instancia y llama al DAO para que la agregue a la base de datos.
	 * @param los datos del producto a crear  (int, String, int, String, String,  double)
	 * @return true si el registro se llevo a cabo exitosamente, false si no
	 */
	public boolean generaRegistro(int Id, String nombre,int cantidad, String tipo, String descripcion, double costo ) {
		if(verificaID(Id)==true) {
		producto = new Producto_Manufacturado(Id, tipo, descripcion, costo, nombre, cantidad);
		DAOProducto.crea(producto);
		return true;
		}
		return false;
	} //Fin del metodo generaRegistro
	
	/**
	 *  método que verifica que no haya dos productos con el mismo id (regla de negocio)
	 *  @param int , el id a verificar
	 *  @return true si se respeta la regla de negocio (no se encontro una coincidencia), false en caso contrario
	*/
	public boolean verificaID(int Id) {
		Iterator<Producto_Manufacturado> it = productos.iterator();
		while(it.hasNext()){
		    producto =it.next();
		    if(Id == producto.getId()) //encontro una coincidencia
		    	return false;
		}
		return true;
	} //Fin del metodo verificaID
	
	/**
	 *  método que llama al DAO para eliminar un producto
	 *  @param int , el id del producto a eliminar
	 *  @return true si se elimino exitosamente el producto, false si no es asi
	*/
	public boolean eliminaRegistro(int Id) {
		if (verificaID(Id))
		return false;
		DAOProducto.borra(Id);
		return true;
	} //Fin del metodo eliminaRegistro
	
	/**
	 *  método que llama al DAO para actualizar la cantidad de productos disponibles
	 *  @param int , el id del producto a actualizar . int la  cantidad a agregar  
	 *  @return true si se actualizo exitosamente el producto, false si no es asi
	*/
	public boolean actualizaCantidad(int id, int cantidad) {
		// TODO Auto-generated method stub
		if (verificaID(id))
		return false;
		DAOProducto.actualizaCantidad(id, cantidad);
		return true;
	} //Fin del metodo actualizaCantidad
	
}//Fin de la clase
