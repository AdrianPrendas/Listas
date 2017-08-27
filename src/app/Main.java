package app;


import Lista.Simple.ListaSimple;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author adrian
 */
public class Main {

    public static List menosRepetidos(ArrayList<Integer> l) {
        Hashtable<String, Integer> tabla = new Hashtable<String, Integer>();
        for (Integer i : l) {
            String key = i.toString();
            if (tabla.get(key) == null)
                tabla.put(key,i);
        }
        return new ArrayList(tabla.values());
    }

    public static void main(String[] args) {
        /*ArrayList<Integer> l = new ArrayList<Integer>();
        Random rad = new Random();
        for (int i = 0; i < 20; i++) {
            l.add(rad.nextInt(10));
        }
        System.out.println(l);
        System.out.println("sin duplicados");
        System.out.println(menosRepetidos(l));*/
        
        ListaSimple<String> ls = new ListaSimple<String>();
        ls.add("a");
        ls.add("r");
        ls.add("r");
        ls.add("i");
        ls.add("b");
        ls.add("a");
        ls.add("l");
        ls.add("a");
        ls.add("b");
        ls.add("i");
        ls.add("r");
        ls.add("r");
        ls.add("a");
        System.out.println(ls.palindrome(ls)?"es Palindrome":"no es palindrome");
        
        ListaSimple<Integer> ls2 = new ListaSimple<Integer>();
        for(int i=0;i!=10;i++)
            ls2.add(i);
        System.out.println("lista: "+ls2);
        System.out.println("la posicion minima es:"+ls2.minPosition());
        
        ListaSimple<Integer> l = new ListaSimple<Integer>();
        Random rad = new Random();
        for (int i = 0; i < 20; i++) {
            l.add(rad.nextInt(10));
        }
        System.out.println(l);
        l.sort(l);
        System.out.println("ordendo :"+l);
    }

}
