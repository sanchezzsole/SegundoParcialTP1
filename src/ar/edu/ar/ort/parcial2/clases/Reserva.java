package ar.edu.ar.ort.parcial2.clases;

public class Reserva implements Tarifable {
	
	private static final String MSG_CLIENTE_INVALIDO = "El cliente no puede ser nulo.";
	private static final String MSG_FECHA_INVALIADA = "La fecha de inicio no puede ser nula o vacía.";
	private static final String MSG_NOCHE_INVALIADA = "La cantidad de noches debe ser mayor a 0.";

	private static final String FORMATO_RESERVA = "[Reserva] Cliente DNI: %d | %s | Habitación ID: %d | Fecha Inicio: %s | Noches: %d | Costo Total: %.2f \n";

    private Cliente cliente;
    private Habitacion habitacion;
    private String fechaInicio;
    private int noches;

    public Reserva(Cliente cliente, Habitacion habitacion, String fechaInicio, int noches) {
        setCliente(cliente);
        setHabitacion(habitacion);
        setFechaInicio(fechaInicio);
        setNoches(noches);
    }

    public Cliente getCliente() {
        return cliente;
    }

    private void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException(MSG_CLIENTE_INVALIDO);
        }
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        if (habitacion == null) {
            throw new IllegalArgumentException("La habitación no puede ser nula.");
        }
        this.habitacion = habitacion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    private void setFechaInicio(String fechaInicio) {
        if (fechaInicio == null || fechaInicio.isEmpty()) {
            throw new IllegalArgumentException(MSG_FECHA_INVALIADA);
        }
        this.fechaInicio = fechaInicio;
    }

    public int getNoches() {
        return noches;
    }

    private void setNoches(int noches) {
        if (noches <= 0) {
            throw new IllegalArgumentException(MSG_NOCHE_INVALIADA);
        }
        this.noches = noches;
    }

    @Override
    public float calcularTarifa() {
        return habitacion.getTarifaPorNoche() * noches;
    }
    
    public void mostrar() {
        System.out.printf(FORMATO_RESERVA, cliente.getDni(), habitacion.getClass().getSimpleName(), habitacion.getId(), fechaInicio, noches, calcularTarifa());
    }
}
