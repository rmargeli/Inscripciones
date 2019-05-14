package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	private static final long serialVersionUID = -7189647070719732198L;
	private JMenuBar barraMenu;
	private JMenu mnAlta, mnAcciones, mnSalir;
	/*items del menu Alta*/
	private JMenuItem mnMateria, mnAlumno, mnDocente;
	/*items del menu Acciones*/
	private JMenuItem mnInscribir, mnCrearCurso, mnReasignarDocente;
	/*items del menu Salir*/
	private JMenuItem mnSalirItem;
	private JDesktopPane desktop; 
	private AltaAlumno addAlumno;
	private AltaProfesor addDocente;
	private AltaMateria addMateria;
	private JInternalFrame inscribir, crearCurso, reasignarDocente;
	
	public Principal(){
		configurar();
		asignarEventos();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(600, 400);
		this.setResizable(false);
	}
	
	private void asignarEventos() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		mnSalirItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
		mnAlumno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addAlumno = new AltaAlumno("Alta Alumno", false, true, false, true);
				desktop.add(addAlumno); 
				
			}
		});
		mnDocente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addDocente = new AltaProfesor("Alta Profesor", false, true, false, true);
				desktop.add(addDocente);
			}
		});
		mnMateria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addMateria = new AltaMateria("Alta Materia", false, true, false, true);
				desktop.add(addMateria);
			}
		});
		mnInscribir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				inscribir = new InscribirAlumno("Inscribir Alumno", false, true, false, true);
				desktop.add(inscribir);
			}
		});
		mnCrearCurso.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				crearCurso = new CrearCurso("Nuevo Curso", false, true, false, true);
				desktop.add(crearCurso);
			}
		});
		mnReasignarDocente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reasignarDocente = new ReasignarDocente("Reasignacion de Docente", false, true, false, true);
				desktop.add(reasignarDocente);
			}
		});
	}

	private void configurar(){
		
		this.setTitle("Inscripciones");
		desktop = new JDesktopPane();
		this.setContentPane(desktop);

		barraMenu = new JMenuBar();
		mnAlta = new JMenu("Altas");
		mnAcciones = new JMenu("Acciones");
		mnSalir = new JMenu("Salir");
		
		mnMateria = new JMenuItem("Materia");
		mnAlumno = new JMenuItem("Alumno");
		mnDocente = new JMenuItem("Docente");
		
		mnInscribir = new JMenuItem("Inscribir Alumno");
		mnCrearCurso = new JMenuItem("Crear Curso");
		mnReasignarDocente = new JMenuItem("Reasignar Docente");
		
		mnSalirItem = new JMenuItem("Salir");
		
		mnAlta.add(mnMateria);
		mnAlta.add(mnAlumno);
		mnAlta.add( mnDocente);
		
		mnAcciones.add(mnInscribir);
		mnAcciones.add(mnCrearCurso);
		mnAcciones.add(mnReasignarDocente);
		
		mnSalir.add(mnSalirItem);
		
		barraMenu.add(mnAlta);
		barraMenu.add(mnAcciones);
		barraMenu.add(mnSalir);
		
		this.setJMenuBar(barraMenu);
		
	}

}
