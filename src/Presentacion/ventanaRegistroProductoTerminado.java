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

public class ventanaRegistroProductoTerminado extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton jButtonTerminar = null;

	private JButton jButtonAgregarNuevo = null;
	
	ArrayList <Producto_Manufacturado> productos= new ArrayList<Producto_Manufacturado>();
	Producto_Manufacturado product=null;


	
	private JTextArea jTextArea = null;
	private JLabel etiqueta = null;



	private ControlRegistroPterminado control = null;
	/**
	 * This is the default constructor
	 */
	public ventanaRegistroProductoTerminado(ControlRegistroPterminado control,ArrayList <Producto_Manufacturado> productos) {
		super();
		this.control = control;
		this.productos = productos;
		initialize();
		setLocationRelativeTo(null);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 500);
		this.setContentPane(getJContentPane());
		this.setTitle("Registro de productos terminados");
	}

	/**
	 * This method initializes jContentPane
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
	}


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
	}

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
	}
	
	private JTextArea getJTextArea() {
		jTextArea = new JTextArea();
		String List ="    Nombre          Cantidad\n\n";

		jTextArea.setEditable(true);		
		jTextArea.setBounds(new Rectangle(50,50,370,320));
		Iterator<Producto_Manufacturado> it = productos.iterator();
		while(it.hasNext()){
		    Producto_Manufacturado producto = it.next();
		    List = List + "    " + producto.getNombre()+ "              "+ producto.getCantidad()+"\n";
		    jTextArea.setText(List);
		}
			return jTextArea;	
	}

	public void abre() {
		setVisible(true);
	}
	
	public void cierra() {
		this.dispose();
	}

	
	public void muestraMensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
