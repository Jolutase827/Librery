package es.ieslavereda.objects;

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

    }


    public void addEjemplar(){
        ejemplares.addHead(isbn);
    }



}
