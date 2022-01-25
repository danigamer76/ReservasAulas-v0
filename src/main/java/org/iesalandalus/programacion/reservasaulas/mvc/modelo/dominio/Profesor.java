package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.util.Objects;

public class Profesor {
	private static final String ER_TELEFONO = "[6,9]\\d{8}";
	private static final String ER_CORREO = "([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+";
	private String nombre;
	private String correo;
	private String telefono;
	public Profesor(String nombre, String correo) {
		setNombre(nombre);
		setCorreo(correo);
	}
	public Profesor(String nombre, String correo, String telefono) {
		if(telefono == null) {
			setNombre(nombre);
			setCorreo(correo);
		}else {
			setNombre(nombre);
			setCorreo(correo);
			setTelefono(telefono);
		}
	}
	public Profesor(Profesor profesor) {
		if(profesor == null) {
			throw new IllegalArgumentException("No se puede copiar un profesor nulo.");
		}else {
			if(profesor.getTelefono() == null) {
				setNombre(profesor.getNombre());
				setCorreo(profesor.getCorreo());
			}else {
				setNombre(profesor.getNombre());
				setCorreo(profesor.getCorreo());
				setTelefono(profesor.getTelefono());
			}
			
		}

	}
	private void setNombre(String nombre) {
		if(nombre == null) {
			throw new IllegalArgumentException("El nombre del profesor no puede ser nulo.");
		}else {
			if(nombre == "") {
				throw new IllegalArgumentException("El nombre del profesor no puede estar vacío.");
			}else {
				this.nombre = nombre;
			}
		}

	}
	public void setCorreo(String correo) {
		if(correo == null) {
			throw new IllegalArgumentException("El correo del profesor no puede ser nulo.");
		}else {
			if(correo.matches(ER_CORREO) == false) {
				throw new IllegalArgumentException("El correo del profesor no es válido.");
			}else {
				this.correo = correo;
			}

		}

	}
	public void setTelefono(String telefono) {
			if(telefono.matches(ER_TELEFONO) == false) {
				throw new IllegalArgumentException("El teléfono del profesor no es válido.");
			}else {
				this.telefono = telefono;
			}
	}
	public String getNombre() {
		return nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public String getTelefono() {
		return telefono;
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
		Profesor other = (Profesor) obj;
		return Objects.equals(nombre, other.nombre);
	}
	@Override
	public String toString() {
		if(this.telefono == null) {
			return "[nombre=" + nombre + ", correo=" + correo + "]";
		}else {
			return "[nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + "]";
		}
		
	}



}
