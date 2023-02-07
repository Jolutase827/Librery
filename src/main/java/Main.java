import es.ieslavereda.objects.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Libro l1 = new Libro("ManuPed",20, Publicacion.Color.ACOLOR,"Nelson","Como me chingue una ARAÑA", "1");
        Libro l2 = new Libro("ManuPed",20, Publicacion.Color.ACOLOR,"Ivan","Como me mato una ARAÑA","2");
        Libro l3 = new Libro("ManuPed",20, Publicacion.Color.ACOLOR,"Matias","Como me acuchilló una ARAÑA","3");
        Libro l4 = new Libro("ManuPed",20, Publicacion.Color.ACOLOR,"Gabriel","Como me maltrató una ARAÑA","4");
        System.out.println(library.altaLibro(l1));
        System.out.println(library.altaLibro(l2));
        System.out.println(library.altaLibro(l3));
        System.out.println(library.altaLibro(l4));
        library.crearEjemplares("1",1);
        library.crearEjemplares("3",3);
        library.crearEjemplares("5",2);
        library.crearEjemplares("2",  2);
        library.crearEjemplares("4",4);
        library.crearEjemplares("1",3);
        System.out.println(library);


    }
}