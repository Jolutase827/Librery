package es.ieslavereda.objects;

import es.ieslavereda.TAD.EjemplaresTAD;

public class Libro extends Publicacion{

    private String autor;

    private String titulo;

    private String isbn;

    private EjemplaresTAD ejemplares;


    public Libro(String editorial, int numeroPaginas, Color color, String autor, String titulo,String isbn){
        super(editorial,numeroPaginas,color);

        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
        this.ejemplares = new EjemplaresTAD();

    }


    public boolean prestarLibro(int posicion,Cliente cliente){
        if (ejemplares.get(posicion)==null){
            return false;
        }else {
            ejemplares.get(posicion).giveToClient(cliente);
            ejemplares.change(posicion,cliente);
            return true;
        }


    }


    public void addEjemplar(){
        ejemplares.addHead(new Ejemplar(isbn, ejemplares.getSize()));
    }


    @Override
    public String toString(){
        return "Libro{\n"+super.toString()+
                " Autor:"+autor+ "\n Titulo: " + titulo + "\n ISBN: " + isbn+"\n "+ejemplares.toString();
    }


}
