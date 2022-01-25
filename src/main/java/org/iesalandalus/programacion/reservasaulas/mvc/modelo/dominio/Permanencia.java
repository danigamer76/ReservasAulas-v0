package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Permanencia {
	private LocalDate dia;
	private Tramo tramo;
	private static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("d/MM/yyyy");
	public Permanencia(LocalDate dia,Tramo tramo) {
		setDia(dia);
		setTramo(tramo);
	}
	
	public Permanencia(Permanencia permanencia) {
		if(permanencia == null) {
			throw new IllegalArgumentException("ERROR:CAMPO DIA VACIO");
		}
		this.dia = permanencia.getDia();
		this.tramo = permanencia.getTramo();
	}
	
	public LocalDate getDia() {
		return dia;
	}
	
	public void setDia(LocalDate dia) {
		if(dia == null) {
			throw new IllegalArgumentException("ERROR:CAMPO DIA VACIO");
		}else {
			this.dia = dia;
		}
	}
	
	public Tramo getTramo() {
		return tramo;
	}
	
	public void setTramo(Tramo tramo) {
		if(tramo == null) {
			throw new IllegalArgumentException("ERROR:CAMPO TRAMO VACIO");
		}else {
			this.tramo = tramo;		
			}
	}

	@Override
	public int hashCode() {
		return Objects.hash(dia, tramo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permanencia other = (Permanencia) obj;
		return Objects.equals(dia, other.dia) && tramo == other.tramo;
	}

	@Override
	public String toString() {
		return "Permanencia [DIA=" + FORMATO_DIA.format(dia) + ", TRAMO=" + tramo + "]";
	}
	
	
	
	
	
}
