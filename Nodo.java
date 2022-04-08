public class Nodo<T> {
    public Nodo padre;
    public Nodo derecha;
    public Nodo izquierda;
    public String llave;
    public T contenido;

    public Nodo(K key) {
        this.llave = key;
        this.derecha = null;
        this.izquierda = null;
        this.padre = null;
        this.contenido = null;
    }

    public Nodo(K key) {
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public Nodo getPadre() {
        return padre;
    }

    public int getLlave() {
        return llave;
    }

}
