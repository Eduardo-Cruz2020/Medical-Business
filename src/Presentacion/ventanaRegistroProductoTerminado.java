package Presentacion;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Dominio.Producto_Manufacturado;

/**
 * Ventana de inicio para la HU-22
 */
public class ventanaRegistroProductoTerminado extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//Componentes de la ventana
	private JPanel jContentPane = null;
	private JButton jButtonTerminar = null;
	private JButton jButtonAgregarNuevo = null;
	private JTextArea jTextArea = null;
	private JLabel etiqueta = null;
	
	ArrayList <Producto_Manufacturado> productos= new ArrayList<Producto_Manufacturado>();
	Producto_Manufacturado product=null;
	
	//Control de la HU_22
	private ControlRegistroPterminado control = null;
	
	/**
	 * Este metodo es el construcutor de la ventana, conecta el control 
	 */
	public ventanaRegistroProductoTerminado(ControlRegistroPterminado control,ArrayList <Producto_Manufacturado> productos) {
		super();
		this.control = control;
		this.productos = productos;
		initialize();
		setLocationRelativeTo(null);
	} //Fin del constructor

	/**
	 * This method inicializa la ventana
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 500);
		this.setContentPane(getJContentPane());
		this.setTitle("Registro de productos terminados");
	} //Fin del metodo initialize

	/**
	 * This method inicializa algunos componentes y los agrega al jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {

			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			
			etiqueta = new JLabel();
			etiqueta.setText("Lista de productos disponibles para su venta");
			etiqueta.setBounds(new Rectangle(50,-50,300,150));
			
			jContentPane.add(etiqueta,null);
			jContentPane.add(getJButtonAgregarNuevo(), null);
			jContentPane.add(getJButtonTerminar(), null);
			jContentPane.add(getJTextArea(), null);

		}
		return jContentPane;
	} //Fin del metodo getJContentPane


	/**
	 * This method initializes jButtonAgregarNuevo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgregarNuevo() {
		if (jButtonAgregarNuevo == null) {
			jButtonAgregarNuevo = new JButton();
			jButtonAgregarNuevo.setBounds(new Rectangle(70, 400, 150, 40));
			jButtonAgregarNuevo.setText("Agregar Nuevo");
			jButtonAgregarNuevo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				control.MuestraVentanaAgregarProductoTerminado();
				}
			});
		}
		return jButtonAgregarNuevo;
	} //Fin del metodo getJButtonAgregarNuevo

	/**
	 * This method initializes jButtonEliminarProducto
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonTerminar() {
		if (jButtonTerminar == null) {
			jButtonTerminar = new JButton();
			jButtonTerminar.setBounds(new Rectangle(300, 400, 100, 40));
			jButtonTerminar.setText("Terminar");
			jButtonTerminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				cierra();
				}
			});
		}
		return jButtonTerminar;
	} //Fin del metodo getJButtonTerminar
	
	/**
	 * This method initializes JTextArea 
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JTextArea getJTextArea() {
		jTextArea = new JTextArea();
		String List ="    Nombre          Cantidad\n\n";
		jTextArea.setEditable(true);		
		jTextArea.setBounds(new Rectangle(50,50,370,320));
		
		//Genera la lista a mostrar con la informcion de los productos obtenidos 
		Iterator<Producto_Manufacturado> it = productos.iterator();
		while(it.hasNext()){
		    Producto_Manufacturado producto = it.next();
		    List = List + "    " + producto.getNombre()+ "              "+ producto.getCantidad()+"\n";
		    jTextArea.setText(List);
		}
			return jTextArea;	
	} //Fin del metodo getJTextArea

	/**
	 * este metodo muestra esta venta 	
	 */
	public void abre() {
		setVisible(true);
	}
	
	/**
	 * este metodo cierra esta venta 	
	 */
	public void cierra() {
		this.dispose();
	}

	/**
	 * este metodo nos ayuda a mostrar mensajes de aceptacion o error en la interaccion del usuario con la aplicacion
	 */
	public void muestraMensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}
} //Fin de la clase
