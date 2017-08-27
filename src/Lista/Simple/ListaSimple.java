package Lista.Simple;

import java.util.Iterator;

/* Presentacion en el aulaVirtual
 * implementar si una lista simplemente enlazada es palindrome
 */
public class ListaSimple<T extends Comparable> implements Iterable<T> {
    
    private boolean palindromeProfe(NodoSimple<T> n, int mitad, int pos, ListaSimple<T> stack,boolean espar){
//        if(n==null){
//            return true;
//        }else{
//            if(pos < mitad){
//                stack.add(n.getDato());
//            }else if((espar && p>= mitad) || (!espar && p> mitad) ){
//                //T tmp = pop()
//                //if(tmp!=n.dato())return false
//            }
//            return palindromeProfe(n.getSiguiente(),mitad,p+1,stack);
//            
//        }
        return false;
    }
    public boolean esPar(int n){
        return n%2 == 0;
    }
    public boolean palindromeProfesor(){
        return palindromeProfe(root,this.length/2,0,new ListaSimple<T>(),false);
    }
    
    public boolean palindrome(ListaSimple<T> a){
        return (a.length<2) ||
                (a.get(0)==a.get(a.length-1)&& palindrome(a.slice(1,a.length-1)));
    }

    private int compare(NodoSimple<T> a, NodoSimple<T> b) {
        return a.getDato().compareTo(b.getDato());
    }
    
    public ListaSimple<T> slice(int a){
        ListaSimple<T> nuevaLista = new ListaSimple<T>();
        NodoSimple actual = root;
        if(a>0 && a<this.length){
            for(int i=0;actual!=null && i!=a;i++){
                actual = actual.getSiguiente();
            }
            for(;actual!=null;){
                nuevaLista.add((T)actual.getDato());
                actual=actual.getSiguiente();
            }
            return nuevaLista;
        }
        if(a<0 && a*-1 <= this.length){
            
        }
        return null;
    }
    public ListaSimple<T> slice(int a,int b){
        ListaSimple<T> nuevaLista = new ListaSimple<T>();
        Iterador<T> it = new Iterador(this);
        int len = a-b;
        if(len== 0)
            return slice(1);
        try{
            if(a>length || b>length || a*-1>length || b*-1> length)
                throw new Exception("los indices exceden el tamaño de la lista");
            if (a<b){
                for(int i=0;i<a;i++)
                    it.next();
                while(it.hasNext())
                    nuevaLista.addEnd(it.next());
                for(int i=b;i!=length;i++){
                    nuevaLista.removeEnd();
                }
                
            }else if(a>b){
                slice(b,a);
            }
                
        }catch(Exception e){System.out.println(e.getMessage());e.printStackTrace();}
        return nuevaLista;
        
    }

    public ListaSimple() {
        root = end = null;
        length = 0;
    }

    public void add(T elemento) {// O(1)
        if (isEmpty()) {
            root = end = new NodoSimple<T>(elemento, null);
        } else {
            root = new NodoSimple<T>(elemento, root);
        }
        length++;
    }

    // O(1)
    public void addEnd(T element) {
        if (isEmpty()) {
            add(element);
        } else {
            end.setSiguiente(new NodoSimple<>(element));
            end = end.getSiguiente();
            length++;
        }

    }

    public void add(T elem, int pos) {
        try {
            if (pos == 0) {
                add(elem);
                return;
            }
            if (pos == length) {
                addEnd(elem);
                return;
            }
            if (pos > length) {
                throw new Exception("excede la posicion");
            }

            int count = 1;
            NodoSimple<T> temp = root;
            for (; temp != null && count != pos; temp = temp.getSiguiente(), count++) {
                if (temp != null && count == pos) {
                    temp.setSiguiente(new NodoSimple<>(elem, temp.getSiguiente()));
                }
            }
            length++;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sort(ListaSimple<T> l) {//utilizando la pila

        if (!l.isEmpty()) {
            T dato = l.minElement();
            int p = l.minPosition();
            l.remove(root, p);
            sort(l);
            l.add(dato);
        }

    }

    public void invertir(ListaSimple<T> l) {//lo mismo que sort solo que alreves
        /*
            if(!l.isEmpty()){
                T dato = l.get(0);
                l.remove(0);
                invertir(l);
                l.addEnd(dato);
            }
         */

    }
    
    public NodoSimple<T> removeEnd(){
        NodoSimple<T> actual = root;
        if(isEmpty())return null;
        for(;actual.getSiguiente()!=null && actual.getSiguiente().getSiguiente()!=null;){
            actual = actual.getSiguiente();
        }
        if(actual.getSiguiente()==null){
            return null;
        }else if(actual.getSiguiente().getSiguiente()==null){
            end = actual;
            end.setSiguiente(null);
        }
        length--;
        return actual;
    }

    public NodoSimple<T> remove(NodoSimple<T> actual, int pos) {
        if (actual == null) {
            return null;
        } else {
            if (pos == 0) {
                return actual.getSiguiente();
            } else {
                actual.setSiguiente(remove(actual.getSiguiente(), pos - 1));
                return actual;
            }
        }
    }

    public T get(int pos) {
        int count = 0;
        NodoSimple<T> temp = root;
        for (; temp != null && count != pos; temp = temp.getSiguiente(), count++);
        if (temp != null && count == pos) {
            return temp.getDato();
        }
        return null;
    }

    public T minElement() {//elemento
        return get(minPosition());
    }

    public int minPosition() {//posicion
        if(isEmpty())return -1;
        NodoSimple<T> min,i;
        min = i =root;
        for(;i!=null;i=i.getSiguiente()){
            if(this.compare(min, i)>0)//i<min
                min = i;
        }
        i=root;
        for(int c=0;c!=length;c++){
            if(this.compare(i, min)==0)
                return c;
            i=i.getSiguiente();
        }
        return -1;
    }

    public int getLength() {
        return this.length;
    }

    public boolean isEmpty() {
        return root == null;
    }
    
    public String toString(){
        StringBuilder r = new StringBuilder();
        Iterador it = new Iterador(this);
        for(;it.hasNext();)
            r.append(it.next());
            
        return r.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterador(this);
    }

    private NodoSimple<T> root, end;
    private int length;
}

// private Nodo<T> actual; Hay tabla!
/*
    NUNCA SE HACE, POR MOTIVOS DE 
    COMPOSICION. 
    
    public Nodo<T> getRoot() {
        return root;
    }

    public void setRoot(Nodo<T> root) {
        this.root = root;
    }
 */

 /*
    // O(1)
    public void add(T elemento){
        root = new Nodo<T>(elemento, root);
    }
    
    // O(n) 
    public void addEnd(T elemento){
        if(empthy()){
            add(elemento);
        }
        else {
            Nodo<T> actual = root;
            while(actual.getSiguiente() != null){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(new Nodo<>(elemento));
        }
    }
 */
