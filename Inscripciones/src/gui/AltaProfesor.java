package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.ControladorInscripciones;

public class AltaProfesor extends JInternalFrame {

	JTextField txtLegajo, txtNombre, txtCalle, txtNumero, txtCodigoPostal, txtLocalidad;
	JLabel lblLegajo, lblNombre, lblCalle, lblNumero, lblCodigoPostal, lblLocalidad;
	private JButton btnAceptar, btnSalir;
	private static final long serialVersionUID = 3563299625681416529L;

	public AltaProfesor(String titulo, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
		super(titulo, resizable, closable, maximizable, iconifiable);
		configurar();
		this.setVisible(true);
		this.setSize(330, 200);
	}

	private void configurar() {
		// TODO Auto-generated method stub
		this.setLayout(null);

		lblLegajo = new JLabel("Legajo");
		lblLegajo.setBounds(10, 10, 100, 20);
		txtLegajo = new JTextField();
		txtLegajo.setBounds(110, 10, 50, 20);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 30, 100, 20);
		txtNombre = new JTextField();
		txtNombre.setBounds(110, 30, 200, 20);
		
		lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 50, 100, 20);
		txtCalle = new JTextField();
		txtCalle.setBounds(110, 50, 200, 20);
		
		lblNumero = new JLabel("Número");
		lblNumero.setBounds(10, 70, 100, 20);
		txtNumero = new JTextField();
		txtNumero.setBounds(110, 70, 50, 20);
		
		lblCodigoPostal = new JLabel("Código Postal");
		lblCodigoPostal.setBounds(10, 90, 100, 20);
		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setBounds(110, 90, 70, 20);
		
		lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 110, 100, 20);
		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(110, 110, 150, 20);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(110,140,100,20);
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(210,140,100,20);
				
		this.add(lblLegajo);
		this.add(txtLegajo);
		this.add(lblNombre);
		this.add(txtNombre);
		this.add(lblCalle);
		this.add(txtCalle);
		this.add(lblNumero);
		this.add(txtNumero);
		this.add(lblCodigoPostal);
		this.add(txtCodigoPostal);
		this.add(lblLocalidad);
		this.add(txtLocalidad);
		this.add(btnAceptar);
		this.add(btnSalir);
		
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			int legajo, numero;  
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(datosValidos()){
					legajo = Integer.parseInt(txtLegajo.getText());
					numero = Integer.parseInt(txtNumero.getText());
					ControladorInscripciones.getInstancia().agregarProfesor(legajo, txtNombre.getText(), txtCalle.getText(), numero, txtCodigoPostal.getText(), txtLocalidad.getText());
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Faltan uno o mas de los datos ingresados");
			}

			private boolean datosValidos() {
				return (txtLegajo != null && txtLegajo.getText().length() > 0) &&
					   (txtNombre != null && txtNombre.getText().length() > 0) &&
					   (txtCalle != null && txtCalle.getText().length() > 0) &&
					   (txtNumero != null && txtNumero.getText().length() > 0) &&
					   (txtLocalidad != null && txtLocalidad.getText().length() > 0) &&
					   (txtCodigoPostal != null && txtCodigoPostal.getText().length() > 0);
			}
		});
	}
}
