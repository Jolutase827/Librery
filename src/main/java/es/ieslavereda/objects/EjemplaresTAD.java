package es.ieslavereda.objects;

public class EjemplaresTAD {
    private int size;
    private Nodo head;
    private Nodo tail;

    public EjemplaresTAD(){
        size=0;
        head = null;
        tail = null;
    }


    public void addHead(String isbn){
        Nodo nodo = new Nodo(new Ejemplar(isbn, size+1));
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

    public EjemplaresTAD getDisponible(){
        if (size>0) {
            EjemplaresTAD l = new EjemplaresTAD();
            Nodo aux = head;
            while (aux != null) {
                if (!aux.getInfo().isPrestado()){
                    l.addHead(aux.getInfo());
                }
                aux = aux.getNext();
            }
        }
        return null;
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
