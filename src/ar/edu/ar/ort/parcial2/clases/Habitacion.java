package ar.edu.ar.ort.parcial2.clases;

public abstract class Habitacion implements Tarifable {
	
	private static final String MSG_TARIFA_INVALIDO = "La tarifa por noche debe ser mayor a 0.";
	private static final String MSG_CAPACIDAD_INVALIDO = "La capacidad debe ser mayor a 0.";
	private static final String MSG_ESTADO_INVALIDO = "Estado inválido.";
	private static final String MSG_ID_INVALIDO = "El ID no puede ser negativo.";
	
	private static final String FORMATO_HABITACION = "Habitación -- ID: %d | Estado: %s | Capacidad: %d | Tarifa por Noche: %.2f";
	private static final int ID_MINIMO = 0;
	private static final int CAPACIDAD_MINIMA = 0;
	private static final float TARIFA_MINIMA_POR_NOCHE = 0;

	private int id;
	private EstadoHabitacion estado;
	private int capacidad;
	private float tarifaPorNoche;
	private int ubicacion;
	
	
    public Habitacion(int id, EstadoHabitacion estado, int capacidad, float tarifaPorNoche, int ubicacion) {
    	setid(id);
    	setEstado(estado);
    	setCapacidad(capacidad);
    	setTarifaPorNoche(tarifaPorNoche);
    	this.ubicacion = ubicacion;
    }


    private void setid(int id) {
		if(id < ID_MINIMO) {
			throw new IllegalArgumentException(MSG_ID_INVALIDO);
		}
		this.id = id;
	}

	private void setEstado(EstadoHabitacion estado) {
		if(estado != EstadoHabitacion.LIBRE && estado != EstadoHabitacion.MANTENIMIENTO && estado != EstadoHabitacion.RESERVADA) {
			throw new IllegalArgumentException(MSG_ESTADO_INVALIDO);
		}
		this.estado = estado;
	}


	private void setCapacidad(int capacidad) {
		if(capacidad <= CAPACIDAD_MINIMA) {
			throw new IllegalArgumentException(MSG_CAPACIDAD_INVALIDO);
		}
		this.capacidad = capacidad;
	}


	private void setTarifaPorNoche(float tarifaPorNoche) {
		if(tarifaPorNoche <= TARIFA_MINIMA_POR_NOCHE) {
			throw new IllegalArgumentException(MSG_TARIFA_INVALIDO);
		}
		this.tarifaPorNoche = tarifaPorNoche;
	}


	public void mostrar() {
    	// COMPLETAR
    }


	public float getTarifaPorNoche() {
		return this.tarifaPorNoche;
	}


	public int getId() {
		return this.id;
	}


	public boolean esElEstado(EstadoHabitacion e) {
		return this.estado == e;
	}
	
	public void solicitarCambioEstado(EstadoHabitacion e) {
		setEstado(e);
	}
}
