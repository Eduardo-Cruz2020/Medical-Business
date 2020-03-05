package Presentacion;

import java.util.ArrayList;

import Dominio.Producto_Manufacturado;
import Negocio.ServicioProductoManufacturado;
/**
 * Control que maneja el flujo de la HU_22
 */
public class ControlRegistroPterminado {
	
	//la ventana principal de la HU-32
	private ventanaRegistroProductoTerminado ventana = null;
	
	//Ventan para actualizar la cantidad de productos
	private VentanaAgregarProductoTerminado ventana1;
	
	ArrayList <Producto_Manufacturado> productos;
	
	// servicio en la capa de presentacion
	private ServicioProductoManufacturado servicio;
		
	/**
	* Costructor de la clase , conecta el servicio del producto manufacturado
	* @param El servicio del producto a conectar  
	*/
	public ControlRegistroPterminado(ServicioProductoManufacturado servicioProductoManufacturado) {
		this.servicio = servicioProductoManufacturado;
	} //Fin del constructor
		
	/**
	 * Arranca la ejecucion de la HU-22 
	 */
	public void inicia() {
		//aqui inicia la HU-22 el sistema muestra la ventana RegistroProductoTerminado
		productos = servicio.obtenerInformacionProductos();
		ventana = new ventanaRegistroProductoTerminado(this,productos);
		ventana.setVisible(true);		
	} //Fin del metodo inicia
	
	/**
	 * LLama al  metodo actualizaCantidad del servicio conectado y le pasa los parametros que requiere
	 * @param El identificador del producto a actualizar y la nueva cantidad 
	 */
	public void actualizaCantidad(int id , int cantidad) {
		if(servicio.actualizaCantidad(id, cantidad))
			ventana.muestraMensaje("Cantidad actualizada.");
		else
			ventana.muestraMensaje("El datos ingresados no son válidos o están vacíos.");
	} //Fin del metodo actualizaCantidad
	
	/**
	 * Abre la ventana para Agregar un nuevo registro de producto terminado
	 */
	public void MuestraVentanaAgregarProductoTerminado() {
		ventana1 = new VentanaAgregarProductoTerminado(this);
		ventana1.setVisible(true);
	}//Fin del metodo MuestraVentanaAgregarProductoTerminado
}
