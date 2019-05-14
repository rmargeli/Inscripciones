package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import negocio.Alumno;
import negocio.Curso;
import negocio.Materia;
import negocio.Profesor;
import view.AlumnoView;
import view.CursoView;
import view.MateriaView;
import view.ProfesorView;

public class ControladorInscripciones {

	private static ControladorInscripciones instancia;
	private List<Alumno> alumnos;
	private List<Curso> cursos;
	private List<Materia> materias;
	private List<Profesor> profesores;
	
	private ControladorInscripciones(){
		alumnos = new ArrayList<Alumno>();
		cargoAlumnos();
		cursos = new ArrayList<Curso>();
		materias = new ArrayList<Materia>();
		cargoMaterias();
		profesores = new ArrayList<Profesor>();
		cargoProfesores();
		cargoCursos();
	}
	
	public static ControladorInscripciones getInstancia(){
		if(instancia == null)
			instancia = new ControladorInscripciones();
		return instancia;
	}
	public void crearCurso(String codigo, int legajo, String dia, String turno, int maximo){
		Materia materia = buscarMateria(codigo);
		Profesor profesor = buscarProfesor(legajo);
		if(materia != null && profesor != null){
			if(profesor.disponible(dia, turno)){
				Curso curso = new Curso(profesor, materia, dia, turno, maximo);
				profesor.agregarCurso(curso);
				cursos.add(curso);
			}
			else
				JOptionPane.showMessageDialog(null, "El profesor " + profesor.getNombre() + " no esta disponible los " + dia + " a la " + turno);
		}
		else
			JOptionPane.showMessageDialog(null, "Error en el sistema, comuniquese con el administrador");
	}
	
	public void inscribirAlumno(int legajo, int numero){
		Curso curso = buscarCurso(numero);
		Alumno alumno = buscarAlumno(legajo);
		if(curso != null && alumno != null)
			curso.anotarAlumno(alumno);
		else
			JOptionPane.showMessageDialog(null, "Error en el sistema, comuniquese con el administrador");
	}
	
	public void reasignarDocente(int numero, int legajo){
		Curso curso = buscarCurso(numero);
		Profesor profesor = buscarProfesor(legajo);
		if(curso != null && profesor != null)
			curso.reasignarProfesor(profesor);
		else
			JOptionPane.showMessageDialog(null, "Error en el sistema, comuniquese con el administrador");	
	}
	
	public List<AlumnoView> getAlumnos(){
		List<AlumnoView> resultado = new ArrayList<AlumnoView>();
		for(Alumno a : alumnos)
			resultado.add(a.toView());
		return resultado;
	} 
	
	public void agregarAlumno(String nombre){
		if(!isAlumnoPorNombre(nombre)){
			Alumno a = new Alumno(nombre);
			alumnos.add(a);
		}
		else
			JOptionPane.showMessageDialog(null, "El alumno " + nombre + " ya existe");
	}
	
	public void agregarProfesor(int legajo, String nombre, String calle, int numero, String codigoPostal, String localidad){
		if(buscarProfesor(legajo) == null){
			Profesor p = new Profesor(legajo, nombre, calle, numero, codigoPostal, localidad);
			profesores.add(p);
		}
		else
			JOptionPane.showMessageDialog(null, "El profesor " + nombre + " ya existe");
	}
	
	public void agregarMateria(String codigo, String descripcion) {
		if(buscarMateria(codigo) == null){
			Materia m = new Materia(codigo, descripcion);
			materias.add(m);
		}
		else
			JOptionPane.showMessageDialog(null, "La Materia " + descripcion + " ya existe");
	}
	
	public List<CursoView> getCursos(){
		List<CursoView> resultado = new ArrayList<CursoView>();
		for(Curso c : cursos)
			resultado.add(c.toView());
		return resultado;
	} 
	
	public List<MateriaView> getMaterias(){
		List<MateriaView> resultado = new ArrayList<MateriaView>();
		for(Materia m : materias)
			resultado.add(m.toView());
		return resultado;
	}
	
	public List<ProfesorView> getProfesores(){
		List<ProfesorView> resultado = new ArrayList<ProfesorView>();
		for(Profesor p : profesores)
		{
			resultado.add(p.toView());
		}
		return resultado;
	}
	
	private Alumno buscarAlumno(int legajo){
		for(Alumno a : alumnos)
			if(a.soyELAlumno(legajo))
				return a;
		return null;			
	}
	
	private boolean isAlumnoPorNombre(String nombre){
		for(Alumno a : alumnos)
			if(a.soyELAlumno(nombre))
				return true;
		return false;
	}
	
	private Curso buscarCurso(int numero){
		for(Curso c : cursos)
			if(c.soyElCurso(numero))
				return c;
		return null;			
	}
	
	private Materia buscarMateria(String codigo){
		for(Materia m : materias)
			if(m.soyLaMateria(codigo))
				return m;
		return null;
	}
	
	private Profesor buscarProfesor(int legajo){
		for(Profesor p : profesores)
			if(p.soyElProfesor(legajo))
				return p;
		return null;
	}
	
	private void cargoMaterias(){
		Materia m = new Materia("M001", "Materia I");
		materias.add(m);
		m = new Materia("M002", "Materia II");
		materias.add(m);
		m = new Materia("M003", "Materia III");
		materias.add(m);
		m = new Materia("M004", "Materia IV");
		materias.add(m);
		m = new Materia("M005", "Materia V");
		materias.add(m);
		m = new Materia("M006", "Materia VI");
		materias.add(m);
		m = new Materia("M007", "Materia VII");
		materias.add(m);
		m = new Materia("M008", "Materia VII");
		materias.add(m);
		m = new Materia("M009", "Materia IX");
		materias.add(m);
		m = new Materia("M010", "Materia X");
		materias.add(m);
	}
	
	private void cargoAlumnos(){
		Alumno a = new Alumno("Alumno I");
		alumnos.add(a);
		a = new Alumno("Alumno II");
		alumnos.add(a);
		a = new Alumno("Alumno III");
		alumnos.add(a);
		a = new Alumno("Alumno IV");
		alumnos.add(a);
		a = new Alumno("Alumno V");
		alumnos.add(a);
		a = new Alumno("Alumno VI");
		alumnos.add(a);
		a = new Alumno("Alumno VII");
		alumnos.add(a);
		a = new Alumno("Alumno VIII");
		alumnos.add(a);
		a = new Alumno("Alumno IX");
		alumnos.add(a);
		a = new Alumno("Alumno X");
		alumnos.add(a);
		a = new Alumno("Alumno XI");
		alumnos.add(a);
		a = new Alumno("Alumno XII");
		alumnos.add(a);
		a = new Alumno("Alumno XIII");
		alumnos.add(a);
		a = new Alumno("Alumno XIV");
		alumnos.add(a);
		a = new Alumno("Alumno XV");
		alumnos.add(a);
	}
	
	private void cargoProfesores(){
		Profesor p = new Profesor(1, "Profesor I", "Calle I", 101, "CP CI", "Localidad I");
		profesores.add(p);
		p = new Profesor(2, "Profesor II", "Calle II", 102, "CP CII", "Localidad II");
		profesores.add(p);
		p = new Profesor(3, "Profesor III", "Calle III", 103, "CP CIII", "Localidad III");
		profesores.add(p);
		p = new Profesor(4, "Profesor IV", "Calle IV", 104, "CP CIV", "Localidad IV");
		profesores.add(p);
		p = new Profesor(5, "Profesor V", "Calle V", 105, "CP CV", "Localidad V");
		profesores.add(p);
		p = new Profesor(6, "Profesor VI", "Calle VI", 106, "CP CVI", "Localidad VI");
		profesores.add(p);
		p = new Profesor(7, "Profesor VII", "Calle VII", 107, "CP CVII", "Localidad VII");
		profesores.add(p);
		p = new Profesor(8, "Profesor VIII", "Calle VIII", 108, "CP CVIII", "Localidad VIII");
		profesores.add(p);
		p = new Profesor(9, "Profesor IX", "Calle IX", 109, "CP CIX", "Localidad IX");
		profesores.add(p);
		p = new Profesor(10, "Profesor X", "Calle X", 110, "CP CX", "Localidad X");
		profesores.add(p);
	}
	
	private void cargoCursos(){
		this.crearCurso("M002", 2, "Lunes", "Mañana", 10);
		this.crearCurso("M004", 3, "Martes", "Mañana", 15);
		this.crearCurso("M001", 1, "Martes", "Tarde", 20);
		this.crearCurso("M001", 1, "Jueves", "Mañana", 15);
		this.crearCurso("M010", 3, "Viernes", "Noche", 15);
	}
}
