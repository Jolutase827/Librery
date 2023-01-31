package es.ieslavereda.objects;
//Periodicos: Nombre y dia de publicacion
public class Periodico extends Publicacion{
    private String nombre;
    private String diaPublicacion;

    public Periodico(String editorial, int numeroPaginas, Color color,String nombre, String diaPublicacion){
        super(editorial,numeroPaginas,color);
        this.nombre = nombre;
        this.diaPublicacion = diaPublicacion;
    }



}
