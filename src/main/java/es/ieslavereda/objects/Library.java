package es.ieslavereda.objects;

import es.ieslavereda.TAD.ClienteTAD;
import es.ieslavereda.TAD.PublicacionTAD;

public class Library {
    private PublicacionTAD libros;
    private PublicacionTAD revistas;

    private PublicacionTAD periodicos;

    private ClienteTAD clientes;

    public Library(){
        libros = new PublicacionTAD();
        revistas = new PublicacionTAD();
        periodicos = new PublicacionTAD();
        clientes = new ClienteTAD();
    }

    public void altaCliente(Cliente cliente){
        clientes.altaCliente(cliente);
    }

    public boolean altaPublicacion(Publicacion publicacion){
        if (publicacion instanceof Libro){
            libros.addHead(publicacion);
            return true;
        }
        if (publicacion instanceof Periodico){
            periodicos.addHead(publicacion);
            return true;
        }
        if (publicacion instanceof Revista){
            revistas.addHead(publicacion);
            return true;
        }
        return false;
    }

    public boolean bajaPublicacion(Publicacion publicacion){
        if (publicacion instanceof Libro){
            return libros.bajaPublicacion(publicacion);

        }
        if (publicacion instanceof Periodico){
            return periodicos.bajaPublicacion(publicacion);

        }
        if (publicacion instanceof Revista){
            return revistas.bajaPublicacion(publicacion);
        }
        return false;
    }

    public ClienteTAD getClientes() {
        return clientes;
    }

    public PublicacionTAD getLibros() {
        return libros;
    }

    public PublicacionTAD getPeriodicos() {
        return periodicos;
    }

    public PublicacionTAD getRevistas() {
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
