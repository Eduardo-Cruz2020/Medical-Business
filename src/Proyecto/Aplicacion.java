package Proyecto;


import Datos.DAOProductoManofacturado;
import Datos.DAOProductoManofacturadoBD;
import Datos.DAORamal;
import Datos.DAORamalBD;
import Negocio.ServicioProductoManufacturado;
import Negocio.ServicioProductoManufacturadoImpl;
import Negocio.ServicioRamal;
import Negocio.ServicioRamallmpl;
import Presentacion.ControlPrincipal;
import Presentacion.ControlRegistroC_Cliente;
import Presentacion.ControlRegistroPmanufacturado;
import Presentacion.ControlRegistroPterminado;
import Presentacion.ControlRegistroRamales;
import Datos.DAOCliente;
import Datos.DAOClienteBD;
import Datos.DAOMateria_Prima;
import Datos.DAOMateria_PrimaBD;
import Negocio.ServicioCliente;
import Negocio.ServicioClienteImple;
import Negocio.ServicioMprima;
import Negocio.ServicioMprimaImpl;
import Presentacion.ControlRegistroMprima;

/**
 * 
 * Clase principal que arranca la aplicacion
 * 
 * @author Eduardo
 *
 */
public class Aplicacion {
	
	// Modulos de la aplicacion

	private static ControlPrincipal controlPrincipal;
	private static ControlRegistroPmanufacturado controlRegistropManufacturado;
	private static DAOProductoManofacturado daoProductoManufacturado;
	private static ServicioProductoManufacturado servicioProductoManufacturado;
	
	private static ControlRegistroMprima controlRegistroMprima ;
	private static DAOMateria_Prima daoMprima;
	private static ServicioMprima servicioMprima;
	
	private static ControlRegistroC_Cliente controlRegistroC_Cliente;
	private static DAOCliente daoCliente;
	private static ServicioCliente serviciCliente;
	
	private static ControlRegistroRamales controlRegistroRamales;
	private static DAORamal daoRamal;
	private static ServicioRamal servicioRamal;
	
	private static ControlRegistroPterminado controlPterminado;
	/**
	 * Arranca la aplicacion
	 * 
	 * @param args argumentos de la linea de comandos
	 */
	public static void main(String[] args) {
		
		creaYConectaModulos();

		controlPrincipal.inicia();
	}
	
	/**
	 * Conecta los modulos de la aplicacion.
	 *
	 */
	private static void creaYConectaModulos() {
		// Conecta los modulos
		daoProductoManufacturado = new DAOProductoManofacturadoBD();
		servicioProductoManufacturado = new ServicioProductoManufacturadoImpl(daoProductoManufacturado);
		controlRegistropManufacturado = new ControlRegistroPmanufacturado(servicioProductoManufacturado);
		
		daoMprima = new DAOMateria_PrimaBD();
		servicioMprima = new ServicioMprimaImpl(daoMprima);
		controlRegistroMprima = new ControlRegistroMprima(servicioMprima);
		
		daoCliente = new DAOClienteBD();
		serviciCliente = new ServicioClienteImple(daoCliente);
		controlRegistroC_Cliente = new ControlRegistroC_Cliente(serviciCliente);
		
		daoRamal = new DAORamalBD();
		servicioRamal = new ServicioRamallmpl(daoRamal);
		controlRegistroRamales = new ControlRegistroRamales(servicioRamal);
		
		controlPterminado = new ControlRegistroPterminado(servicioProductoManufacturado);
		
		controlPrincipal = new ControlPrincipal(controlRegistropManufacturado, controlRegistroMprima,
				controlRegistroC_Cliente,controlRegistroRamales, controlPterminado);

		/*controlPrincipal = new ControlPrincipal(controlRegistroMprima);*/

		

	}
	

}