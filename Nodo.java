public class Nodo<T> {
    public Nodo padre;
    public Nodo derecha;
    public Nodo izquierda;
    public int llave;
    public T contenido;

    public Nodo(int indice) {
        this.llave = indice;
        this.derecha = null;
        this.izquierda = null;
        this.padre = null;
        this.contenido = null;
    }

}
