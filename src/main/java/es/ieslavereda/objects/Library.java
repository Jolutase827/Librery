package es.ieslavereda.objects;

import es.ieslavereda.TAD.ClienteTAD;
import es.ieslavereda.TAD.PublicacionTAD;

public class Library {
    private PublicacionTAD libros;
    private PublicacionTAD revistas;

    private PublicacionTAD periodico;

    private ClienteTAD clientes;

    public Library(){
        libros = new PublicacionTAD();
        revistas = new PublicacionTAD();
        periodico = new PublicacionTAD();
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
            periodico.addHead(publicacion);
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
            return periodico.bajaPublicacion(publicacion);

        }
        if (publicacion instanceof Revista){
            return revistas.bajaPublicacion(publicacion);
        }
        return false;
    }
}
