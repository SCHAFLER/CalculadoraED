/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase07_02;

/**
 *
 * @author andresschafler
 */
public class Calculadora<T> extends Pila<T>{
    
    private T[] arreglo;
    private final int MAX = 100;
    
    public Calculadora(){ 
        T[] arreglo = (T[]) new Object[MAX];
    }
    
    public double calcula(String operacion){
        boolean revi = revisa(operacion);
        double res = 0;
        if(revi == true){
            String acomodada = acomoda(operacion);
            res = calculaPostfija(acomodada);
        }else{
            System.out.println("La operación no está ordenada correctamente. Checa los paréntesis.");
        }
        return res;
        
    }
    
    public static double calculaPostfija(String expression) {
    Pila<Integer> stack = new Pila<>();
    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      if (Character.isDigit(c)) {
        stack.push(c - '0');
      } else {
        int val1 = stack.pop();
        int val2 = stack.pop();
        switch (c) {
          case '+':
            stack.push(val2 + val1);
            break;
          case '-':
            stack.push(val2 - val1);
            break;
          case '/':
            stack.push(val2 / val1);
            break;
          case '*':
            stack.push(val2 * val1);
            break;
        }
      }
    }
    return stack.pop();
  }
    
    public static String acomoda(String operacion) {
    Pila<Character> pila = new Pila<>();
    StringBuilder posfija = new StringBuilder();
    for (int i = 0; i < operacion.length(); i++) {
      char c = operacion.charAt(i);
      if (Character.isLetterOrDigit(c)) {
        posfija.append(c);
      } else if (c == '(') {
        pila.push(c);
      } else if (c == ')') {
        while (!pila.isEmpty() && pila.peek() != '(') {
          posfija.append(pila.pop());
        }
        pila.pop();
      } else {
        while (!pila.isEmpty() && previo(c) <= previo(pila.peek())) {
          posfija.append(pila.pop());
        }
        pila.push(c);
      }
    }
    while (!pila.isEmpty()) {
      posfija.append(pila.pop());
    }
    return posfija.toString();
  }

    private static int previo(char c) {
        switch (c) {
          case '+':
          case '-':
            return 1;
          case '*':
          case '/':
            return 2;
          case '^':
            return 3;
        }
        return -1;
    }
 
    public boolean revisa(String operacion){
        Pila<Character> pila = new Pila();
        for(int i=0; i<operacion.length();i++){
            char c = operacion.charAt(i);
            if(c == '(' || c == '['){
                pila.push(c);
            } else if (c == ')' || c == ']'){
                if (pila.isEmpty())
                    return false;
                char tope = pila.pop();
                if((c == ')' && tope != '(') || (c == ']' && tope != '[')){
                    return false;
                }
            }            
        }
        return pila.isEmpty();
    }   
}
