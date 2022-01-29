package org.iesalandalus.programacion.reservasaulas.mvc.vista;

public enum Opcion {
	SALIR("Salir") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub

		}
	},
	INSERTAR_AULA("Insertar Aula") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub

		}
	},
	BORRAR_AULA("Borrar Aula") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub

		}
	},
	BUSCAR_AULA("Buscar Aula") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub

		}
	},
	LISTAR_AULAS("Listar Aulas") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub

		}
	},
	INSERTAR_PROFESOR("Insertar Profesor") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub

		}
	},
	BORRAR_PROFESOR("Borrar Profesor") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub

		}
	},
	BUSCAR_PROFESOR("Buscar Profesor") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub

		}
	},
	LISTA_PROFESORES("Lista Profesor") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub

		}
	},
	INSERTAR_RESERVA("Insertar Reserva") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub

		}
	},
	BORRAR_RESERVA("Borrar Reserva") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub

		}
	},
	LISTAR_RESERVAS("Listar Reservas") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub

		}
	},
	LISTAR_RESERVAS_AULA("Listar Reservas Aula") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub

		}
	},
	LISTAR_RESERVAS_PROFESOR("Listar Reservas Profesor") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub

		}
	},
	LISTAR_RESERVAS_PERMANENCIA("Listar Reservas Permanencia") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub

		}
	},
	CONSULTAR_DISPONIBILIDAD("Consultar Disponibilidad") {
		@Override
		public void ejecutar() {
			// TODO Auto-generated method stub

		}
	};

	private String mensajeAMostrar;
	private Vista vista;

	private Opcion(String mensajeAMostrar) {
		this.mensajeAMostrar=mensajeAMostrar;
	}

	public String getMensaje() {
		return mensajeAMostrar;
	}

	public abstract void ejecutar();

	protected static void setVista(Vista vista) {
		Opcion.vista = vista;
	}

	public String toString() {
		return String.format("%d.- %s", ordinal(), mensajeAMostrar);
	}

	public static Opcion getOpcionSegunOrdinal(int ordinal) {
		if (esOrdinalValido(ordinal))
			return values()[ordinal];
		else
			throw new IllegalArgumentException("Ordinal de la opción no válido");
	}

	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1);
	}






}
