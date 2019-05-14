package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.ControladorInscripciones;
import view.AlumnoView;
import view.CursoView;
import view.MateriaView;
import view.ProfesorView;

public class CrearCurso extends JInternalFrame {

	private static final long serialVersionUID = 3563299625681416529L;
	private JComboBox<MateriaView> cboMaterias;
	private JComboBox<ProfesorView> cboProfesores;
	private JComboBox<String> cboDias, cboTurnos;
	private JLabel lblMateria, lblProfesor, lblDia, lblTurno, lblVacantes;
	private JTextField txtVacantes;
	private JButton btnAceptar, btnSalir;

	public CrearCurso(String titulo, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
		super(titulo, resizable, closable, maximizable, iconifiable);
		configurar();
		this.setVisible(true);
		this.setSize(370, 210);
	}

	private void configurar() {
		this.setLayout(null);

		lblMateria = new JLabel("Materias");
		lblMateria.setBounds(10, 10, 100, 20);
		cboMaterias = new JComboBox<MateriaView>();
		cboMaterias.setBounds(130, 10, 200, 20);
		List<MateriaView> materias = ControladorInscripciones.getInstancia().getMaterias();
		for(MateriaView m : materias)
			cboMaterias.addItem(m);
		
		lblProfesor = new JLabel("Profesores");
		lblProfesor.setBounds(10, 35, 100, 20);
		cboProfesores = new JComboBox<ProfesorView>();
		cboProfesores.setBounds(130, 35, 200, 20);
		List<ProfesorView> profesores = ControladorInscripciones.getInstancia().getProfesores();
		for(ProfesorView p : profesores)
			cboProfesores.addItem(p);

		lblDia = new JLabel("Día del Curso");
		lblDia.setBounds(10, 60, 100, 20);
		cboDias = new JComboBox<String>();
		cboDias.setBounds(130, 60, 200, 20);
		cboDias.addItem("Lunes"); 
		cboDias.addItem("Martes"); 
		cboDias.addItem("Miercoles"); 
		cboDias.addItem("Jueves"); 
		cboDias.addItem("Viernes");
		
		lblTurno = new JLabel("Día del Curso");
		lblTurno.setBounds(10, 85, 100, 20);
		cboTurnos = new JComboBox<String>();
		cboTurnos.setBounds(130, 85, 200, 20);
		cboTurnos.addItem("Mañana"); 
		cboTurnos.addItem("Tarde"); 
		cboTurnos.addItem("Noche"); 

		lblVacantes = new JLabel("Cantidad Alumnos");
		lblVacantes.setBounds(10, 110, 120, 20);
		txtVacantes = new JTextField();
		txtVacantes.addKeyListener(new KeyAdapter() {
					
			@Override
			public void keyTyped(KeyEvent e) {

				char caracter = e.getKeyChar();
				if(((caracter < '0') || (caracter > '9')) &&
					(caracter != '\b')) {
					e.consume();  
				}
			}
		});
		
		txtVacantes.setBounds(130, 110, 50, 20);

		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(130,150,100,20);
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(230,150,100,20);
		
		this.add(lblMateria);
		this.add(cboMaterias);
		this.add(lblProfesor);
		this.add(cboProfesores);
		this.add(lblDia);
		this.add(cboDias);
		this.add(lblTurno);
		this.add(cboTurnos);
		this.add(lblVacantes);
		this.add(txtVacantes);
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
					String codigo, dia, turno;
					int legajo, vacantes;
					codigo = ((MateriaView)cboMaterias.getSelectedItem()).getCodigo();
					legajo = ((ProfesorView)cboProfesores.getSelectedItem()).getLegajo();
					dia = (String)cboDias.getSelectedItem();
					turno = (String)cboTurnos.getSelectedItem();
					vacantes = Integer.parseInt(txtVacantes.getText());
					ControladorInscripciones.getInstancia().crearCurso(codigo, legajo, dia, turno, vacantes);
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Faltan uno o mas de los datos ingresados");
			}

			private boolean datosValidos() {
				return (cboMaterias.getSelectedItem() != null && cboProfesores.getSelectedItem() != null &&
						cboDias.getSelectedItem() != null && cboTurnos.getSelectedItem() != null &&
						txtVacantes.getText() != null && txtVacantes.getText().length() > 0);
			}
		});
	}
}
