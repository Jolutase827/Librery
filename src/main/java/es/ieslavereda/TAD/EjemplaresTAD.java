package es.ieslavereda.TAD;

import es.ieslavereda.objects.Cliente;
import es.ieslavereda.objects.Ejemplar;

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


    public Ejemplar get(int posicion){
        if (posicion < 0 || posicion >= size){
            return null;
        }else {
                Nodo aux = tail;
                while (posicion>0){
                    aux = aux.getPrevius();
                    posicion--;
                }
                if (aux.getInfo().isPrestado()){
                    return null;
                }else {
                    return aux.getInfo();
                }
        }
    }

    public void change(int posicion, Cliente cliente){
        if (posicion > 0 && posicion < size){
            Nodo aux  = head;
            while (posicion>0){
                aux = aux.getNext();
                posicion--;
            }
            aux.getInfo().giveToClient(cliente);
        }
    }




    public int getSize() {
        return size;
    }

    @Override
    public String toString(){
        return "Total ejemplares{ size: " +size+"\n Ejemplares: "+ head;
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
            return String.valueOf(info)+((next!=null)?""+next:"");
        }
    }
}