/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Clase07_02;

/**
 *
 * @author andresschafler
 */
public interface PilaADT<T> {
    
    public void push(T dato);
    public T peek();
    public T pop();
    public boolean isEmpty();
    
}
