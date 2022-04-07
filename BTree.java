public class BTree<T> {
    Nodo raiz;

    public BTree() {

        raiz = null;

    }

    public void insertar(int i, T contenido) {
        Nodo n = new Nodo<T>(i);
        n.setContenido(contenido);

        if (raiz == null) {
            raiz = n;
        } else {
            Nodo aux = raiz;
            while (aux != null) {
                n.setPadre(aux);
                if (n.getLlave() >= aux.getLlave()) {
                    aux = aux.derecha; // QUE??
                } else {
                    aux = aux.izquierda;
                }
            }

            if (n.getLlave() < n.getPadre().getLlave()) {
                n.padre.izquierda = n;
            } else {
                n.padre.derecha = n;
            }

        }

    }

    public void buscar(Nodo n) {
        if (n != null) {
            buscar(n.izquierda);
            print("" + n.getLlave() + " " + n.getContenido());
            buscar(n.derecha);

        }
    }

    public void print(String str) {
        System.out.println(str);
    }

}
