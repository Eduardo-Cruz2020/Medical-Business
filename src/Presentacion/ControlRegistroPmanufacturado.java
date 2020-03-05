package Presentacion;

import java.util.ArrayList;
import java.util.Iterator;

import Dominio.Producto_Manufacturado;
import Negocio.ServicioProductoManufacturado;


public class ControlRegistroPmanufacturado {
	//la ventana principal de la HU-32
	private VentanaRegistroProductoManufacturado ventana = null;
	private VentanaEliminarProductoManufacturado ventana1;
	private VentanaAgregarProductoManufacturado ventana2;
	ArrayList <Producto_Manufacturado> productos;
	// servicio en la capa de presentacion
	private ServicioProductoManufacturado servicio;
	
	public ControlRegistroPmanufacturado(ServicioProductoManufacturado servicioProductoManufacturado) {
		this.servicio = servicioProductoManufacturado;
	}

	public void inicia() {
		//aqui inicia la HU-32 el sistema muestra la ventana RegistroProductoManufactura
		productos = servicio.obtenerInformacionProductos();
		ventana = new VentanaRegistroProductoManufacturado(this,productos);
		ventana.setVisible(true);
		
	}
	public void MuestraVentanaEliminarProductoManufacturado() {
		ventana1 = new VentanaEliminarProductoManufacturado(this);
		ventana1.setVisible(true);
	}
	public void MuestraVentanaAgregarProductoManufacturado() {
		ventana2 = new VentanaAgregarProductoManufacturado(this);
		ventana2.setVisible(true);
	}

	public void AgregaNuevo(String nombre, String descripcion,int cantidad, String tipo, int id, double precio) {
		// 3.- El usuario introduce los datos del producto munufacturado

				// Verifica primero que los datos no esten vacios
				if(nombre.equals("") || descripcion.equals("") || tipo.equals("") || id==0 || precio==0 ) {
						ventana.muestraMensaje("Los campos no deben estar vacios");	
				} else {
			
					
					System.out.println("Agregando producto: "+nombre+" del tipo:"+tipo);
					
					// 4.- El sistema valida y muestra un mensaje de exito
					if(servicio.generaRegistro(id, descripcion, cantidad, nombre, tipo, precio)) {
			        
						ventana.muestraMensaje("Se agrego el  producto exitosamente");
					} else {
						
						// Flujo alternativo en 3, si no se puede agregar, muestra un mensaje de error
						ventana.muestraMensaje( "Un producto con ese nombre ya existe o o se pudo agregar");
			
					}
					
					// 5. El sistema cierra la ventana y regresa a la ventana principal
					ventana.cierra();

				}
	}

	public void eliminaProducto(Integer id) {
		if(servicio.eliminaRegistro(id))
			ventana.muestraMensaje("Producto eliminado.");
		else
			ventana.muestraMensaje("El identificador que ingresó no existe.");
	}

}
