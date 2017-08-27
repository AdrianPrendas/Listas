package Lista.Simple;

import java.util.Iterator;
import java.util.function.Consumer;


public class NodoSimple<T>{// 2->3->5->7->

    public NodoSimple(T dato, NodoSimple<T> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public NodoSimple(T dato) {
        this.dato = dato;
        siguiente = null;
    }    
    
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoSimple<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSimple<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    private T dato;
    private NodoSimple<T> siguiente;    
}