package es.ieslavereda.TAD;

import com.sun.security.ntlm.Client;
import es.ieslavereda.objects.Cliente;

public class ClienteTAD {
    private int size;
    private Nodo head;
    private Nodo tail;

    public ClienteTAD(){
        size=0;
        head = null;
        tail = null;
    }

    public void addHead(Cliente cliente){
        Nodo nodo = new Nodo(cliente);
        if (head==null){
            head = nodo;
            tail = nodo;
        }else {
            nodo.setNext(head);
            head=nodo;
        }

        size++;
    }

    public boolean bajaCliente(String dni){
        if (size==0){
            return false;
        }else {
            Nodo aux = head;
            while (aux!=null){
                if (aux.getInfo().getDni()==dni){
                    return aux.getInfo().darBaja();
                }
                aux = aux.getNext();
            }
            return false;
        }
    }


    public boolean altaCliente(Cliente cliente){
        if (size==0){
            addHead(cliente);
            return true;
        }else {
            Nodo aux = head;
            while (aux!=null){
                if (aux.getInfo().equals(cliente)){
                    return aux.getInfo().darAlta();
                }
                aux = aux.getNext();
            }
            addHead(cliente);
            return true;
        }
    }

    public boolean cambiarDatos(String dniViejo, String dniNuevo, String nombreNuevo){
        if (size==0){
            return false;
        }else {
            Nodo nodo = head;
            while (nodo!=null){
                if (nodo.getInfo().getDni().equals(dniViejo)){
                    nodo.getInfo().cambiarNombreyDNi(dniNuevo,nombreNuevo);
                    return true;
                }
                nodo= nodo.getNext();
            }
            return false;
        }
    }







    class Nodo{
        private Cliente info;
        private Nodo next;

        public Nodo(Cliente info){
            this.info = info;
            next = null;
        }

        public Nodo getNext() {
            return next;
        }

        public Cliente getInfo() {
            return info;
        }

        public void setNext(Nodo next) {
            this.next = next;
        }

        @Override
        public String toString(){
            return info + ((next!=null)?"\n "+next:"");
        }
    }
}
