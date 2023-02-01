package es.ieslavereda.TAD;

import es.ieslavereda.objects.Cliente;
import es.ieslavereda.objects.Ejemplar;
import es.ieslavereda.objects.Libro;

public class EjemplaresTAD {
    private int size;
    private Nodo head;
    private Nodo tail;

    public EjemplaresTAD(){
        size=0;
        head = null;
        tail = null;
    }


    public void addHead(Ejemplar ejemplar){
        Nodo nodo = new Nodo(ejemplar);
        if (size ==0){
            head = nodo;
            tail = nodo;
        }else {
            head.setPrevius(nodo);
            nodo.setNext(head);
            head =  nodo;
        }
        size++;
    }







    public int getSize() {
        return size;
    }

    @Override
    public String toString(){
        return "Total ejemplares{ size: " +size+"\n Ejemplares: "+ head;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof EjemplaresTAD){
            EjemplaresTAD ejemplaresTAD = (EjemplaresTAD) obj;
            return (ejemplaresTAD.size ==size&&head.equals(ejemplaresTAD.head)&&tail.equals(ejemplaresTAD.head));
        }
        return false;
    }



    class Nodo{
        private Ejemplar info;
        private Nodo next;
        private Nodo previus;

        public Nodo(Ejemplar info){
            previus = null;
            next = null;
            this.info = info;
        }

        public Ejemplar getInfo() {
            return info;
        }

        public Nodo getNext() {
            return next;
        }

        public Nodo getPrevius() {
            return previus;
        }

        public void setNext(Nodo next) {
            this.next = next;
        }

        public void setPrevius(Nodo previus) {
            this.previus = previus;
        }

        @Override
        public String toString(){
            return String.valueOf(info)+((next!=null)?"\n "+next:"");
        }

        @Override
        public boolean equals(Object obj){
            if (obj instanceof Nodo){
                Nodo nodo = (Nodo) obj;
                return (nodo.info.equals(info)
                        &&nodo.next.equals(next)
                        &&nodo.previus.equals(previus));
            }
            return false;
        }
    }
}
