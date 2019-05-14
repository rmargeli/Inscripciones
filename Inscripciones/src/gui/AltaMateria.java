package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.ControladorInscripciones;

public class AltaMateria extends JInternalFrame {

	JTextField txtCodigo, txtDescripcion;
	JLabel lblCodigo, lblDescripcion;
	private JButton btnAceptar, btnSalir;
	private static final long serialVersionUID = 3563299625681416529L;

	public AltaMateria(String titulo, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
		super(titulo, resizable, closable, maximizable, iconifiable);
		configurar();
		this.setVisible(true);
		this.setSize(330, 120);
	}

	private void configurar() {
		// TODO Auto-generated method stub
		this.setLayout(null);

		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 10, 100, 20);
		txtCodigo = new JTextField();
		txtCodigo.setBounds(110, 10, 50, 20);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 30, 100, 20);
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(110, 30, 200, 20);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(110,60,100,20);
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(210,60,100,20);
		
		this.add(lblCodigo);
		this.add(txtCodigo);
		this.add(lblDescripcion);
		this.add(txtDescripcion);
		this.add(btnAceptar);
		this.add(btnSalir);
		
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(datosValidos()){
					ControladorInscripciones.getInstancia().agregarMateria(txtCodigo.getText(), txtDescripcion.getText());
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Faltan uno o mas de los datos ingresados");
			}

			private boolean datosValidos() {
				return (txtCodigo != null && txtCodigo.getText().length() > 0) &&
					   (txtDescripcion != null && txtDescripcion.getText().length() > 0);
			}
		});
	}
}
