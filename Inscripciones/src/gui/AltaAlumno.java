package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.ControladorInscripciones;

public class AltaAlumno extends JInternalFrame {

	private static final long serialVersionUID = -7885298908000683951L;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JButton btnAceptar, btnSalir;
	
	public AltaAlumno(String titulo, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
		super(titulo, resizable, closable, maximizable, iconifiable);
		configurar();
		this.setVisible(true);
		this.pack();
	}

	private void configurar() {
		
		this.setLayout(new GridLayout(2, 2));
		lblNombre = new JLabel(" Nuevo Alumno ");
		txtNombre = new JTextField();
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText() != null || txtNombre.getText().length() > 0){
					ControladorInscripciones.getInstancia().agregarAlumno(txtNombre.getText());
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
			}
		});
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		this.add(lblNombre);
		this.add(txtNombre);
		this.add(btnAceptar);
		this.add(btnSalir);
	
	}
}
