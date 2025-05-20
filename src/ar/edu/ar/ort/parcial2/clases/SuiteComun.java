package ar.edu.ar.ort.parcial2.clases;

public class SuiteComun extends Suite {

	private static final float TARIFA_BASE = 150;
	private static final int CAPACIDAD = 4;
	private static final int PISO_SUITE = 1;
	
	public SuiteComun(int id, EstadoHabitacion estado, ServicioAdicional servAdicional) {
		super(id, estado, CAPACIDAD, TARIFA_BASE, PISO_SUITE, servAdicional);
	}
	
	
	
}
