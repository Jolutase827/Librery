import es.ieslavereda.objects.Library;

import java.util.Scanner;

public class Impresora {
    public static void revisarEstanteria(Library library){
        Scanner sc = new Scanner(System.in);
        String values;
        System.out.println("Dime que quieres revisar: ");
        System.out.println();
        System.out.println("[1] Revisar Ejemplares.");
        System.out.println("[2] Revisar Prestamos de un ejemplar.");
        System.out.println("[3] Revisar Libros.");
        System.out.println("[4] Revisar Revistas.");
        System.out.println("[5] Revisar Periodicos.");
        System.out.println("[6] Revisar Clientes.");
        System.out.println("[7] Revisar prestamos Clientes.");
        System.out.println("[8] Imprimir otro tipo de publicación.");
        System.out.println("[CUALQUIER OTRO VALOR] Volver atrás.");
        values = sc.nextLine();
        switch (values){
            case ("1"):
                Main.borrarPantalla();
                System.out.println("--REVISAR EJEMPLARES--");
                revisarEjemplares(library);
                System.out.println();
                System.out.println("Dale al enter para volver al menu de inicio...");
                sc.nextLine();
                break;
            case ("2"):
                Main.borrarPantalla();
                System.out.println("--REVISAR PRESTAMOS DE EJEMPLAR--");
                revisarPrestamosEjemplar(library);
                System.out.println();
                System.out.println("Dale al enter para volver al menu de inicio...");
                sc.nextLine();
                break;
            case ("3"):
                Main.borrarPantalla();
                System.out.println("--REVISAR LIBROS--");
                System.out.println(library.getLibros());
                System.out.println();
                System.out.println("Dale al enter para volver al menu de inicio...");
                sc.nextLine();
                break;
            case ("4"):
                Main.borrarPantalla();
                System.out.println("--REVISAR REVISTAS--");
                System.out.println(library.getRevistas());
                System.out.println();
                System.out.println("Dale al enter para volver al menu de inicio...");
                sc.nextLine();
                break;
            case ("5"):
                Main.borrarPantalla();
                System.out.println("--REVISAR PERIODICOS--");
                System.out.println(library.getPeriodicos());
                System.out.println();
                System.out.println("Dale al enter para volver al menu de inicio...");
                sc.nextLine();
                break;
            case ("6"):
                Main.borrarPantalla();
                System.out.println("--REVISAR CLIENTES--");
                System.out.println(library.getClientes());
                System.out.println();
                System.out.println("Dale al enter para volver al menu de inicio...");
                sc.nextLine();
                break;
            case ("7"):
                Main.borrarPantalla();
                System.out.println("--REVISAR PRESTAMOS DE CLIENTES--");
                revisarPrestamoDeCliente(library);
                System.out.println();
                System.out.println("Dale al enter para volver al menu de inicio...");
                sc.nextLine();
                break;
            case ("8"):
                Main.borrarPantalla();
                System.out.println("Esta opción está para futuras actualizaciones de la aplicación.");
                System.out.println("Dale al enter para volver al menu de inicio...");
                sc.nextLine();
                break;

            default:
                Main.borrarPantalla();
                break;
        }

    }

    private static void revisarPrestamoDeCliente(Library library) {
        Scanner sc = new Scanner(System.in);
        String dni;
        System.out.println(library.getClientes());
        System.out.println("Dime el dni del cliente que quieres revisar los datos");
        dni = sc.nextLine();
        if (library.getCliente(dni)!=null) {
            System.out.println(library.getCliente(dni).getPrestamos());
        }else {
            System.out.println("Ningun cliente con ese dni");
        }
    }

    public static String revisarEjemplares(Library library){
        Scanner sc = new Scanner(System.in);
        String isbn;
        System.out.println("Introduce el isbn del libro que quieres ver los ejemplares");
        System.out.println(library.getLibros());
        isbn = sc.nextLine();
        Main.borrarPantalla();
        if (library.getLibro(isbn)!=null){
            System.out.println(library.getLibro(isbn).getEjemplares());
        }else {
            System.out.println("Ese isbn no es de ningún libro.");
        }
        return isbn;
    }

    public static void revisarPrestamosEjemplar(Library library){
        Scanner sc = new Scanner(System.in);
        String isbn = revisarEjemplares(library);
        int codigoEjemplar;
        if (library.getLibro(isbn)!=null){
            System.out.println("Dime el codigo de ejemplar que quieres revisar los prestamos");
            System.out.println(library.getLibro(isbn).getEjemplares());
            codigoEjemplar = sc.nextInt();
            if (library.getLibro(isbn).getEjemplar(codigoEjemplar)!=null){
                System.out.println(library.getLibro(isbn).getEjemplar(codigoEjemplar).getListaPrestamos());
            }else {
                System.out.println("Ejemplar no disponible");
            }
        }
    }

}
