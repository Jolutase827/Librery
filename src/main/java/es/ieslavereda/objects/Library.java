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
            return cliente.darAlta();
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
            return cliente.darBaja();
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
        if (libros.contains(passISBNtoLibro(isbn))&&i>-1) {
            Libro libro = getLibro(isbn);
            libro.addEjemplares(i);
            return true;
        }
        return false;
    }



    public boolean prestamoLibro(String isbn, int codigoEjemplar, Cliente cliente){
        if (cliente.aptoParaPedirLibro()&&clientes.contains(cliente)){
            if (existeLibro(isbn)){
                Libro libro = getLibro(isbn);
                if (libro.existeEjemplar(codigoEjemplar)){
                    Ejemplar ejemplar = libro.getEjemplar(codigoEjemplar);
                    if (cliente.aptoParaPedirLibro()&&ejemplar.notPrestado()) {
                         cliente.prestar(ejemplar);
                         ejemplar.addPrestamo(cliente);
                         return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public boolean devolverLibro(String isbn, int codigoEjemplar, Cliente cliente){
        if (existeEjemplar(isbn,codigoEjemplar)){
            Ejemplar ejemplar = getLibro(isbn).getEjemplar(codigoEjemplar);
            if (cliente.hasEjemplar(ejemplar)&&!ejemplar.notPrestado()){
                cliente.devolver(ejemplar);
                ejemplar.devolver(cliente);
                return true;
            }
        }
        return false;
    }

    public boolean modificarDatosCliente(Cliente c1, String dniNuevo, String nombre){
        if (clientes.contains(c1)){
            clientes.get(clientes.getposition(c1)).setDni(dniNuevo);
            clientes.get(clientes.getposition(c1)).setNombre(nombre);
            return true;
        }
        return false;
    }


    public boolean existeEjemplar(String isbn, int codigoEjemplar){
        if (existeLibro(isbn)){
            return getLibro(isbn).existeEjemplar(codigoEjemplar);
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
    public Cliente getCliente(String dni){
        return clientes.get(clientes.getposition(new Cliente("",dni)));
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
