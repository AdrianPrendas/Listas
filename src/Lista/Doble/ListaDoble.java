package Lista.Doble;

/**
 * hacer un algoritmo que inserte en una posicion p cualquiera
 * se tiene una lista doblemente enlazada con numeros repetidos no ordenada
 * por ejemplo 1,2,3,2,8,1 (eliminar los duplicados)
 * 
 *  Tarea: remover en cualquier posicion
 *          implementar un metodo con la lista doblemente enlazada
 *          que diga si es palindrome O(n) //menos de 5 lineas
 */
public class ListaDoble<T> {

    public void add(T e) {
        if (isEmpty()) {
            root = end = new NodoDoble<T>(null, e, null);
        } else {
            NodoDoble<T> n = new NodoDoble<>(null, e, root);
            root.setSiguiente(n);
            root = n;
        }
    }

    public void addEnd(T e) {//tarea
        if (isEmpty()) {
            add(e);
        } else {
            NodoDoble<T> n = new NodoDoble(end, e, null);
            end.setSiguiente(n);
            end = n;
        }
    }

    public void addPos(T e, int p) {
        if (p == 0) {
            add(e);
        } else {
            NodoDoble<T> temp = root;
            int i = 1;
            while (i < p && temp != null) {
                i++;
                temp = temp.getSiguiente();
            }
            if(i == p){
            NodoDoble<T> n = new NodoDoble(temp,e,temp.getSiguiente());
            temp.setSiguiente(n);
            if(n.getSiguiente() != null){
                n.getSiguiente().setSiguiente(n);
            }else{
                
            }
        }
        }
        
    }
    public boolean palindrome(){//version del profesor Steven
     return true;   
    }

    public boolean isEmpty() {
        return root == null ;
    }
    private NodoDoble<T> root, end;// no pueden ser publicos, hay tabla
}
