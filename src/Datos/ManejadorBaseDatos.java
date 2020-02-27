package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/** 
 * Esta clase permite crear la BD y simplifica la obtencion de conexiones de la base de datos 
 *
 */
public class ManejadorBaseDatos {
	// El logger
	static Logger log = Logger.getRootLogger();
	
	// Referencia a la instancia unica del manejador de la BD
	private static ManejadorBaseDatos manejador = null;
	// La conexion
	private Connection conn = null;
	
	static {
		PropertyConfigurator.configure("res/log4j_config.properties");
	}
	
	private static final String driver ="com.mysql.jdbc.Driver"; 
	private static final String user="root";
	private static final String password="";
	private static final String url = "jdbc:mysql://localhost:3306/sunsystem";
	
	
	/**
	 * Este manejador implementa el patron Singleton, por ello el constructor es privado
	 */
	private ManejadorBaseDatos() throws DatabaseException
	{
		super();
		try
		{
	        /*
	           La instalacion del driver ocurre cuando se carga la clase
	           en un entorno embebido esto inicia a Derby ya que no esta ejecutandose
	         */	
			Class.forName(driver);
			

			conn = DriverManager.getConnection(url, user, password);
			if(conn!=null)
				System.out.println("Acceso a la base de datos exitoso!");	       
	        // AutoCommit = true para que los cambios se repercutan inmediatamente.
	        conn.setAutoCommit(true);
		}
		catch(Exception ex)
		{
			log.error(ex);
			throw new DatabaseException("Problema al levantar base de datos",ex);
		}
	}
	
	/**
	 * Este metodo permite obtener un Connection a partir del cual se pueden
	 * crear Statements para ejectuar codigo SQL.
	 * 
	 * La primera vez que se invoca este metodo, se checa si ya se creo la instancia
	 * del Manejador de la Base de Datos. Si aun no ha sido creado, se instancia. Esto
	 * solo puede ocurrir una vez, por lo tanto esto representa el patron singleton.
	 * 
	 * @return
	 */
	public static Connection getConnection() throws DatabaseException
	{
		if (manejador == null)
		{
			manejador = new ManejadorBaseDatos();
			log.info("El manejador de la base de datos ha sido creado");
		}
		
		return manejador.conn;
	}
	
	/**
	 * El metodo finalize se sobre-escribe para cerrar la conexión y apagar la base de datos cuando
	 * el colector de basura recoge al manejador
	 * 
	 */
	public static void shutdown()	
	{
		log.info("Apagando base de datos...");

		// Si nunca se creo el manejador no hay necesidad de apagarlo...
		if (manejador == null)
		{
			return;
		}

		
		try
		{
			// Se cierra la conexion
			manejador.conn.close();
		}
		catch(SQLException ex)
		{
			log.error(ex);
		}

    }
	
}
