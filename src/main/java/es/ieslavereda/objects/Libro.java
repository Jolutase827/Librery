package es.ieslavereda.objects;
import es.ieslavereda.TAD.ListaSimplementeEnlazada;

public class Libro extends Publicacion{

    private String autor;

    private String titulo;

    private String isbn;

    private ListaSimplementeEnlazada<Ejemplar> ejemplares;


    public Libro(String editorial, int numeroPaginas, Color color, String autor, String titulo,String isbn){
        super(editorial,numeroPaginas,color);

        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
        this.ejemplares = new ListaSimplementeEnlazada<>();
    }

    public boolean existeEjemplar(int codigoEjemplar){
        Ejemplar ejemplar = new Ejemplar(this,codigoEjemplar);
        for (int i =0; i<ejemplares.getSize();i++)
            if (ejemplares.get(i).equals(ejemplar))
                return true;

        return false;

    }


    public void addEjemplares(int i){
        for (int j =0; j<i;j++){
            addEjemplar();
        }
    }

    public Ejemplar getEjemplar(int codigoEjemplar){
        return ejemplares.get(ejemplares.getposition(new Ejemplar(this,codigoEjemplar)));
    }

    public String getIsbn() {
        return isbn;
    }

    public ListaSimplementeEnlazada<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public void addEjemplar(){
        ejemplares.addHead(new Ejemplar(this, ejemplares.getSize()));
    }



    @Override
    public String toString(){
        return "Libro{"+super.toString()+ " Autor:"+autor+ " Titulo: " + titulo + " ISBN: " + isbn+"}";
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Libro){
            Libro libro = (Libro) obj;
            return libro.isbn.compareToIgnoreCase(isbn)==0;
        }
        return false;
    }

}
