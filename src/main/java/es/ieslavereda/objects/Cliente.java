package es.ieslavereda.objects;

public class Cliente {
    private String nombre;
    private String dni;

    public Cliente(String nombre, String dni){
        this.dni = dni;
        this.nombre =nombre;
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
