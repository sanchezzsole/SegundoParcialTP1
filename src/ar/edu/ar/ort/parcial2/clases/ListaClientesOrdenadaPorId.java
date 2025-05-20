package ar.edu.ar.ort.parcial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaClientesOrdenadaPorId extends ListaOrdenadaNodos<Integer, Cliente> {

    @Override
    public int compare(Cliente cliente1, Cliente cliente2) {
        return cliente1.compareTo(cliente2);
    }

    @Override
    public int compareByKey(Integer key, Cliente cliente) {
        return Integer.compare(key, cliente.getDni());
    }
}