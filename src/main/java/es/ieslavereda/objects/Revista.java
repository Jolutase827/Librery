package es.ieslavereda.objects;

//Revista: Nombre, tematica y periodicidad (semanal / mensual / Trimestral
public class Revista extends Publicacion{
    private String nombre;
    private String tematica;
    private Periodicidad periodicidad;
    public Revista(String editorial, int numeroPaginas, Color color,String nombre, String tematica, Periodicidad periodicidad){
        super(editorial, numeroPaginas, color);
        this.nombre = nombre;
        this.tematica = tematica;
        this.periodicidad = periodicidad;
    }

    enum Periodicidad{
        SEMANAL,
        MENSUAL,
        TRIMESTRAL;
    }
}
