package es.ieslavereda.objects;

import java.util.Date;

public class Prestamo {

    private int codigoPrestamo;
    private Cliente cliente;
    private Date fprestamo;

    private Date fdevolucion;

    public Prestamo(Cliente cliente, int codigoPrestamo){
        this.cliente = cliente;
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
                "Cliente: "+cliente+
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
                    &&prestamo1.cliente.equals(cliente));
        }
        return false;
    }
}
