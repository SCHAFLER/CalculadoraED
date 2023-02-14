/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase07_02;

/**
 *
 * @author andresschafler
 */
public class Expecion extends RuntimeException{
    
    public Expecion(){
        
    }
    
    public Expecion(String message){
       super(message); 
    }
    
}
