package es.ieslavereda.objects;

import java.util.Date;

//Revista: Nombre, tematica y periodicidad (semanal / mensual / Trimestral
public class Revista extends Publicacion{
    private String nombre;
    private String tematica;
    private Periodicidad periodicidad;

    private Date diaPublicacion;
    public Revista(String editorial, int numeroPaginas, Color color,String nombre, String tematica, Periodicidad periodicidad){
        super(editorial, numeroPaginas, color);
        this.nombre = nombre;
        this.tematica = tematica;
        this.periodicidad = periodicidad;
        diaPublicacion = new Date();
    }

    @Override
    public String imprimir(){
        return "Revista{ Nombre: "+ nombre+", Fecha de publicación: " + diaPublicacion+"\n";
    }


    enum Periodicidad{
        SEMANAL,
        MENSUAL,
        TRIMESTRAL;
    }
}
