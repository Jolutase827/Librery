package es.ieslavereda.TAD;


public class ListaSimplementeEnlazada<T> {
    private int size;
    private Nodo<T> head;
    private Nodo<T> tail;

    public ListaSimplementeEnlazada() {
        size = 0;
        head = null;
        tail = null;
    }


    public void addHead(T elemento) {
        Nodo<T> nodo = new Nodo(elemento);
        if (size == 0) {
            head = nodo;
            tail = nodo;
        } else {
            head.setPrevius(nodo);
            nodo.setNext(head);
            head = nodo;
        }
        size++;
    }

    public boolean remove(int position) {
        if (position < 0 || position >= size) {
            return false;
        } else {
            if (position == 0) {
                removeHead();
                return true;
            } else if (position == size - 1) {
                removeTail();
                return true;
            } else {
                Nodo<T> nodoRecorre = head;
                while (position > 0) {
                    nodoRecorre = nodoRecorre.getNext();
                    position--;
                }
                Nodo<T> aux1 = nodoRecorre.getNext();
                Nodo<T> aux2 = nodoRecorre.getPrevius();
                if (aux2 != null) {
                    aux2.setNext(aux1);
                }
                if (aux1 != null) {
                    aux1.setPrevius(aux2);
                }
                size--;
                return true;
            }
        }
    }


    public boolean removeHead() {
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Nodo<T> aux = head.getNext();
            aux.setPrevius(null);
            head = aux;
        }
        size--;
        return true;
    }

    public boolean removeTail() {
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Nodo<T> aux = tail.getPrevius();
            aux.setNext(null);
            tail = aux;
        }
        size--;
        return true;
    }

    public boolean contains(T element) {
        if (size == 0) {
            return false;
        } else {
            boolean encontrado = false;
            Nodo<T> aux = head;
            while (!encontrado && aux != null) {
                if (aux.getInfo().equals(element)) {
                    encontrado = true;
                }
                aux = aux.getNext();
            }
            return encontrado;
        }
    }

    public T get(Integer position) {
        if (position == null)
            return null;
        if (position < 0 || position >= size) {
            return null;
        } else {
            Nodo<T> aux = head;
            while (position > 0) {
                aux = aux.getNext();
                position--;
            }
            return aux.getInfo();
        }

    }

    public Integer getposition(T element) {
        if (!contains(element)) {
            return null;
        } else {
            int i = 0;
            Nodo<T> aux = head;
            while (!aux.getInfo().equals(element)) {
                i++;
                aux = aux.getNext();
            }
            return i;
        }
    }

    public boolean replace(T element, int position) {
        if (position < 0 || position >= size) {
            return false;
        } else {
            if (position == 0) {
                replaceHead(element);
                return true;
            } else if (position == size - 1) {
                replaceTail(element);
                return true;
            } else {
                Nodo<T> nodo1 = new Nodo<>(element);
                Nodo<T> nodoRecorre = head;
                while (position > 0) {
                    nodoRecorre = nodoRecorre.getNext();
                    position--;
                }
                Nodo<T> aux1 = nodoRecorre.getNext();
                Nodo<T> aux2 = nodoRecorre.getPrevius();
                nodo1.setNext(aux1);
                nodo1.setPrevius(aux2);
                aux1.setPrevius(nodo1);
                aux2.setNext(nodo1);
                nodoRecorre = nodo1;
                return true;
            }
        }
    }


    public void replaceHead(T element) {
        if (size <= 1) {
            head = new Nodo<>(element);
            tail = new Nodo<>(element);
        } else {
            Nodo<T> aux = new Nodo<>(element);
            Nodo<T> aux2 = head.getNext();
            aux.setNext(head.getNext());
            aux2.setPrevius(aux);
            head = aux;
        }
    }

    public void replaceTail(T element) {
        if (size <= 1) {
            head = new Nodo<>(element);
            tail = new Nodo<>(element);
        } else {
            Nodo<T> aux = new Nodo<>(element);
            Nodo<T> aux2 = tail.getPrevius();
            aux.setPrevius(aux2);
            aux2.setNext(aux);
            tail = aux;
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return " Cantidad: " + size + "\n Elementos: " + head;
    }

    public String imprimir() {
        return head.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ListaSimplementeEnlazada) {
            ListaSimplementeEnlazada ejemplaresTAD = (ListaSimplementeEnlazada) obj;
            return (ejemplaresTAD.size == size && head.equals(ejemplaresTAD.head) && tail.equals(ejemplaresTAD.head));
        }
        return false;
    }


    private class Nodo<T> {
        private T info;
        private Nodo<T> next;
        private Nodo<T> previus;

        public Nodo(T info) {
            previus = null;
            next = null;
            this.info = info;
        }

        public T getInfo() {
            return info;
        }

        public Nodo<T> getNext() {
            return next;
        }

        public Nodo<T> getPrevius() {
            return previus;
        }

        public void setNext(Nodo<T> next) {
            this.next = next;
        }

        public void setPrevius(Nodo<T> previus) {
            this.previus = previus;
        }

        @Override
        public String toString() {
            return info + ((next != null) ? "\n " + next : "");
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Nodo) {
                Nodo nodo = (Nodo) obj;
                return (nodo.info.equals(info)
                        && nodo.next.equals(next)
                        && nodo.previus.equals(previus));
            }
            return false;
        }
    }
}
