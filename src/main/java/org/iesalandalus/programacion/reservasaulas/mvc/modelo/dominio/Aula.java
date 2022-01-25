package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.util.Objects;

public class Aula {
	private String nombre;

	public Aula(String nombre) {
		setNombre(nombre);
	}
	
	public Aula(Aula aula) {
		if(aula == null) {
			throw new IllegalArgumentException("ERROR:CAMPO AULA VACIO");
		}else {
			setNombre(aula.getNombre());
		}
	}

	private void setNombre(String nombre) {
		if(nombre == null || nombre == "") {
			throw new IllegalArgumentException("ERROR:CAMPO NOMBRE VACIO");
		}else {
			this.nombre = nombre;
		}
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Aula [NOMBRE=" + nombre + "]";
	}
	
	
	
}
