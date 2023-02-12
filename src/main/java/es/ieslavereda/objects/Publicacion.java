package es.ieslavereda.objects;

public abstract class Publicacion {
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
        return " Editorial: "+ editorial+", Numero de paginas: "+ numeroPaginas + ", Color: "+ color;
    }



    public enum Color{
        ACOLOR("color"),
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
