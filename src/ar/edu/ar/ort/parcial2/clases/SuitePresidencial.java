package ar.edu.ar.ort.parcial2.clases;

public class SuitePresidencial extends Suite {

	private static final String MSG_MINIMO_HABITACIONES_INVALIDO = "La tarifa por noche debe ser mayor a 0.";
	private static final float TARIFA_BASE = 320;
	private static final int CAPACIDAD = 6;
	private static final int PISO_PRESIDENCIAL = 2;
	private static final int MIN_HABITACIONES = 0;
	
	private int numDeHabitaciones;

	public SuitePresidencial(int id, EstadoHabitacion estado, ServicioAdicional servAdicional, int numDeHabitaciones) {
		super(id, estado, CAPACIDAD, TARIFA_BASE, PISO_PRESIDENCIAL, servAdicional);
		setNumHabitaciones(numDeHabitaciones);
	}

	private void setNumHabitaciones(int numDeHabitaciones) {
		if(numDeHabitaciones < MIN_HABITACIONES) {
			throw new IllegalArgumentException(MSG_MINIMO_HABITACIONES_INVALIDO);
		}
		this.numDeHabitaciones = numDeHabitaciones;
	}
	
	
}
