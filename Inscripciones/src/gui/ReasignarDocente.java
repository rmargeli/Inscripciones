package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controlador.ControladorInscripciones;
import view.AlumnoView;
import view.CursoView;
import view.ProfesorView;

public class ReasignarDocente extends JInternalFrame {

	private static final long serialVersionUID = 3563299625681416529L;
	private JComboBox<ProfesorView> cboProfesores;
	private JComboBox<CursoView> cboCursos;
	private JLabel lblProfesor, lblCursos;
	private JButton btnAceptar, btnSalir;

	public ReasignarDocente(String titulo, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
		super(titulo, resizable, closable, maximizable, iconifiable);
		configurar();
		this.setVisible(true);
		this.setSize(330, 120);
	}

	private void configurar() {

		this.setLayout(null);
		
		lblCursos = new JLabel("Cursos");
		lblCursos.setBounds(10, 10, 100, 20);
		cboCursos = new JComboBox<CursoView>();;
		cboCursos.setBounds(110, 10, 200, 20);
		List<CursoView> cursos = ControladorInscripciones.getInstancia().getCursos();
		for(CursoView c : cursos)
			cboCursos.addItem(c);

		lblProfesor = new JLabel("Profesores");
		lblProfesor.setBounds(10, 35, 100, 20);
		cboProfesores = new JComboBox<ProfesorView>();
		cboProfesores.setBounds(110, 35, 200, 20);
		List<ProfesorView> profesores = ControladorInscripciones.getInstancia().getProfesores();
		for(ProfesorView p : profesores)
			cboProfesores.addItem(p);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(110,60,100,20);
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(210,60,100,20);
		
		this.add(lblProfesor);
		this.add(cboProfesores);
		this.add(lblCursos);
		this.add(cboCursos);
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
					ControladorInscripciones.getInstancia().reasignarDocente(((CursoView)cboCursos.getSelectedItem()).getNumero(), ((ProfesorView)cboProfesores.getSelectedItem()).getLegajo());
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Faltan uno o mas de los datos ingresados");
			}

			private boolean datosValidos() {
				return (cboProfesores.getSelectedItem() != null && cboCursos.getSelectedItem() != null);
			}
		});
	}
}
