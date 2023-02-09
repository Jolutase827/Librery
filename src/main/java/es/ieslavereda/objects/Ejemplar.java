package es.ieslavereda.objects;

import es.ieslavereda.TAD.ListaSimplementeEnlazada;

public class Ejemplar {

    private ListaSimplementeEnlazada<Prestamo<Cliente>> listaPrestamos;
    private Libro libro;
    private int codigoEjemplar;


    public Ejemplar(Libro libro, int codigoEjemplar){
        this.libro = libro;
        this.listaPrestamos = new ListaSimplementeEnlazada<>();
        this.codigoEjemplar = codigoEjemplar;
    }

    public boolean notPrestado(){
        if (listaPrestamos.getSize()>0) {
            return listaPrestamos.get(0).isDevolution();
        }
        return false;
    }

    public boolean addPrestamo(Cliente cliente){
        if (notPrestado()&&cliente.aptoParaPedirLibro()){
            listaPrestamos.addHead(new Prestamo<Cliente>(cliente, listaPrestamos.getSize()+1));
            return true;
        }
        return false;
    }



    public Libro getLibro() {
        return libro;
    }

    public int getCodigoEjemplar() {
        return codigoEjemplar;
    }

    @Override
    public String toString(){
        return "Ejemplar{ \n ISBN: " + libro.getIsbn() +"\n Codigo de Ejemplar: " +codigoEjemplar+"+\n Lista de Prestamos Clientes: "+ listaPrestamos+ "}\n";
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Ejemplar){
            Ejemplar ej = (Ejemplar) obj;
            return ej.libro.equals(this.libro)&&ej.codigoEjemplar==this.codigoEjemplar;
        }
        return false;
    }
}
