package es.ieslavereda.objects;

import es.ieslavereda.TAD.ListaSimplementeEnlazada;

public class Library {
    private ListaSimplementeEnlazada<Libro> libros;
    private ListaSimplementeEnlazada<Revista> revistas;

    private ListaSimplementeEnlazada<Periodico> periodicos;

    private ListaSimplementeEnlazada<Cliente> clientes;

    public Library(){
        libros = new ListaSimplementeEnlazada<>();
        revistas = new ListaSimplementeEnlazada<>();
        periodicos = new ListaSimplementeEnlazada<>();
        clientes = new ListaSimplementeEnlazada<>();
    }

    public boolean altaCliente(Cliente cliente){
        if (clientes.contains(cliente)){
            cliente = clientes.get(clientes.getposition(cliente));
            if (cliente.darAlta()){
                clientes.replace(cliente,clientes.getposition(cliente));
                return true;
            }
           return false;
        }else {
            clientes.addHead(cliente);
            return true;
        }
    }

    public boolean bajaCliente(Cliente cliente){
        if (!clientes.contains(cliente)){
            return false;
        }else {
            int posicionCliente = clientes.getposition(cliente);
            cliente = clientes.get(posicionCliente);
            if (cliente.darBaja()){
                clientes.replace(cliente,posicionCliente);
                return true;
            }
            return false;
        }
    }

    public boolean altaPeriodico(Periodico periodico){
        if (!periodicos.contains(periodico)){
            periodicos.addHead(periodico);
            return true;
        }
        return false;
    }

    public boolean bajaPeriodico(Periodico periodico){
        if (!periodicos.contains(periodico)){
            return false;
        }
        periodicos.remove(periodicos.getposition(periodico));
        return true;
    }

    public boolean altaRevista(Revista revista){
        if (!revistas.contains(revista)){
            revistas.addHead(revista);
            return true;
        }
        return false;
    }

    public boolean bajaRevista(Revista revista){
        if (!revistas.contains(revista)){
            return false;
        }
        revistas.remove(revistas.getposition(revista));
        return true;
    }
    public ListaSimplementeEnlazada<Cliente> getClientes() {
        return clientes;
    }

    public ListaSimplementeEnlazada<Libro> getLibros() {
        return libros;
    }

    public ListaSimplementeEnlazada<Periodico> getPeriodicos() {
        return periodicos;
    }

    public ListaSimplementeEnlazada<Revista> getRevistas() {
        return revistas;
    }

    @Override
    public String toString(){
        return "Libros{ "+ libros+"}\n"+
                "Periodicos{ "+ periodicos + "}\n"+
                "Revistas{ "+revistas +"}\n"+
                "Clientes{ " +clientes+"}";
    }
}
