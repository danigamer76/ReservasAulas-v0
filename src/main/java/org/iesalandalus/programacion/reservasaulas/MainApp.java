package org.iesalandalus.programacion.reservasaulas;

import java.time.LocalDate;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Tramo;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("Programa para la gestión de reservas de espacios del IES Al-Ándalus");
		Permanencia prueba = new Permanencia(LocalDate.now(), Tramo.MANANA);
		System.out.println(prueba.getDia());
		System.out.println(prueba.toString());
		Aula pruebAula = new Aula("casa");
		Aula pruebAula1 = new Aula("casaa");
		System.out.println(pruebAula.equals(pruebAula1));
	}

}
