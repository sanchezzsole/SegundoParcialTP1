package ar.edu.ar.ort.parcial2.clases;

public abstract class Suite extends Habitacion {

	private ServicioAdicional servAdicional;
	
	
	public Suite(int id, EstadoHabitacion estado, int capacidad, float tarifaPorNoche, int ubicacion,
			ServicioAdicional servAdicional) {
		super(id, estado, capacidad, tarifaPorNoche, ubicacion);
		this.servAdicional = servAdicional;
	}


	@Override
	public float calcularTarifa() {
		//Para estas habitaciones la tarifa es igual a la base multiplicado al costo extra del servicio adicional
		return getTarifaPorNoche() * servAdicional.getCostoExtra();
	}

	private void setServicio(ServicioAdicional s) {
		servAdicional = s;
	}
	
	public void agregarServicio(ServicioAdicional s) {
		setServicio(s);
	}
}
