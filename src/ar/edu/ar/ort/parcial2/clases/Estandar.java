package ar.edu.ar.ort.parcial2.clases;

public class Estandar extends Habitacion {
	
	private static final float TARIFA_BASE = 50;
	private static final int CAPACIDAD = 2;
	private static final int PISO_ESTANDAR = 0;
	
	
	public Estandar(int id, EstadoHabitacion estado) {
		super(id, estado, CAPACIDAD, TARIFA_BASE, PISO_ESTANDAR);
	}


	@Override
	public float calcularTarifa() {
		return getTarifaPorNoche();
	}

}
