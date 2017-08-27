
package Lista.Doble.Circular;

import Lista.Doble.NodoDoble;

/**
 * Devolver la cantidad de elementos de la lista
 */
public class ListaDobleCircular<T> {
    
    public boolean esPalindrome(){
        return true;
    }
    
    public void removerInicio(){
        
    }
    
    public void removerFinal(){
        
    }
    
    public void agregarInicio(T e){//to do
        
    }
    
    public void agregarFinal(T e){//to do
        if(isEmpty()){
            add(e);
        }else{
            end().setSiguiente(new NodoDoble<T>(end(),e,root));
            root.setSiguiente(end().getSiguiente());
        }
        
    }
    
    NodoDoble<T> end(){
        return (isEmpty())? null : root.getAnterior();
    }
    
    void add(T e){
        if(isEmpty()){
            root= new NodoDoble(null,e,null);
            root.setSiguiente(root);
            root.setAnterior(root);
        }else{
            NodoDoble<T> n = new NodoDoble<T>(null,e,null);
            root.setAnterior(n);
            n.getAnterior().setSiguiente(n);
            root=n;
        }
    }
    
    int count(){
        if(isEmpty()){
            return 0;
        }else{
            int i=0;
            NodoDoble<T> temp = root;
            do{
                i++;
                temp = temp.getSiguiente();
            }while(temp!=root);
            return i;
        }
    }
    public boolean isEmpty(){
        return true;
    }
    
    public String toString(){
        if(isEmpty()){
            return " ";
        }else{
            StringBuilder r = new StringBuilder();
            int i=0;
            NodoDoble<T> temp = root;
            do{
                r.append(temp.getDato()+"-->");
                temp = temp.getSiguiente();
            }while(temp!=root);
            return r.toString();
        }
    }

    private NodoDoble<T> root;
}
