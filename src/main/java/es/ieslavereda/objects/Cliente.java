package es.ieslavereda.objects;


import es.ieslavereda.TAD.ListaSimplementeEnlazada;

public class Cliente {
    private String nombre;
    private String dni;

    private boolean activo;

    private ListaSimplementeEnlazada<Prestamo<Ejemplar>> prestamos;



    public Cliente(String nombre, String dni){
        this.dni = dni;
        this.nombre =nombre;
        this.prestamos = new ListaSimplementeEnlazada<>();
        activo = true;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
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

    public boolean hasEjemplar(Ejemplar ejemplar){
        if (prestamos.getSize()>0){
            for (int i = 0;i<prestamos.getSize();i++){
                if (prestamos.get(i).getElement().equals(ejemplar)){
                    return !prestamos.get(i).isDevolution();
                }
            }
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean devolver(Ejemplar ejemplar){
        for (int i = 0;i<prestamos.getSize();i++){
            if (prestamos.get(i).getElement().equals(ejemplar)){
                prestamos.get(i).devolution();
                return true;
            }
        }
        return false;
    }

    public boolean aptoParaPedirLibro(){
        if (activo){
            int numeroDeLibrosSinDevolver=0;
            for (int i=0;i<prestamos.getSize();i++){
                if (!prestamos.get(i).isDevolution()){
                    numeroDeLibrosSinDevolver++;
                }
            }
            return numeroDeLibrosSinDevolver < 3;
        }
        return false;
    }
    public void prestar(Ejemplar ejemplar){
        prestamos.addHead(new Prestamo<>(ejemplar,prestamos.getSize()+1));
    }


    public boolean darAlta(){
        if (activo){
            return false;
        }
        activo = true;
        return true;
    }

    public ListaSimplementeEnlazada<Prestamo<Ejemplar>> getPrestamos() {
        return prestamos;
    }


    @Override
    public String toString(){
        return " Cliente{ Nombre: "+nombre+", DNI: "+dni+", Activo: "+ activo +"}\n";
        //\n Prestamos: "+ prestamos  +"
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Cliente){
            Cliente cliente = (Cliente) obj;
            return this.dni.equals(cliente.dni);
        }
        return false;
    }


}
