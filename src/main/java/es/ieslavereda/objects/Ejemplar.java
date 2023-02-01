package es.ieslavereda.objects;

import es.ieslavereda.TAD.PrestamosTAD;

public class Ejemplar {

    private PrestamosTAD listaPrestamos;
    private String isbn;

    private int codigoEjemplar;


    public Ejemplar(String isbn, int codigoEjemplar){
        this.isbn =isbn;
        this.listaPrestamos = new PrestamosTAD();
        this.codigoEjemplar = codigoEjemplar;
    }

    public boolean notPrestado(){
        return listaPrestamos.isDevolution();
    }

    public boolean addPrestamo(Cliente cliente){
        if (listaPrestamos.isDevolution()){
            listaPrestamos.addHead(new Prestamo(cliente, listaPrestamos.getSize()+1));
        }
        return false;
    }



    @Override
    public String toString(){
        return "Ejemplar{ \n ISBN: " + isbn +"\n Codigo de Ejemplar: " +codigoEjemplar+"\n"+((listaPrestamos.getSize()==0)?" Prestamos: Ejemplar no prestado":listaPrestamos)+"}\n";
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Ejemplar){
            Ejemplar ej = (Ejemplar) obj;
            return ej.isbn.equals(this.isbn)&&ej.codigoEjemplar==this.codigoEjemplar&&ej.listaPrestamos.equals(listaPrestamos);
        }
        return false;
    }
}
