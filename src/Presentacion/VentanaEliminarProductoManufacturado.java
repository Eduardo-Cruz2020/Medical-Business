package Presentacion;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JTextField;

import Presentacion.ControlRegistroPmanufacturado;

import javax.swing.JButton;
import javax.swing.JFrame;
public class VentanaEliminarProductoManufacturado extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel = null;

	private JTextField jTextFieldId = null;

	private JButton jButtonEliminar = null;
	private JButton jButtonCancelar = null;

	private ControlRegistroPmanufacturado control = null;
	/**
	 * This is the default constructor
	 */
	public VentanaEliminarProductoManufacturado(ControlRegistroPmanufacturado control) {
		super();
		initialize();
		setLocationRelativeTo(null);
		this.control = control;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Eliminar producto");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(50, 20, 250, 30));
			jLabel1.setFont(new Font("Arial Black", Font.BOLD, 18));
			jLabel1.setText("Eliminar Producto");
			
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(60, 72, 30, 15));
			jLabel.setText("Id:");
			
			
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1,null);
			
			jContentPane.add(getJTextFieldId(), null);
			jContentPane.add(getJButtonCancelar(), null);
			jContentPane.add(getJButtonEliminar(), null);
		}
		return jContentPane;
	}

	
	/**
	 * This method initializes jTextFieldId	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldId() {
		if (jTextFieldId == null) {
			jTextFieldId = new JTextField();
			jTextFieldId.setBounds(new Rectangle(90, 72, 138, 19));
		}
		return jTextFieldId;
	}
	

	/**
	 * This method initializes jButtonAceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setBounds(new Rectangle(30, 120, 106, 31));
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Integer id = Integer.parseInt(jTextFieldId.getText());
						control.eliminaProducto(id);
				}
			});
		}
		return jButtonEliminar;
	}

	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setBounds(new Rectangle(149, 120, 107, 31));
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cierra();
				}
			});
		}
		return jButtonCancelar;
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
