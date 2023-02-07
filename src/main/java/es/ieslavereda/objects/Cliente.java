package es.ieslavereda.objects;


import es.ieslavereda.TAD.ListaSimplementeEnlazada;

public class Cliente {
    private String nombre;
    private String dni;

    private boolean activo;

    private ListaSimplementeEnlazada<Prestamo> prestamos;

    public String getDni() {
        return dni;
    }

    public Cliente(String nombre, String dni){
        this.dni = dni;
        this.nombre =nombre;
        this.prestamos = new ListaSimplementeEnlazada<>();
        activo = true;
    }

    public void cambiarNombreyDNi(String dni,String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }


    public boolean darBaja(){
        if (activo){
            activo = false;
            return true;
        }
        return false;
    }


    public boolean darAlta(){
        if (activo){
            return false;
        }
        activo = true;
        return true;
    }


    public boolean llegaLimitePedidos(){
        return false;
    }

    @Override
    public String toString(){
        return " Cliente{ Nombre: "+nombre+", DNI: "+dni+", Activo: "+ activo  +"}\n";
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Cliente){
            Cliente cliente = (Cliente) obj;
            return this.nombre.equals(cliente.nombre)&&this.dni.equals(cliente.dni);
        }
        return false;
    }


}
