package es.ieslavereda.objects;

import es.ieslavereda.TAD.EjemplaresTAD;

public class Cliente {
    private String nombre;
    private String dni;

    private EjemplaresTAD ejemplares;

    public Cliente(String nombre, String dni){
        this.dni = dni;
        this.nombre =nombre;
        this.ejemplares = new EjemplaresTAD();
    }




    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return " Cliente{ Nombre: "+nombre+", DNI: "+dni+"}\n";
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
