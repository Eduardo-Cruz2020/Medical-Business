package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Producto_Manufacturado;

/**
 * 
 * Implementacion de DAOProductoManufacturado que se conecta con una base de datos relacional
 * 
 * @author Eduardo Cruz
 *
 */
public class DAOProductoManofacturadoBD implements DAOProductoManofacturado{

	/**
	 * Este metodo permite agregar un producto a la base de datos
	 * 
	 * @param libro el producto a agregar
	 * @return true si se creo exitosamente, false si no
	 */
	public boolean crea(Producto_Manufacturado productoManofacturado) {
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			// Ejecuta la instruccion
			statement.execute("INSERT INTO ProductoManufacturado VALUES ('"+productoManofacturado.getId()+"','"+productoManofacturado.getNombre()+"','"+productoManofacturado.getTipo()+"','"+productoManofacturado.getDescripcion()+"','"+productoManofacturado.getCosto()+"','"+productoManofacturado.getCantidad()+"')");	
			return true;
		} catch (SQLException e) {
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}//Fin del metodo crea

	/**
	 * Regresa la lista de todos los productos
	 * 
	 * @return un ArrayList con todos los productos disponibles
	 */
	public ArrayList<Producto_Manufacturado> recuperaTodos() {

		ArrayList <Producto_Manufacturado> productos = new ArrayList<Producto_Manufacturado>();
		try{
			//crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			// obtiene todas las coincidencias
			ResultSet rs = statement.executeQuery("SELECT * FROM ProductoManufacturado");
			//crea e inicializa los productos obtenidos, despues los agrega a la lista 
			while(rs.next())
			{
				Producto_Manufacturado product = new Producto_Manufacturado();
				product.setId(Integer.parseInt(rs.getString("Id")));
				product.setNombre(rs.getString("Nombre"));
				product.setTipo(rs.getString("Tipo"));
				product.setDescripcion(rs.getString("Descripcion"));
				product.setCosto(Double.parseDouble(rs.getString("Costo")));
				product.setCantidad(Integer.parseInt(rs.getString("Cantidad")));
				productos.add(product);			
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return productos;
	}//Fin del metodo recupera todos
	
	
	/**
	 * Elimina un producto de la base de datos mediante su identificador
	 * @param El identificador del producto a eliminar
	 * @return true si el producto fue borrado exitosamente
	 */
	public boolean borra(int id) {
		// TODO Auto-generated method stub
		try{
			//crea la conexion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			//ejecuta la instruccioon
			statement.execute("DELETE FROM ProductoManufacturado WHERE Id = '"+id+"'");
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}//Fin del metodo borra 
	
	/**
	 * Actuliza la cantidad de productos disponibles
	 * @param la cantidad de productos a modificar
	 * @return true si el producto fue actualizado exitosamente
	 */
	public boolean actualizaCantidad(int id, int cantidad) {
		// TODO Auto-generated method stub
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
			// Ejecuta la instruccion
			statement.execute("UPDATE ProductoManufacturado SET cantidad = cantidad + '"+cantidad+"' WHERE id = '"+id+"'");	
			return true;
		} 
		catch (SQLException e) {
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}//Fin del metodo actualizaCantidad

}//Fin de la clase
