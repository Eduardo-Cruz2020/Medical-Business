package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Producto_Manufacturado;

/**
 * 
 * Implementacion de DAOLibro que se conecta con una base de datos relacional
 * 
 * @author humbertocervantes
 *
 */
public class DAOProductoManofacturadoBD implements DAOProductoManofacturado{
	
	/**
	 * Este metodo permite agregar un libro a la libreria
	 * 
	 * @param libro el libro a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Producto_Manufacturado productoManofacturado) {
		
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			statement.execute("INSERT INTO ProductoManufacturado VALUES ('"+productoManofacturado.getId()+"','"+productoManofacturado.getNombre()+"','"+productoManofacturado.getTipo()+"','"+productoManofacturado.getDescripcion()+"','"+productoManofacturado.getCosto()+"')");	
			return true;
		} catch (SQLException e) {
			
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}

	}
	
	/**
	 * Este metodo busca un titulo
	 * 
	 * @param nombre el nombre del titulo a buscar
	 * @return una referencia al Titulo o null si no se encontro
	 */
	public Producto_Manufacturado recupera(int Id_Manofacturado) {
		Producto_Manufacturado productoManofacturado = null;
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM ProductoManufacturado WHERE No_ventas= '"+Id_Manofacturado+"'");
			
			if(rs.next())
			{
				Producto_Manufacturado producto= new Producto_Manufacturado();
				
				producto.setId(Integer.parseInt(rs.getString("Id")));
				producto.setNombre(rs.getString("Nombre"));
				producto.setTipo(rs.getString("Tipo"));
				producto.setDescripcion(rs.getString("Descripcion"));
				producto.setCosto(Double.parseDouble(rs.getString("Costo")));
				producto.setCantidad(Integer.parseInt(rs.getString("Id")));}
			
			return productoManofacturado;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Retira un libro de la libreria
	 * 
	 * @param libro el libro a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Producto_Manufacturado producto) {
		try{			
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			statement.execute("DELETE FROM Producto_Manufacturado WHERE Venta = '"+producto.getId()+"'");

			
			return true;

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Regresa la lista de todos los libros
	 * 
	 * @return un ArrayList con todos los libros de la libreria
	 */
	public ArrayList<Producto_Manufacturado> recuperaTodos() {

		ArrayList <Producto_Manufacturado> productos = new ArrayList<Producto_Manufacturado>();
		
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT *FROM ProductoManufacturado");

			
			while(rs.next())
			{
				Producto_Manufacturado product = new Producto_Manufacturado();
				product.setId(Integer.parseInt(rs.getString("Id")));
				product.setNombre(rs.getString("Nombre"));
				product.setNombre(rs.getString("Tipo"));
				product.setNombre(rs.getString("Descripcion"));
				product.setCosto(Double.parseDouble(rs.getString("Costo")));
				productos.add(product);			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return productos;

	}	
	
	/**
	 * 
	 */
	public boolean actualiza(Producto_Manufacturado productoManofacturado) {
		// FALTA IMPLEMENTARLO
		return true;
	}

	
	public boolean borra(int id) {
		// TODO Auto-generated method stub
try{			
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			statement.execute("DELETE FROM ProductoManufacturado WHERE Id = '"+id+"'");

			
			return true;

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}

	}

}
