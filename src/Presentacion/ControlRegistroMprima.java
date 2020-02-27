 package Presentacion;

import java.util.ArrayList;

import Dominio.Materia_Prima;
import Negocio.ServicioMprima;


public class ControlRegistroMprima {
	//la ventana principal de la HU-13
	private VentanaRegistroMprima ventana = null;
	private VentanaEliminarMprima ventana1;
	private VentanaAgregarMprima ventana2;
	ArrayList<Materia_Prima> productos;
	// servicio en la capa de presentacion
	private ServicioMprima servicio;
	
	public ControlRegistroMprima(ServicioMprima servicioMprima) {
		this.servicio = servicioMprima;
	}

	public void inicia() {
		//aqui inicia la HU-32 el sistema muestra la ventana RegistroProductoManufactura
		productos = servicio.obtenerInformacionProductos();
		ventana = new VentanaRegistroMprima(this);
		ventana.setVisible(true);
		
	}
	public void MuestraVentanaEliminarMprima() {
		ventana1 = new VentanaEliminarMprima(this);
		ventana1.setVisible(true);
	}
	public void MuestraVentanaAgregarMprima() {
		ventana2 = new VentanaAgregarMprima(this);
		ventana2.setVisible(true);
	}
	public void AgregaNuevo() {
		
	}

	public void AgregaNuevo(String nombre, int id, double precio) {
		// 3.- El usuario introduce los datos del producto munufacturado

				// Verifica primero que los datos no esten vacios
				if(nombre.equals("") || id==0 || precio==0 ) {
						ventana.muestraMensaje("Los campos no deben estar vacios");	
				} else {
					
					System.out.println("Agregando producto: "+nombre);
					
					// 4.- El sistema valida y muestra un mensaje de exito
					if(servicio.generaRegistro(id, nombre, precio)) {
			        
						ventana.muestraMensaje("Se agrego libro exitosamente");
					} else {
						
						// Flujo alternativo en 3, si no se puede agregar, muestra un mensaje de error
						ventana.muestraMensaje( "Un libro con ese nombre ya existe o o se pudo agregar");
			
					}
					
					// 5. El sistema cierra la ventana y regresa a la ventana principal
					ventana.cierra();

				}
	}

	public void eliminaProducto(Integer id) {
		
	}

}

