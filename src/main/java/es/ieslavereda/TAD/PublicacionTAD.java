package es.ieslavereda.TAD;

import es.ieslavereda.objects.Publicacion;

public class PublicacionTAD {
    private int size;
    private Nodo head;
    private Nodo tail;

    public PublicacionTAD(){
        size=0;
        tail = null;
        head = null;
    }

    public void addHead(Publicacion publicacion){
        Nodo nodo = new Nodo(publicacion);
        if (size==0){
            head=nodo;
            tail=nodo;
        }else {
            nodo.setNext(head);
            head = nodo;
        }
        size++;
    }

    public boolean bajaPublicacion(Publicacion publicacion){
        if (size==0){
            return false;
        }
        Nodo aux1 = head;
        if (aux1.getInfo().equals(publicacion)){
            head= head.getNext();
            return true;
        }else {
            Nodo aux2 = aux1.getNext();
            while (aux2!=null||!aux2.getInfo().equals(publicacion)){
                aux1 = aux2;
                aux2 = aux2.getNext();
            }
            if (aux2.getInfo()==null){
                return false;
            }else {
                aux1.setNext(aux2.getNext());
                return true;
            }
        }
    }


    class Nodo{
        private Publicacion info;
        private Nodo next;

        public Nodo(Publicacion info){
            this.info = info;
            this.next = null;
        }

        public Nodo getNext() {
            return next;
        }

        public Publicacion getInfo() {
            return info;
        }

        public void setNext(Nodo next) {
            this.next = next;
        }

        @Override
        public String toString(){
            return info +((next!=null)?"\n"+ next:"");
        }
    }
}
