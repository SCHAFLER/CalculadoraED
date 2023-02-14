/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase07_02;

/**
 *
 * @author andresschafler
 */
public class Pila <T> implements PilaADT<T>{
    
    private T[] pila;
    private int tope;
    private final int MAX=100;
    
    public Pila(){
        pila = (T[]) new Object[MAX];
        tope = -1;
    }
    
    public Pila(int maximo){
        pila = (T[]) new Object[maximo];
        tope = -1;
    }
    
    public boolean isEmpty(){
        return tope == -1;
    }
    
    public void expande(){
        T[] masGrande = (T[]) new Object[pila.length*2];
        for(int i=0;i<=tope;i++)
            masGrande[i] = pila[i];
        pila = masGrande;
    }
    
    public void push(T dato){
        if(tope == pila.length-1){
            expande();
        }
        tope++;
        pila[tope]=dato;
    }
    
    public T peek(){
        if(isEmpty()){
            throw new Expecion("La pila está vaciá");
        }
        return pila[tope];
    }
    
    public T pop(){
        if(isEmpty())
            throw new Expecion("La pila no tiene elementos");
        T eliminado = pila[tope];
        pila[tope]=null;
        tope--;
        return eliminado;
    }
       
    @Override
    public String toString(){
        StringBuilder sB = new StringBuilder();
        
        for(int i=0;i<=tope;i++){
            sB.append(pila[i]).append(" ");
        }
        return sB.toString();
    }
}
