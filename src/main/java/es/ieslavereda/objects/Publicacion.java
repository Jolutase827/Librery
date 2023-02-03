package es.ieslavereda.objects;

public abstract class Publicacion implements IPublicacion{
    private String editorial;
    private int numeroPaginas;
    private Color color;

    public Publicacion(String editorial, int numeroPaginas, Color color){
        this.editorial = editorial;
        this.numeroPaginas = numeroPaginas;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    @Override
    public String toString(){
        return " Editorial: "+ editorial+"\n Numero de paginas: "+ numeroPaginas + "\n Color: "+ color +"\n";
    }

    @Override
    public abstract String imprimir();

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Publicacion) {
            Publicacion publicacion =(Publicacion) obj;
            if (publicacion.color.equals(color)&&publicacion.editorial.equals(editorial)&&publicacion.numeroPaginas==numeroPaginas) {
                if (obj instanceof Libro) {
                    Libro libro = (Libro) this;
                    return libro.equals(obj);
                }
                if (obj instanceof Periodico) {
                    Periodico periodico = (Periodico) this;
                    return periodico.equals(obj);
                }
                if (obj instanceof Revista) {
                    Revista revista = (Revista) this;
                    return revista.equals(obj);
                }
            }
            return false;
        }
        return false;
    }

    enum Color{
        COLOR("color"),
        BLANCO_Y_NEGRO("blanco y negro");

        private String atribute;

        Color(String atribute){
            this.atribute = atribute;
        }

        @Override
        public String toString(){
            return atribute;
        }


    }
}
