package es.ieslavereda.objects;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {


    @Test
    void prestarLibro() {
        Cliente c1 = new Cliente("Pacooo","siuuuu");
        Cliente c2 = new Cliente("Marta","holajuancarlos");
        Libro libro = new Libro("Marcos",200, Publicacion.Color.BLANCO_Y_NEGRO,"Paquito","LA BELLA DURMIENDO","JDA82HC7A");
        libro.addEjemplar();
        libro.addEjemplar();
        libro.addEjemplar();
        libro.addEjemplar();
        System.out.println(libro.prestarLibro(3, c1));
        System.out.println(libro.prestarLibro(2, c2));
        System.out.println(libro.prestarLibro(20,c1));
        System.out.println(libro);

    }

    @Test
    void addEjemplar() {
        Libro libro = new Libro("Marcos",200, Publicacion.Color.BLANCO_Y_NEGRO,"Paquito","LA BELLA DURMIENDO","JDA82HC7A");
        libro.addEjemplar();
        libro.addEjemplar();
        libro.addEjemplar();
        libro.addEjemplar();
        System.out.println(libro);
    }
}