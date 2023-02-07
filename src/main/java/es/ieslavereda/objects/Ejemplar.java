package es.ieslavereda.objects;

import es.ieslavereda.TAD.ListaSimplementeEnlazada;

public class Ejemplar {

    private ListaSimplementeEnlazada<Prestamo> listaPrestamos;
    private Libro libro;
    private int codigoEjemplar;


    public Ejemplar(Libro libro, int codigoEjemplar){
        this.libro = libro;
        this.listaPrestamos = new ListaSimplementeEnlazada<>();
        this.codigoEjemplar = codigoEjemplar;
    }

//    public boolean notPrestado(){
//        return false;
//    }

//    public boolean addPrestamo(Cliente cliente){
//        if (listaPrestamos.isDevolution()){
//            listaPrestamos.addHead(new Prestamo(cliente, listaPrestamos.getSize()+1));
//        }
//        return false;
//    }

    public Libro getLibro() {
        return libro;
    }


    @Override
    public String toString(){
        return "Ejemplar{ \n ISBN: " + libro.getIsbn() +"\n Codigo de Ejemplar: " +codigoEjemplar+"\n"+((listaPrestamos.getSize()==0)?" Prestamos: Ejemplar no prestado":listaPrestamos)+"}\n";
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Ejemplar){
            Ejemplar ej = (Ejemplar) obj;
            return ej.libro.equals(this.libro)&&ej.codigoEjemplar==this.codigoEjemplar&&ej.listaPrestamos.equals(listaPrestamos);
        }
        return false;
    }
}
