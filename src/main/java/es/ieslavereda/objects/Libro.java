package es.ieslavereda.objects;
import com.sun.org.apache.bcel.internal.generic.FADD;
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

    public String getIsbn() {
        return isbn;
    }

    public EjemplaresTAD getEjemplares() {
        return ejemplares;
    }

    public void addEjemplar(){
        ejemplares.addHead(new Ejemplar(this, ejemplares.getSize()));
    }



    @Override
    public String toString(){
        return "Libro{\n"+super.toString()+
                " Autor:"+autor+ "\n Titulo: " + titulo + "\n ISBN: " + isbn+"\n "+ejemplares.toString();
    }

    @Override
    public String imprimir(){
        return ejemplares.imprimir();
    }



}
