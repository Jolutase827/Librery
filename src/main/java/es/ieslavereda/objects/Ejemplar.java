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
        return true;
    }

    public void addPrestamo(Cliente cliente){
        listaPrestamos.addHead(new Prestamo<Cliente>(cliente, listaPrestamos.getSize()+1));
    }

    public boolean devolver(Cliente cliente){
        for (int i = 0;i<listaPrestamos.getSize();i++){
            if (listaPrestamos.get(i).getElement().equals(cliente)){
                listaPrestamos.get(i).devolution();
                return true;
            }
        }
        return false;
    }

    public ListaSimplementeEnlazada<Prestamo<Cliente>> getListaPrestamos() {
        return listaPrestamos;
    }

    public Libro getLibro() {
        return libro;
    }

    public int getCodigoEjemplar() {
        return codigoEjemplar;
    }

    @Override
    public String toString(){
        return "Ejemplar{ ISBN: " + libro.getIsbn() +" Codigo de Ejemplar: " +codigoEjemplar+ " }";
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
