package Lista.Doble;

import Lista.Simple.NodoSimple;

/**
 * @author adrian
 */
public class NodoDoble<T> {// |T|<-->|T|<-->|T|<-->|T|<-->|T|

    public NodoDoble(NodoDoble<T> anterior, T element, NodoDoble<T> siguiente) {
        this.dato = element;
        this.anterior = anterior;
        this.siguiente = siguiente;

    }

    public NodoDoble(T e) {
        this.dato = e;
        this.anterior = null;
    }

    public NodoDoble<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoDoble<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble<T> siguiente) {
        this.siguiente = siguiente;
    }

    private NodoDoble<T> anterior;
    private T dato;
    private NodoDoble<T> siguiente;
}
