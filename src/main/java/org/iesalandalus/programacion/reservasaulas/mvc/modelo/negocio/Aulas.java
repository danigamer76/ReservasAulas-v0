package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio;

import java.util.Arrays;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;

public class Aulas {

	private int capacidad;
	private int tamano;
	Aula coleccionAulas[];

	public Aulas(int tamano) {
		if(tamano <= 0) {
			throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
		}
		this.coleccionAulas = new Aula[tamano];
	}

	public Aula[] get() {
		return copiaProfundaAulas();

	}

	private Aula[] copiaProfundaAulas() {
		Aula[] copiaAulas = new Aula[coleccionAulas.length];
		for (int i = 0; i < coleccionAulas.length; i++) {
			copiaAulas[i] = coleccionAulas[i];
		}
		return copiaAulas;
	}

	public int getTamano() {
		tamano = 0;
		for (int i = 0; i < coleccionAulas.length; i++) {
			if(coleccionAulas[i] != null) {
				tamano++;
			}
		}
		return tamano;
	}

	public int getCapacidad() {
		return coleccionAulas.length;
	}

	public void insertar(Aula aula) throws OperationNotSupportedException{
		if(aula == null) {
			throw new NullPointerException("ERROR: No se puede insertar un aula nula.");
		}else {
			if(tamanoSuperado(getTamano()) == true) {
				throw new OperationNotSupportedException("ERROR: No se aceptan más aulas.");
			}else {
				if(buscarIndice(aula) != -1) {
					throw new OperationNotSupportedException("ERROR: Ya existe un aula con ese nombre.");
				}else {
					coleccionAulas[getTamano()] = new Aula(aula);
				}
			}

		}

	}

	private int buscarIndice(Aula aula) {
		return Arrays.asList(coleccionAulas).indexOf(aula);

	}

	private boolean tamanoSuperado(int tamano) {
		if(tamano == getCapacidad()) {
			return true;
		}else {
			return false;
		}

	}

	private boolean capacidadSuperada(int capacidad) {
		if(capacidad > this.capacidad) {
			return true;
		}else {
			return false;
		}

	}

	public Aula buscar(Aula aula) {
		if(aula == null) {
			throw new IllegalArgumentException("ERROR: No se puede buscar un aula nula.");
		}else {
			if(buscarIndice(aula) == -1) {
				return null;
			}else {
				return coleccionAulas[buscarIndice(aula)];
			}
		}


	}

	public void borrar(Aula aula) throws OperationNotSupportedException {
		if(aula == null) {
			throw new IllegalArgumentException("ERROR: No se puede borrar un aula nula.");
		}else {
			if(buscarIndice(aula) == -1) {
				throw new OperationNotSupportedException("ERROR: No existe ningún aula con ese nombre.");
			}else {
				desplazarUnaPosicionHaciaIzquierda(buscarIndice(aula));
			}
		}
	}

	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < getTamano(); i++) {
			coleccionAulas[i] = coleccionAulas[i+1];
		}
		coleccionAulas[getTamano()] = null;
	}

	public String[] representar() {
		String[] representacion = new String[getTamano()];
		for (int i = 0; i < getTamano(); i++) {
			representacion[i] = coleccionAulas[i].toString();
		}
		return representacion;
	}




}
