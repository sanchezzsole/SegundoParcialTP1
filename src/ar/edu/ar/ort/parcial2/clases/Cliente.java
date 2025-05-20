package ar.edu.ar.ort.parcial2.clases;

public class Cliente {
    private int dni;
    private String nombre;

    public Cliente(int dni, String nombre) {
        setDni(dni);
        setNombre(nombre);
    }

    public int getDni() {
        return dni;
    }

    private void setDni(int dni) {
        if (dni <= 0) {
            throw new IllegalArgumentException("El DNI no puede ser negativo.");
        }
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
    }

    public void mostrar() {
        System.out.printf("Cliente -- DNI: %d, Nombre: %s%n", dni, nombre);
    }

    public int compareTo(Cliente otroCliente) {
        return Integer.compare(this.dni, otroCliente.getDni());
    }
}

