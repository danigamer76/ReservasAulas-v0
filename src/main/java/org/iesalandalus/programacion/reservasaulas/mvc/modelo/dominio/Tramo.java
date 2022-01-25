package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

public enum Tramo {
	MANANA{
		public String toString() {
            return "Mañana";
        }
	}, TARDE{
		public String toString() {
            return "Tarde";
        }
	};
}
