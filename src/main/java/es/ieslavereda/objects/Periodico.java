package es.ieslavereda.objects;

import java.util.Date;

//Periodicos: Nombre y dia de publicacion
public class Periodico extends Publicacion{
    private String nombre;
    private Date diaPublicacion;

    public Periodico(String editorial, int numeroPaginas, Color color,String nombre){
        super(editorial,numeroPaginas,color);
        this.nombre = nombre;
        this.diaPublicacion = new Date();
    }

    @Override
    public String imprimir(){
        return "Periodico{ Nombre: "+ nombre + ", Fecha de publicación: "+ diaPublicacion;
    }



}
