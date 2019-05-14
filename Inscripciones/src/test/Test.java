package test;

import controlador.ControladorInscripciones;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("Alumnos:\n");
		for(Object o : ControladorInscripciones.getInstancia().getAlumnos())
			System.out.println(o.toString());
		
		System.out.println("\nCursos:\n");
		for(Object o : ControladorInscripciones.getInstancia().getCursos())
			System.out.println(o.toString());
		
		System.out.println("\nMaterias:\n");
		for(Object o : ControladorInscripciones.getInstancia().getMaterias())
			System.out.println(o.toString());
		
		System.out.println("\nProfesores:\n");
		for(Object o : ControladorInscripciones.getInstancia().getProfesores())
			System.out.println(o.toString());
	}
}
