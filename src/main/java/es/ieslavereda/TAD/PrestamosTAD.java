package es.ieslavereda.TAD;
import es.ieslavereda.objects.Prestamo;

public class PrestamosTAD {
    private int size;
    private Nodo head;
    private Nodo tail;

    public PrestamosTAD(){
        size =0;
        head = null;
        tail = null;
    }

    public int getSize() {
        return size;
    }

    public void addHead(Prestamo prestamo){
            Nodo nodo = new Nodo(prestamo);
            if (size == 0) {
                head = nodo;
                tail = nodo;
            } else {
                nodo.setNext(head);
                head.setPrevius(nodo);
                head = nodo;
            }
            size++;
    }

    public boolean isDevolution(){
        if (head!=null)
            return head.getInfo().isDevolution();
        return true;
    }


    @Override
    public String toString(){
        return "Lista de prestamos{ Size: "+ size +", Prestamos: "+ head+"}\n";
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof PrestamosTAD){
            PrestamosTAD prestamosTAD = (PrestamosTAD) obj;
            return (prestamosTAD.size ==size&&head.equals(prestamosTAD.head)&&tail.equals(prestamosTAD.head));
        }
        return false;
    }



    class Nodo{
        private Prestamo info;
        private Nodo next;
        private Nodo previus;

        public Nodo(Prestamo info){
            this.info = info;
            next = null;
            previus = null;
        }

        public void setNext(Nodo next) {
            this.next = next;
        }

        public void setPrevius(Nodo previus) {
            this.previus = previus;
        }

        public Nodo getNext() {
            return next;
        }

        public Nodo getPrevius() {
            return previus;
        }

        public Prestamo getInfo() {
            return info;
        }


        @Override
        public String toString(){
            return info+((next!=null)?", "+next:"");
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
