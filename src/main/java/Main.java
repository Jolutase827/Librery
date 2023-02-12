import es.ieslavereda.objects.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        String valor="";
        System.out.println("Bienvenido a la \"Libreria Tarraga Segura!!!");
        while (!valor.equals("-1")){
            System.out.println("Que quieres hacer?");
            System.out.println("[1] Revisar las estanterias.");
            System.out.println("[2] Hacer acciones.");
            System.out.println("[-1] Salir de la aplicación.");
            valor = sc.nextLine();
            while (!valor.equals("1")&&!valor.equals("2")&&!valor.equals("-1")){
                System.out.println("Escribe lo de los corchetes: ");
                System.out.println("[1] Revisar las estanterias.");
                System.out.println("[2] Actuar sobre la biblioteca.");
                System.out.println("[-1] Salir de la aplicación.");
                valor = sc.nextLine();
            }
            if(valor.equals("1")){
                Impresora.revisarEstanteria(library);
            }
            if (valor.equals("2")){
               library = ModificadorDeDatos.hacerCosas(library);
            }
        }
    }








    public static void borrarPantalla(){
        for (int i =0; i<30;i++){
            System.out.println();
        }
    }


}