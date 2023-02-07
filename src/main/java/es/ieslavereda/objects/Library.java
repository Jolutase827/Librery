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

    public boolean altaLibro(Libro libro){
        if (!libros.contains(libro)){
            libros.addHead(libro);
            return true;
        }
        return false;
    }

    public boolean bajaLibro(Libro libro){
        if (!libros.contains(libro)){
            return false;
        }
        libros.remove(libros.getposition(libro));
        return true;
    }

    public boolean crearEjemplares(String isbn, int i){
        if (libros.contains(passISBNtoLibro(isbn))) {
            Libro libro = getLibro(isbn);
            libro.addEjemplares(i);
            return true;
        }
        return false;
    }



    public boolean prestamoLibro(String isbn, int codigoEjemplar, Cliente cliente){
        if (!cliente.aptoParaPedirLibro()||!clientes.contains(cliente)){
            if (existeLibro(isbn)){
                Libro libro = getLibro(isbn);
                if (libro.existeEjemplar(codigoEjemplar)){
                    Ejemplar ejemplar = libro.getEjemplar(codigoEjemplar);
                    cliente.prestar(ejemplar);
                    ejemplar.addPrestamo(cliente);
                    return true;
                }
            }
        }
        return false;
    }


    public Libro getLibro(String isbn){
        return libros.get(libros.getposition(passISBNtoLibro(isbn)));
    }
    public Libro passISBNtoLibro(String isbn){
        return new Libro("", 0, Publicacion.Color.ACOLOR, "", "", isbn);
    }
    public boolean existeLibro(String isbn){
        return libros.getSize() != 0 && libros.contains(passISBNtoLibro(isbn));

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
