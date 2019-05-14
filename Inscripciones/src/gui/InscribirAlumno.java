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

public class InscribirAlumno extends JInternalFrame {

	private static final long serialVersionUID = 3563299625681416529L;
	private JComboBox<AlumnoView> cboAlumnos;
	private JComboBox<CursoView> cboCursos;
	private JLabel lblAlumnos, lblCursos;
	private JButton btnAceptar, btnSalir;

	public InscribirAlumno(String titulo, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
		super(titulo, resizable, closable, maximizable, iconifiable);
		configurar();
		this.setVisible(true);
		this.setSize(330, 120);
	}

	private void configurar() {
		// TODO Auto-generated method stub
		this.setLayout(null);

		lblAlumnos = new JLabel("Alumnos");
		lblAlumnos.setBounds(10, 10, 100, 20);
		cboAlumnos = new JComboBox<AlumnoView>();
		cboAlumnos.setBounds(110, 10, 200, 20);
		List<AlumnoView> alumnos = ControladorInscripciones.getInstancia().getAlumnos();
		for(AlumnoView a : alumnos)
			cboAlumnos.addItem(a);
		
		lblCursos = new JLabel("Cursos");
		lblCursos.setBounds(10, 30, 100, 20);
		cboCursos = new JComboBox<CursoView>();;
		cboCursos.setBounds(110, 30, 200, 20);
		List<CursoView> cursos = ControladorInscripciones.getInstancia().getCursos();
		for(CursoView c : cursos)
			cboCursos.addItem(c);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(110,60,100,20);
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(210,60,100,20);
		
		this.add(lblAlumnos);
		this.add(cboAlumnos);
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
					ControladorInscripciones.getInstancia().inscribirAlumno(((AlumnoView)cboAlumnos.getSelectedItem()).getLegajo(), ((CursoView)cboCursos.getSelectedItem()).getNumero());
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Faltan uno o mas de los datos ingresados");
			}

			private boolean datosValidos() {
				return (cboAlumnos.getSelectedItem() != null && cboCursos.getSelectedItem() != null);
			}
		});
	}
}
