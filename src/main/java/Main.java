import es.ieslavereda.objects.Cliente;
import es.ieslavereda.objects.Library;
import es.ieslavereda.objects.Periodico;
import es.ieslavereda.objects.Publicacion;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Periodico p1 = new Periodico("ManuPed",20, Publicacion.Color.ACOLOR,"1");
        Periodico p2 = new Periodico("ManuPed",20, Publicacion.Color.ACOLOR,"2");
        Periodico p3 = new Periodico("ManuPed",20, Publicacion.Color.ACOLOR,"3");
        Periodico p4 = new Periodico("ManuPed",20, Publicacion.Color.ACOLOR,"4");
        System.out.println(library.altaPeriodico(p1));
        System.out.println(library.altaPeriodico(p2));
        System.out.println(library.altaPeriodico(p3));
        System.out.println(library.altaPeriodico(p4));
        System.out.println(library);
        System.out.println(library.bajaPeriodico(p2));
        System.out.println(library);
        System.out.println(library.bajaPeriodico(p1));
        System.out.println(library);
        System.out.println(library.bajaPeriodico(p3));
        System.out.println(library);
        System.out.println(library.bajaPeriodico(p4));
        System.out.println(library);
        System.out.println(library.bajaPeriodico(p2));
        System.out.println(library);
        System.out.println(library.bajaPeriodico(p2));
        System.out.println(library);

    }
}