package Lista.Simple;

import java.util.Iterator;

public class Iterador<T extends Comparable> implements Iterator<T>{
        private ListaSimple<T> lista;
        private int length;
        private int indexPosition;
        
        public Iterador(ListaSimple<T> lista){
            this.lista = lista;
            this.indexPosition = 0;
            this.length = lista.getLength();
        }
        
        public int getLength(){
            return this.length;
        }

        @Override
        public boolean hasNext() {
            return lista.getLength()> indexPosition ;
                   
        }

        @Override
        public T next() {
            T obj = lista.get(indexPosition++);
            return obj;
        }
        
    }