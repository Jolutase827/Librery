package es.ieslavereda.objects;

public class Ejemplar {
    private boolean prestado;
    private String isbn;

    private Cliente cliente;

    private int codigoEjemplar;


    public Ejemplar(String isbn, int codigoEjemplar){
        this.isbn =isbn;
        this.prestado = false;
        this.codigoEjemplar = codigoEjemplar;
        this.cliente = null;
    }

    public boolean isPrestado(){
        return prestado;
    }

    public boolean giveBack(){
        if (prestado){
            prestado = false;
            cliente = null;
            return true;
        }
        return false;
    }

    public boolean giveToClient(Cliente cliente){
        if (prestado){
            return false;
        }
        prestado = true;
        this.cliente = cliente;
        return prestado;

    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString(){
        return "Ejemplar{ \n ISBN: " + isbn +"\n Codigo de Ejemplar: " +codigoEjemplar+"\n"+((cliente!=null)?""+cliente:"")+" Prestado: "+prestado+"}\n";
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Ejemplar){
            Ejemplar ej = (Ejemplar) obj;
            return ej.isbn.equals(this.isbn)&&ej.codigoEjemplar==this.codigoEjemplar;
        }
        return false;
    }
}
