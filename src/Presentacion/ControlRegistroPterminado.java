package Presentacion;

import java.util.ArrayList;

import Dominio.Producto_Manufacturado;
import Negocio.ServicioProductoManufacturado;

public class ControlRegistroPterminado {
	//la ventana principal de la HU-32
		private ventanaRegistroProductoTerminado ventana = null;
		private VentanaAgregarProductoTerminado ventana1;
		ArrayList <Producto_Manufacturado> productos;
		// servicio en la capa de presentacion
		private ServicioProductoManufacturado servicio;
		
		public ControlRegistroPterminado(ServicioProductoManufacturado servicioProductoManufacturado) {
			this.servicio = servicioProductoManufacturado;
		}

		public void inicia() {
			//aqui inicia la HU-22 el sistema muestra la ventana RegistroProductoTerminado
			productos = servicio.obtenerInformacionProductos();
			ventana = new ventanaRegistroProductoTerminado(this,productos);
			ventana.setVisible(true);
			
		}
		
		public void actualizaCantidad(int id , int cantidad) {
			if(servicio.actualizaCantidad(id, cantidad))
				ventana.muestraMensaje("Cantidad actualizada.");
			else
				ventana.muestraMensaje("El datos ingresados no son válidos o están vacíos.");

		}

		public void MuestraVentanaAgregarProductoTerminado() {
			ventana1 = new VentanaAgregarProductoTerminado(this);
			ventana1.setVisible(true);
		}

		
}
