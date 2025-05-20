package ar.edu.ar.ort.parcial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;

public class Hotel {
    private static final String MSG_RESERVA_ADICIONAL = "La reserva sin servicio adicional solo está permitida para Suite y Suite Presidencial.";
	private static final String MSG_SIN_HABITACION_DISPONIBLE = "No hay habitaciones disponibles del tipo solicitado.";
	private static final String MSG_CLIENTE_NO_ENCONTRADO = "Cliente no encontrado.";
    
	private static final int PISO_PRESIDENCIAL = 2;
	private static final int PISO_SUITE = 1;
	private static final int PISO_ESTANDAR = 0;
	
	private static final String FORMATO_SALIDA = "Reservas por Tipo de Habitación:%nEstándar: %d%nSuite: %d%nSuite Presidencial: %d%n";
	
	private static final int PISOS = 3;
    private static final int HABITACIONES_POR_PISO = 5;
    
    private Habitacion[][] habitaciones;
    private ListaClientesOrdenadaPorId clientes;
    private PilaNodos<Reserva> reservas;
    private int[] contadorReservPorHab;
 
    public Hotel() {
    	this.habitaciones = new Habitacion[PISOS][HABITACIONES_POR_PISO];
        inicializarHabitaciones();
        this.clientes = new ListaClientesOrdenadaPorId();
        this.reservas = new PilaNodos<Reserva>();
        this.contadorReservPorHab = new int[PISOS];
    }

    private void inicializarHabitaciones() {
        int id = 1;

        int pisoEstandar = determinarPisoPorTipoHabitacion("Estándar");
        for (int i = 0; i < HABITACIONES_POR_PISO; i++) {
        	habitaciones[pisoEstandar][i] = new Estandar(id++, EstadoHabitacion.LIBRE);
        }

        // Asignar habitaciones Suite
        int pisoSuite = determinarPisoPorTipoHabitacion("Suite");
        for (int i = 0; i < HABITACIONES_POR_PISO; i++) {
        	habitaciones[pisoSuite][i] = new SuiteComun(id++, EstadoHabitacion.LIBRE, ServicioAdicional.DESAYUNO);
            // COMPLETAR: Asumiendo desayuno incluido por defecto
        }

        // Asignar habitaciones Suite Presidencial
        int pisoSuitePresidencial = determinarPisoPorTipoHabitacion("Suite Presidencial");
        for (int i = 0; i < HABITACIONES_POR_PISO; i++) {
           	habitaciones[pisoSuitePresidencial][i] = new SuitePresidencial(id++, EstadoHabitacion.LIBRE, ServicioAdicional.DESAYUNO, 2);
        }
    }

    public void agregarCliente(Cliente cliente) {
    	if(cliente != null) {
    		this.clientes.add(cliente);
    	}
    }

    public void procesarReserva(int clienteDni, String tipoHabitacion, String fechaInicio, int noches) throws IllegalArgumentException {   
    	procesarReserva(clienteDni, tipoHabitacion, fechaInicio, noches, null);
    }

    public void procesarReserva(int clienteDni, String tipoHabitacion, String fechaInicio, int noches, ServicioAdicional servicioAdicional) throws IllegalArgumentException {
    	Cliente cliente = buscarClientePorDni(clienteDni);
    	Habitacion hab = buscarHabitacionDisponible(tipoHabitacion, servicioAdicional);
    	if(cliente == null) {
    		throw new IllegalArgumentException(MSG_CLIENTE_NO_ENCONTRADO);
    	} 
    	
    	if(hab == null) {
    		throw new RuntimeException(MSG_SIN_HABITACION_DISPONIBLE);
    	}
    	
    	this.reservas.push(new Reserva(cliente, hab, fechaInicio, noches));
    	hab.solicitarCambioEstado(EstadoHabitacion.RESERVADA);
    	actualizarReservasPorTipoHabitacion(tipoHabitacion);
        System.out.println("Reserva realizada con éxito para el cliente DNI: " + clienteDni + " con servicio adicional: " + servicioAdicional);
    }

    private void actualizarReservasPorTipoHabitacion(String habitacion) {
    	int piso = determinarPisoPorTipoHabitacion(habitacion);
    	contadorReservPorHab[piso]++;
    	
    }

    private Cliente buscarClientePorDni(int dni) {
    	Cliente encontrado = null;
    	encontrado = clientes.search(dni);
		return encontrado;
    }

    private Habitacion buscarHabitacionDisponible(String tipoHabitacion, ServicioAdicional servicioAdicional) {
    	Habitacion habDisponible = null;
    	int piso = determinarPisoPorTipoHabitacion(tipoHabitacion);
    	int pos = 0;
    	
    	while(habDisponible == null && pos < HABITACIONES_POR_PISO) {
    		if(habitaciones[piso][pos].esElEstado(EstadoHabitacion.LIBRE)) {
    			habDisponible = habitaciones[piso][pos];
    			if(piso == PISO_SUITE || piso == PISO_PRESIDENCIAL) {
    				 Suite suite = (Suite) habDisponible; 
    				 suite.agregarServicio(servicioAdicional);
    			}
    		}
    		pos++;
    	}
		return habDisponible;
    }


	private int determinarPisoPorTipoHabitacion(String tipoHabitacion) {
        switch (tipoHabitacion) {
            case "Estándar":
                return PISO_ESTANDAR;
            case "Suite":
                return PISO_SUITE;
            case "Suite Presidencial":
                return PISO_PRESIDENCIAL;
            default:
                return -1; // Tipo de habitación inválido
        }
    }

    public void mostrarHistorialReservas() {
    	System.out.println("Histrial de reservas:");
		PilaNodos<Reserva> aux = new PilaNodos<>();
		Reserva actual;
		while(!reservas.isEmpty()) {
			actual = reservas.pop();
			actual.mostrar();
			aux.push(actual);
		}
		while(!aux.isEmpty()) {
			reservas.push(aux.pop());
		}
    }

    public void mostrarReservasPorTipoHabitacion() {    	
    	System.out.printf(FORMATO_SALIDA, contadorReservPorHab[0], contadorReservPorHab[1], contadorReservPorHab[2]);
    	
    }
}
