package org.iesalandalus.programacion.reservasaulas.mvc.vista;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.controlador.Controlador;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;

public class Vista {

	private static final String ERROR = "";
	private static final String NOMBRE_VALIDO = "";
	private static final String CORREO_VALIDO = "";

	private Controlador controlador;

	public Vista() {
		Opcion.setVista(this);
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void comenzar() {
		Consola.mostrarCabecera("Programa para la gestión de clientes");
		int ordinalOpcion;
		do {
			Consola.mostrarMenu();
			ordinalOpcion = Consola.elegirOpcion();
			Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
			opcion.ejecutar();
		} while (ordinalOpcion != Opcion.SALIR.ordinal());
	}

	public void salir() {
//		controlador.terminar();
		System.out.println("Adios");
	}

	//AULAS//

	public void insertarAula() {
		Consola.mostrarCabecera("Insertar Aula");
		try {
			Aula aula = Consola.leerAula();
			controlador.insertarAula(aula);
			System.out.println("Aula insertada correctamente");
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void borrarAula() {
		Consola.mostrarCabecera("Borrar Aula");
		try {
			Aula aula = Consola.leerAula();
			controlador.borrarAula(aula);
			System.out.println("Aula borrada correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void buscarAula() {
		Consola.mostrarCabecera("Buscar Aula");
		Aula aula = null;
		try {
			aula = Consola.leerAula();
			aula = controlador.buscarAula(aula);
			if (aula != null) {
				System.out.println("El Aula buscada es: " + aula);
			} else {
				System.out.println("No existe ningún Aula");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void listarAulas() {
		Consola.mostrarCabecera("Listar Aulas");
		String[] aulas = controlador.representarAulas();
		if (aulas.length != 0) {
			for (String aula : aulas) {
				System.out.println(aula);
			}
		} else {
			System.out.println("No hay aulas que listar.");
		}
	}

	//PROFESORES//

	public void insertarProfesor() {
		Consola.mostrarCabecera("Insertar Profesor");
		try {
			Profesor profesor = Consola.leerProfesor();
			controlador.insertarProfesor(profesor);
			System.out.println("Profesor insertado correctamente");
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void borrarProfesor() {
		Consola.mostrarCabecera("Borrar Profesor");
		try {
			Profesor profesor = Consola.leerProfesor();
			controlador.borrarProfesor(profesor);
			System.out.println("Profesor borrado correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void buscarProfesor() {
		Profesor profesor = null;
		Consola.mostrarCabecera("Buscar Profesor");
		try {
			profesor = Consola.leerProfesor();
			profesor = controlador.buscarProfesor(profesor);
			if (profesor != null) {
				System.out.println("El profesor buscado es: " + profesor);
			} else {
				System.out.println("No existe ningún profesor");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void listarProfesores() {
		Consola.mostrarCabecera("Listar Profesores");
		String[] profesores = controlador.representarProfesores();
		if (profesores.length != 0) {
			for (String profesor : profesores) {
				System.out.println(profesor);
			}
		} else {
			System.out.println("No hay profesores que listar.");
		}
	}

	public void realizarReserva() {
		Consola.mostrarCabecera("Realizar Reserva");
		try {
			Profesor profesor = Consola.leerProfesor();
			Reserva reserva = leerReserva(profesor);
			controlador.realizarReserva(reserva);
			System.out.println("Reserva realizada correctamente");
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	private Reserva leerReserva(Profesor profesor) {
		Consola.mostrarCabecera("Leer Reserva");
			Aula aula = Consola.leerAula();
			Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		return new Reserva(profesor, aula, permanencia);
	}

	public void anularReserva() {
		Consola.mostrarCabecera("Anular Reserva");
		try {
			Profesor profesor = Consola.leerProfesor();
			Reserva reserva = leerReserva(profesor);
			controlador.anularReserva(reserva);
			System.out.println("Reserva anulada correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void listarReservas() {
		Consola.mostrarCabecera("Listar Reservas");
		String[] reservas = controlador.representarReservas();
		if (reservas.length != 0) {
			for (String reserva : reservas) {
				System.out.println(reserva);
			}
		} else {
			System.out.println("No hay reservas que listar.");
		}
	}

	public void listarReservasAula() {
		Consola.mostrarCabecera("Listar Reservas Aula");
		Aula aula = Consola.leerAula();
		Reserva[] reservasAula = controlador.getReservasAula(aula);
		if (reservasAula.length != 0) {
			for (Reserva reservaAula : reservasAula) {
				System.out.println(reservaAula);
			}
		} else {
			System.out.println("Nadia ha reservado la aula "+aula.getNombre()+".");
		}
	}

	public void listarReservasProfesor() {
		Consola.mostrarCabecera("Listar Reservas Profesor");
		Profesor profesor = Consola.leerProfesor();
		Reserva[] reservasProfesor = controlador.getReservasProfesor(profesor);
		if (reservasProfesor.length != 0) {
			for (Reserva reservaProfesor : reservasProfesor) {
				System.out.println(reservaProfesor);
			}
		} else {
			System.out.println(profesor.getNombre()+" no tiene ninguna reserva a su nombre.");
		}
	}

	public void listarReservasPermanencia() {
		Consola.mostrarCabecera("Listar Reservas Permanencia");
		Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		Reserva[] reservasPermanencia = controlador.getReservasPermanencia(permanencia);
		if (reservasPermanencia.length != 0) {
			for (Reserva reservaPermanencia : reservasPermanencia) {
				System.out.println(reservaPermanencia);
			}
		} else {
			System.out.println(permanencia.getDia()+": no hay ninguna reserva.");
		}
	}

	public void consultarDisponibilidad() {
		Consola.mostrarCabecera("Consultar Disponibilidad");
		Aula aula = Consola.leerAula();
		Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		if(controlador.consultarDisponibilidad(aula,permanencia)) {
			System.out.println(aula + " se encuentra disponible el dia "+permanencia.getDia()+".");
		}else {
			System.out.println(aula + " no se encuentra disponible el dia "+permanencia.getDia()+".");
		}
		
	}
	
}
