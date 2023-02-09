package Tareas;//tarea 6

import java.util.Scanner;
import java.util.Stack;

public class InfijoaPostfijo {

  private static int Prioridad(char c) {
    switch (c) {
      case '^':
        return 3;
      case '*':
      case '/':
        return 2;
      case '+':
      case '-':
        return 1;
      case '(':
        return 0;
    }// end switch
    return -1;
  }// end Prioridad

  public static String InfijoaPostfijox(String exp) {
    String resultado = "";
    Stack<Character> pila = new Stack<>();
    for (int i = 0; i < exp.length(); i++) {
      char c = exp.charAt(i);
      if (Character.isLetterOrDigit(c)) {
        resultado += c;
      } // si es letra o digito se pasa directo al resultado
      else if (c == '(') {
        pila.push(c);
      } // si es "(" se agrega a la pila
      else if (c == ')') {
        while (!pila.isEmpty() && pila.peek() != '(') {
          resultado += pila.pop();
        }
        if (!pila.isEmpty() && pila.peek() != '(') {
          return "Error";
        } // saca todos los elementos de la pila y los agrega a la expresión postfija
          // hasta encontrar"(",
        else {
          pila.pop();
        } // elimina los "(" que quedan el la pila

      } else {

        while (!pila.isEmpty() && Prioridad(pila.peek()) >= Prioridad(c)) {
          resultado += pila.pop();
        }
        pila.push(c);
      } // Si el carácter es un operador, saca elementos de la pila y los agrega al
        // resultado, poniendolos por prioridad
    } // end for

    while (!pila.isEmpty()) {// Una vez que se haya recorrido toda la expresión, saca todos los elementos
                             // restantes de la pila y los agrega a la expresión postfija.

      resultado += pila.pop();
    } // hace que vacie los caracteres que llegue a quedar al final de la pila
    return resultado;
  }// end InfijoaPostfijo de x

  public static void Evaluar(String postfijo) {
    Scanner s = new Scanner(System.in);
    Stack<Integer> pila = new Stack<>();

    for (int i = 0; i < postfijo.length(); i++) {
      char c = postfijo.charAt(i);
      if (Character.isLetter(c)) {
        System.out.println("Valor de la letra " + c);
        int x = s.nextInt();
        pila.push(x);

      } else {// si es numero guarda el valor en la pila, sino busca que operador es y hace la
              // operacion
        int Temp1 = pila.pop();
        int Temp2 = pila.pop();
        switch (c) {
          case '+':
          //pila.push(operacion);
            System.out.println("suma " + Temp2 + "+" + Temp1 + "= " + pila.push(Temp2 + Temp1));
            System.out.println(pila);
            break;
          case '-':
            System.out.println("resta " + Temp2 + "-" + Temp1 + "= " + pila.push(Temp2 - Temp1));
            System.out.println(pila);
            break;
          case '*':
            System.out.println("multiplicacion " + Temp2 + "*" + Temp1 + "= " + pila.push(Temp2 * Temp1));
            break;
          case '/':
            System.out.println("division " + Temp2 + "/" + Temp1 + "= " + pila.push(Temp2 / Temp1));
            System.out.println(pila);
            break;
          case '^':
            System.out.println("exponencial " + Temp2 + "^" + Temp1 + "= " + pila.push((int) Math.pow(Temp2, Temp1)));
            System.out.println(pila);
            break;
        }// end sitch, casa caso muestra la operacion y la pila, para ver si algo sale
         // mal y en que parte
      } // end if else

    } // end for

    System.out.println("elementos que hay en la pila: " + pila);

    s.close();
    System.out.println("El resultado es: " + pila.peek());
  }// end evaluar

  public static void main(String[] args) {
    String exp = "(A*B/C)+(D-N/k)^(M+H*F)";
    System.out.println("El infijo es: " + exp);
    System.out.println("El postfijo es: " + InfijoaPostfijox(exp));
    Evaluar(InfijoaPostfijox(exp));
  }// end mian
}// end class
