package Presentacion;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Ventana de apoyo para la HU-22
 */
public class VentanaAgregarProductoTerminado extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//componentes de la ventana
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JTextField jTextFielId = null;
	private JTextField jTextFieldCantidad = null;
	private JButton jButtonGuardarRegistro = null;
	private JButton jButtonCancelar = null;
	
	//Control de la HU-22
	private ControlRegistroPterminado control = null;
	
	/**
	 * This is the default constructor
	 */
	public VentanaAgregarProductoTerminado(ControlRegistroPterminado control) {
		super();
		initialize();
		setLocationRelativeTo(null);
		this.control = control;
	} //Fin del Constructor

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 300);
		this.setContentPane(getJContentPane());
		this.setTitle("Agregar nuevo registro");
	} //Fin del metodo innitialize

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(20, 70, 60, 15));
			jLabel1.setText("ID:");
			
			jLabel2 = new JLabel();
			jLabel2.setText("Cantidad:");
			jLabel2.setBounds(new Rectangle(20, 120, 60, 15));

			
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(50, 20, 250, 30));
			jLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
			jLabel.setText("Agregar Registro");
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			
			jContentPane.add(getJTextFieldId(), null);
			jContentPane.add(getJTextFieldCantidad(), null);
			jContentPane.add(jLabel2, null);
			
			jContentPane.add(getJButtonGuardarRegistro(), null);
			jContentPane.add(getJButtonCancelar(), null);
		}
		return jContentPane;
	} //Fin del metodo getJContentPane

	/**
	 * This method initializes jTextFielId
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldId() {
		if (jTextFielId == null) {
			jTextFielId = new JTextField();
			jTextFielId.setBounds(new Rectangle(120, 70, 137, 20));
		}
		return jTextFielId;
	} //Fin del metodo getJTextFieldId
	
	/**
	 * This method initializes jTextFieldCantidad	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCantidad() {
		if (jTextFieldCantidad == null) {
			jTextFieldCantidad = new JTextField();
			jTextFieldCantidad.setBounds(new Rectangle(120, 120, 138, 20));
		}
		return jTextFieldCantidad;
	} //Fin del metodo getJTextFieldCantidad

	/**
	 * This method initializes jButtonGuardarRegistro	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGuardarRegistro() {
		if (jButtonGuardarRegistro == null) {
			jButtonGuardarRegistro = new JButton();
			jButtonGuardarRegistro.setBounds(new Rectangle(30, 200, 100, 40));
			jButtonGuardarRegistro.setText("Guardar");
			jButtonGuardarRegistro.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Integer id = Integer.parseInt(jTextFielId.getText());
					Integer cantidad = Integer.parseInt(jTextFieldCantidad.getText());
					control.actualizaCantidad(id, cantidad);
				}
			});
		}
		return jButtonGuardarRegistro;
	} //Fin del metodo getJButtonGuardarRegistro

	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setBounds(new Rectangle(150, 200, 100, 41));
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cierra();
				}
			});
		}
		return jButtonCancelar;
	} //Fin del metodo getJButtonCancelar

	/**
	 * este metodo muestra esta venta 	
	 */
	public void abre() {
		setVisible(true);
	}
	
	/**
	 * este metodo cierra esta ventana	
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
	
	
}
