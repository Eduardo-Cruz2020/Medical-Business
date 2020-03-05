package Presentacion;

import Datos.ManejadorBaseDatos;
/**
 * La clase ControlPrincipal controla la aplicacion
 *
 */
public class ControlPrincipal {

	// Ventana principal
	private VentanaPrincipal ventana;
	private ControlRegistroPmanufacturado controlProductoManufacturado;
	private ControlRegistroMprima controlRegistroMprima;
	private ControlRegistroC_Cliente controlRegistroCliente;
	private ControlRegistroRamales controlRegistroRamales;
	private ControlRegistroPterminado controlTerminado;


	
	public ControlPrincipal(ControlRegistroPmanufacturado controlProductoManufacturado,ControlRegistroMprima controlRegistroMprima,
		ControlRegistroC_Cliente controlRegistroCliente, ControlRegistroRamales controlRegistroRamales, ControlRegistroPterminado controlTerminado) {
		this.controlProductoManufacturado = controlProductoManufacturado;
		this.controlRegistroMprima=controlRegistroMprima;
		this.controlRegistroCliente = controlRegistroCliente;
		this.controlRegistroRamales = controlRegistroRamales;
		this.controlTerminado = controlTerminado;


	}
	/**
	 * Arranca el control principal y por lo tanto la aplicacion.
	 *
	 */
	public void inicia() {
		
		
		// Crea la ventana principal y la muestra
		ventana = new VentanaPrincipal(this);
		ventana.setVisible(true);
	}
	
	/**
	 * Arranca la historia de usuario de agregar libro
	 */
	public void registroPmanufacturado() {
		controlProductoManufacturado.inicia();
	}

	public void registroMprima() {
		controlRegistroMprima.inicia();
	}
	
	public void registroC_Cliente() {
		controlRegistroCliente.inicia();
	}
	
	public void registroRamales() {
		controlRegistroRamales.inicia();
	}
	
	public void regirstroPterminado() {
		controlTerminado.inicia();
	}
	/**
	 * Termina la aplicación
	 */
	public void termina() {
		ManejadorBaseDatos.shutdown();
		System.exit(0);
	}
	
	
}
