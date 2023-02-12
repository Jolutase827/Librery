import es.ieslavereda.objects.*;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class ModificadorDeDatos {
    public static Library hacerCosas(Library library){
        Scanner sc = new Scanner(System.in);
        Main.borrarPantalla();
        String valor;
        System.out.println("Elige una opción: ");
        System.out.println("[1] Dar de alta una publicación.");
        System.out.println("[2] Crear ejemplares.");
        System.out.println("[3] Dar de alta un cliente.");
        System.out.println("[4] Dar de baja una publicación.");
        System.out.println("[5] Dar de baja un cliente.");
        System.out.println("[6] Prestar un ejemplar.");
        System.out.println("[7] Devolver un ejemplar.");
        System.out.println("[8] Modificar la información de un cliente.");
        System.out.println("[CUALQUIER OTRO VALOR] Volver al menu principal.");
        valor = sc.nextLine();
        switch (valor){
            case ("1"):
                return darDeAltaPublicacion(library);
            case ("2"):
                return hacerEjemplares(library);
            case ("3"):
                return darAltaCliente(library);
            case ("4"):
                return darDeBajaPublicacion(library);
            case ("5"):
                return darDeBajaCliente(library);
            case ("6"):
                return prestarEjemplar(library);
            case ("7"):
                return devolverEjemplar(library);
            case ("8"):
                return modificarDatos(library);

            default:
                Main.borrarPantalla();
                break;
        }


        return library;
    }

    private static Library modificarDatos(Library library) {
        Scanner sc = new Scanner(System.in);
        Main.borrarPantalla();
        String dniViejo;
        System.out.println("--MODIFICADOR DE DATOS DE CLIENTE--");
        System.out.println("Clientes para modificar los datos");
        System.out.println();
        System.out.println(library.getClientes());
        System.out.println("------------");
        System.out.println("Escribe el dni de la persona que quieres cambiar los datos.");
        dniViejo = sc.nextLine();
        if (library.getCliente(dniViejo)!=null){
            String dniNuevo,nombreNuevo;
            System.out.println("Ecribe el dni nuevo:");
            dniNuevo = sc.nextLine();
            System.out.println("Escribe el nombre nuevo:");
            nombreNuevo = sc.nextLine();
            library.getCliente(dniViejo).cambiarNombreyDNi(dniNuevo,dniViejo);
            Main.borrarPantalla();
            System.out.println("Los datos se han guardado correctamente");
            System.out.println("Pulsa enter para ir al menu....");
            sc.nextLine();
        }else {
            System.out.println("Ningún cliente con ese dni");
            System.out.println("Redirigiendo al menu pulsa enter..");
            sc.nextLine();
        }
        return library;
    }

    private static Library devolverEjemplar(Library library) {
        Scanner sc = new Scanner(System.in);
        Main.borrarPantalla();
        String dni;
        System.out.println("--DEVOLVER LIBRO--");
        System.out.println("Clientes:");
        System.out.println();
        System.out.println(library.getClientes());
        System.out.println("------------");
        System.out.println("Escribe el dni de la persona que quiere devolver el libro:");
        dni = sc.nextLine();
        if (library.getCliente(dni)!=null){
            String isbn;
            int codigoEjemplar;
            System.out.println("Escribe el isbn del libro que quieres devolver:");
            isbn = sc.nextLine();
            System.out.println("Ecribe el codigo de ejemplar que quieres devolver:");
            codigoEjemplar = Integer.parseInt(sc.nextLine());
            if (library.devolverLibro(isbn,codigoEjemplar,library.getCliente(dni))){
                System.out.println("Libro devuelto correctamente");
            }else {
                System.out.println("El libro no existe o el ejemplar ya esta devuelto");
            }

        }else {
            System.out.println("Ningun cliente con ese dni");
        }
        System.out.println("Pulsa enter para ir al menu....");
        sc.nextLine();
        return library;
    }

    private static Library prestarEjemplar(Library library) {
        Scanner sc = new Scanner(System.in);
        Main.borrarPantalla();
        String dni;
        System.out.println("--PRESTAR LIBRO--");
        System.out.println("Clientes:");
        System.out.println();
        System.out.println(library.getClientes());
        System.out.println("------------");
        System.out.println("Escribe el dni de la persona que quiere pedir un libro:");
        dni = sc.nextLine();
        if (library.getCliente(dni)!=null){
            Cliente c1 = library.getCliente(dni);
            if (c1.aptoParaPedirLibro()){
                Main.borrarPantalla();
                String isbn;
                System.out.println("Hola "+ c1.getNombre());
                System.out.println("--LIBROS DISPONIBLES--");
                System.out.println(library.getLibros());
                System.out.println("--------------");
                System.out.println("Que libro te gustaría tomar prestado.");
                isbn = sc.nextLine();
                if (library.existeLibro(isbn)){
                    int codigoDeEjemplar;
                    Main.borrarPantalla();
                    System.out.println("---EJEMPLARES DEL LIBRO---");
                    System.out.println(library.getLibro(isbn).getEjemplares());
                    System.out.println("--------");
                    System.out.println("Selecciona el codigo de ejemplar que quieres");
                    codigoDeEjemplar = Integer.parseInt(sc.nextLine());
                    if (library.prestamoLibro(isbn,codigoDeEjemplar,c1)){
                        System.out.println("Tome su libro "+ c1.getNombre());
                    }else {
                        System.out.println("El codigo del ejemplar es erroneo");
                    }
                }else {
                    System.out.println("El libro seleccionado no existe.");
                }

            }else {
                System.out.println("El cliente ha llegado a su máximo de libros prestados o no esta dado de alta");
            }

        }else {
            System.out.println("Ningun cliente con ese dni, recomendamos darlo de alta");
        }
        System.out.println("Pulsa enter para ir al menu....");
        sc.nextLine();
        return library;
    }

    private static Library darDeBajaPublicacion(Library library) {
        Scanner sc = new Scanner(System.in);
        Main.borrarPantalla();
        String valor;
        System.out.println("--BAJA PUBLICACIÓN--");
        System.out.println("Que tipo de publicación quieres dar de baja:");
        System.out.println("[1] Libros");
        System.out.println("[2] Periodicos");
        System.out.println("[3] Revistas");
        System.out.println("[CUALQUIER OTRO VALOR] Ir a menu");
        valor = sc.nextLine();
        switch (valor){
            case ("1"):
                return darbajaLibro(library);
            case ("2"):
                return darbajaPeriodico(library);
            case ("3"):
                return darbajaRevista(library);
            default:
                System.out.println("Pulsa enter para ir a menu...");
                sc.nextLine();
                return library;
        }
    }

    private static Library darbajaRevista(Library library) {
        Scanner sc = new Scanner(System.in);
        Main.borrarPantalla();
        String nombre;
        System.out.println("--BAJA REVISTA--");
        System.out.println("Revistas:");
        System.out.println();
        System.out.println(library.getRevistas());
        System.out.println("------------");
        System.out.println("Escribe el nombre de la revista que quieres eliminar.");
        nombre = sc.nextLine();
        if (library.bajaRevista(new Revista("",0, Publicacion.Color.BLANCO_Y_NEGRO,nombre, "", Revista.Periodicidad.SEMANAL))){
            System.out.println("Los datos se han guardado correctamente");
            System.out.println("Pulsa enter para ir al menu....");
            sc.nextLine();
        }else {
            System.out.println("Ninguna revista con ese nombre");
            System.out.println("Redirigiendo al menu pulsa enter..");
            sc.nextLine();
        }
        return library;
    }

    private static Library darbajaPeriodico(Library library) {
        Scanner sc = new Scanner(System.in);
        Main.borrarPantalla();
        String nombre;
        System.out.println("--BAJA PERIODICO--");
        System.out.println("Periodicos:");
        System.out.println();
        System.out.println(library.getPeriodicos());
        System.out.println("------------");
        System.out.println("Escribe el nombre del periodico que quieres eliminar.");
        nombre = sc.nextLine();
        if (library.bajaPeriodico(new Periodico("",0, Publicacion.Color.BLANCO_Y_NEGRO,nombre))){
            System.out.println("Los datos se han guardado correctamente");
            System.out.println("Pulsa enter para ir al menu....");
            sc.nextLine();
        }else {
            System.out.println("Ningún periódico con ese nombre");
            System.out.println("Redirigiendo al menu pulsa enter..");
            sc.nextLine();
        }
        return library;
    }


    public static Library darbajaLibro(Library library){
        Scanner sc = new Scanner(System.in);
        Main.borrarPantalla();
        String isbn;
        System.out.println("--BAJA LIBRO--");
        System.out.println("Libros:");
        System.out.println();
        System.out.println(library.getLibros());
        System.out.println("------------");
        System.out.println("Escribe el isbn del libro que quieres dar de baja.");
        isbn = sc.nextLine();
        if (library.bajaLibro(library.getLibro(isbn))){
            System.out.println("Los datos se han guardado correctamente");
            System.out.println("Pulsa enter para ir al menu....");
            sc.nextLine();
        }else {
            System.out.println("Ningún libro con ese isbn");
            System.out.println("Redirigiendo al menu pulsa enter..");
            sc.nextLine();
        }
        return library;
    }

    private static Library darDeAltaPublicacion(Library library) {
        Scanner sc = new Scanner(System.in);
        Main.borrarPantalla();
        String valor;
        System.out.println("--ALTA PUBLICACIÓN--");
        System.out.println("Que tipo de publicación quieres dar de alta:");
        System.out.println("[1] Libros");
        System.out.println("[2] Periodicos");
        System.out.println("[3] Revistas");
        System.out.println("[CUALQUIER OTRO VALOR] Ir a menu");
        valor = sc.nextLine();
        switch (valor){
            case ("1"):
                if (library.altaLibro(crearLibro())){
                    System.out.println("El libro se dio de alta correctamente");
                }else {
                    System.out.println("Ya existe un libro con ese isbn");
                }
                break;
            case ("2"):
                if (library.altaPeriodico(crearPeriodico())){
                    System.out.println("El periodico se dio de alta correctamente");
                }else {
                    System.out.println("Ya existe un periodico con ese nombre");
                }
                break;
            case ("3"):
                if (library.altaRevista(crearRevista())){
                    System.out.println("La revista se dio de alta correctamente");
                }else {
                    System.out.println("Ya existe una revista con ese nombre");
                }
                break;
            default:
                System.out.println("VOLVIENDO A MENUUUU");
                sc.nextLine();
                return library;
        }
        System.out.println("Pulsa enter para ir a menu...");
        sc.nextLine();
        return library;
    }


    private static Library darDeBajaCliente(Library library) {
        Scanner sc = new Scanner(System.in);
        Main.borrarPantalla();
        String dni;
        System.out.println("--BAJA CLIENTE--");
        System.out.println("Clientes:");
        System.out.println();
        System.out.println(library.getClientes());
        System.out.println("------------");
        System.out.println("Escribe el dni de la persona que quieres dar de baja.");
        dni = sc.nextLine();
        if (library.getCliente(dni)!=null){
            if (library.getCliente(dni).darBaja())
                System.out.println("Los datos se han guardado correctamente");
            else
                System.out.println("El cliente ya estaba dado de baja.");
            System.out.println("Pulsa enter para ir al menu....");
            sc.nextLine();
        }else {
            System.out.println("Ningún cliente con ese dni");
            System.out.println("Redirigiendo al menu pulsa enter..");
            sc.nextLine();
        }
        return library;
    }



    private static Library darAltaCliente(Library library) {
        Scanner sc = new Scanner(System.in);
        Main.borrarPantalla();
        String dni;
        System.out.println("--ALTA CLIENTE--");
        System.out.println("Clientes:");
        System.out.println();
        System.out.println(library.getClientes());
        System.out.println("------------");
        System.out.println("Escribe el dni de la persona que quieres dar de alta:");
        dni = sc.nextLine();
        if (library.getCliente(dni)==null){
            String nombre;
            System.out.println("Escribe el nombre de la persona que quieres dar de alta:");
            nombre = sc.nextLine();
            library.altaCliente(new Cliente(nombre,dni));
            System.out.println("El cliente ha sido registrado correctamente.");
            System.out.println("Pulsa enter para ir al menu....");
            sc.nextLine();
        }else {
            if(library.getCliente(dni).darAlta()){
                System.out.println("El cliente ha sido dado de alta correctamente.");
            }else {
                System.out.println("El cliente ya estaba en la base de datos.");
            }
            System.out.println("Redirigiendo al menu pulsa enter..");
            sc.nextLine();
        }
        return library;
    }

    private static Library hacerEjemplares(Library library) {
        Scanner sc = new Scanner(System.in);
        String isbn;
        int cantidadDeEjemplares;
        System.out.println("--CREAR EJEMPLARES DE UN LIBRO--");
        System.out.println("Libros disponibles: ");
        System.out.println();
        System.out.println(library.getLibros());
        System.out.println();
        System.out.println("Indica el isbn del libro que quieres crear ejemplares:");
        isbn= sc.nextLine();
        System.out.println("Indica cuantos ejemplares quieres crear: ");
        cantidadDeEjemplares = Integer.parseInt(sc.nextLine());
        if (cantidadDeEjemplares>0){
            if (library.crearEjemplares(isbn,cantidadDeEjemplares)){
                System.out.println("Se han creado los ejemplares correctamente");
                System.out.println("Pulsa enter para ir al menu...");
            }else {
                System.out.println("El isbn esta mal expresado");
                System.out.println("Pulsa enter para ir al menu...");
            }
            sc.nextLine();
        }else {
            System.out.println("Cantidad de libros mal expresada");
            System.out.println("Redirigiendo al menu pulsa enter....");
            sc.nextLine();
        }
        return library;
    }




    public static Libro crearLibro(){
        Scanner sc = new Scanner(System.in);
        String editorial;
        int numeroPaginas;
        String color2="";
        Publicacion.Color color;
        String autor;
        String titulo;
        String isbn;
        System.out.println("Dime la editorial del libro: ");
        editorial = sc.nextLine();
        System.out.println("Ecribe con numeros cuantas paginas tiene el libro");
        numeroPaginas = Integer.parseInt(sc.nextLine());
        System.out.println("Es a color(1) o en blanco y negro(2)? ");
        color2 = devuelveUnoODos();
        if (color2.equals("1"))
            color= Publicacion.Color.ACOLOR;
        else
            color = Publicacion.Color.BLANCO_Y_NEGRO;
        System.out.println("Dime el nombre del autor: ");
        autor = sc.nextLine();
        System.out.println("Dime el nombre del titulo: ");
        titulo = sc.nextLine();
        System.out.println("Dime el isbn por el cual se va a identificar el libro: ");
        isbn = sc.nextLine();
        return new Libro(editorial,numeroPaginas,color,autor,titulo,isbn);

    }




    public static Revista crearRevista(){
        Scanner sc = new Scanner(System.in);
        String editorial;
        int numeroPaginas;
        String color2="";
        Publicacion.Color color;
        String nombre;
        String tematica;
        Revista.Periodicidad periodicidad;
        System.out.println("Dime la editorial de la revista: ");
        editorial = sc.nextLine();
        System.out.println("Ecribe con numeros cuantas paginas tiene la revista");
        numeroPaginas = Integer.parseInt(sc.nextLine());
        System.out.println("Es a color(1) o en blanco y negro(2)? ");
        color2 = devuelveUnoODos();
        if (color2.equals("1"))
            color= Publicacion.Color.ACOLOR;
        else
            color = Publicacion.Color.BLANCO_Y_NEGRO;
        System.out.println("Dime el nombre de la revista: ");
        nombre = sc.nextLine();
        System.out.println("Dime la tematica de la revista: ");
        tematica = sc.nextLine();
        System.out.println("Dime la periodicidad de la revista (Semanal), (Mensual), (Trimestral)");
        periodicidad = sacarPeriodicidad();
        return new Revista(editorial,numeroPaginas,color,nombre, tematica,periodicidad);

    }



    public static Periodico crearPeriodico(){
        Scanner sc = new Scanner(System.in);
        String editorial;
        int numeroPaginas;
        String color2="";
        Publicacion.Color color;
        String nombre;
        System.out.println("Dime la editorial de la revista: ");
        editorial = sc.nextLine();
        System.out.println("Ecribe con numeros cuantas paginas tiene la revista");
        numeroPaginas = Integer.parseInt(sc.nextLine());
        System.out.println("Es a color(1) o en blanco y negro(2)? ");
        color2 = devuelveUnoODos();
        if (color2.equals("1"))
            color= Publicacion.Color.ACOLOR;
        else
            color = Publicacion.Color.BLANCO_Y_NEGRO;
        System.out.println("Dime el nombre del periodico: ");
        nombre = sc.nextLine();

        return new Periodico(editorial,numeroPaginas,color,nombre);
    }

    private static Revista.Periodicidad sacarPeriodicidad() {
        Scanner sc = new Scanner(System.in);
        String periodicidad = sc.nextLine();
        while (periodicidad.compareToIgnoreCase("SEMANAL")!=0&&periodicidad.compareToIgnoreCase("MENSUAL")!=0&&periodicidad.compareToIgnoreCase("TRIMESTRAL")!=0){
            System.out.println("Dime (semanal), (mensual), (trimestral)");
            periodicidad = sc.nextLine();
        }
        if (periodicidad.compareToIgnoreCase("Semanal")==0){
            return Revista.Periodicidad.SEMANAL;
        }else if (periodicidad.compareToIgnoreCase("Mensual")==0){
            return Revista.Periodicidad.MENSUAL;
        }else {
            return Revista.Periodicidad.TRIMESTRAL;
        }
    }

    public static String devuelveUnoODos(){
        Scanner sc = new Scanner(System.in);
        String salida = sc.nextLine();
        while(salida.compareTo("1")!=0&&salida.compareTo("2")!=0){
            System.out.println("Escribe 1 o 2");
            salida = sc.nextLine();
        }
        return salida;
    }
}
