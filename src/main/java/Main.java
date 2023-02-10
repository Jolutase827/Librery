import es.ieslavereda.TAD.ListaSimplementeEnlazada;
import es.ieslavereda.objects.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Libro l1 = new Libro("ManuPed",20, Publicacion.Color.ACOLOR,"Nelson","Como me chingue una ARAÑA", "1");
        Libro l2 = new Libro("ManuPed",20, Publicacion.Color.ACOLOR,"Ivan","Como me mato una ARAÑA","2");
        Libro l3 = new Libro("ManuPed",20, Publicacion.Color.ACOLOR,"Matias","Como me acuchilló una ARAÑA","3");
        Libro l4 = new Libro("ManuPed",20, Publicacion.Color.ACOLOR,"Gabriel","Como me maltrató una ARAÑA","4");
        Cliente c1 = new Cliente("JoseLuis","1234");
        library.altaLibro(l1);
        library.altaLibro(l2);
        library.altaLibro(l3);
        library.altaLibro(l4);
        library.crearEjemplares("1",1);
        library.crearEjemplares("3",3);
        library.crearEjemplares("5",2);
        library.crearEjemplares("2",  1);
        library.crearEjemplares("4",4);
        library.crearEjemplares("1",3);

        library.altaCliente(c1);
        System.out.println(library.prestamoLibro("3",2,c1));
        System.out.println(library.prestamoLibro("3",2,c1));
        System.out.println(library.prestamoLibro("1",2,c1));
        System.out.println(library.prestamoLibro("2",0,c1));
        System.out.println(library.prestamoLibro("4",2,c1));
        System.out.println(library.prestamoLibro("5",2,c1));
        System.out.println(library.prestamoLibro("3",1,c1));
        System.out.println(library.prestamoLibro("3",2,c1));

        System.out.println(library);

    }
}