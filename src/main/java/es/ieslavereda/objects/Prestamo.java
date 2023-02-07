package es.ieslavereda.objects;

import java.util.Date;

public class Prestamo<T> {

    private int codigoPrestamo;
    private T element;
    private Date fprestamo;

    private Date fdevolucion;

    public Prestamo(T element, int codigoPrestamo){
        this.element = element;
        this.codigoPrestamo = codigoPrestamo;
        fprestamo = new Date();
        fdevolucion = null;
    }

    public boolean isDevolution(){
        return (fdevolucion!=null);
    }

    @Override
    public String toString(){
        return "  Prestamo "+codigoPrestamo+"{ " +
                 element +
                ", Fecha de prestamo: "+ fprestamo +
                ((fdevolucion ==null)?"  No devuelto.}\n":" Fecha de devolución: "+ fdevolucion +"\n}");
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Prestamo){
            Prestamo prestamo1 = (Prestamo) obj;
            return (prestamo1.codigoPrestamo==codigoPrestamo
                    &&prestamo1.fprestamo.equals(fprestamo)
                    &&prestamo1.fdevolucion.equals(fdevolucion)
                    &&prestamo1.element.equals(element));
        }
        return false;
    }
}
