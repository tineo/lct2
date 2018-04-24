package compi;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Automata {
    int qf = 100;
    int qe = -1;

    int q = 0;
    int n = 0;

    Deque<String> pila = new ArrayDeque<String>();


    public boolean comprobar(String cadena, JTextField txtPila) throws InterruptedException {

        int tam = cadena.length();
        int cur = 0;
        String token = "";
        while (q != qf && q != qe && n <= cadena.length()) {
            txtPila.setText(pila.toString());
            Thread.sleep(4000);
            token = String.valueOf(cadena.charAt(cur));
            cur++;
            n++;
            System.out.println("================================");

            switch (q) {
                case 0:
                    System.out.println("q0");
                    System.out.println(token);
                    System.out.println(pila.peek());
                    System.out.println("->");


                    if (token.equals("a") && pila.isEmpty()) {
                        q = 1;
                        pila.push("a");
                        System.out.println("q1");
                        System.out.println("a");
                    } else {
                        System.out.println("else");
                        q = qe;
                    }
                    break;
                case 1:
                    System.out.println("q1");
                    System.out.println(token);
                    System.out.println(pila.peek());
                    System.out.println("->");

                    if (token.equals("a") && pila.peek().equals("a")) {
                        q = 1;
                        pila.push("a");
                        System.out.println("q1");
                        System.out.println("a");
                    } else if (token.equals("b") && pila.peek().equals("a")) {
                        q = 2;
                        pila.push("b");
                        System.out.println("q2");
                        System.out.println("b");
                    } else {
                        q = qe;
                    }
                    break;
                case 2:
                    System.out.println("q2");
                    System.out.println(token);
                    System.out.println(pila.peek());
                    System.out.println("->");

                    if (token.equals("b") && pila.peek().equals("b")) {
                        q = 2;
                        pila.push("b");
                        System.out.println("q2");
                        System.out.println("b");
                    } else if (token.equals("c") && pila.peek().equals("b")) {
                        q = 3;
                        pila.pop();
                        System.out.println("q3");
                        System.out.println("&");
                    } else {
                        q = qe;
                    }
                    break;
                case 3:
                    System.out.println("q3");
                    System.out.println(token);
                    System.out.println(pila.peek());
                    System.out.println("->");

                    if (token.equals("c") && pila.peek().equals("b")) {
                        q = 3;
                        pila.pop();
                        System.out.println("q3");
                        System.out.println("&");
                    } else if (token.equals("c") && pila.peek().equals("a")) {
                        q = 4;
                        pila.pop();
                        System.out.println("q4");
                        System.out.println("&");
                    } else {
                        q = qe;
                    }
                    break;
                case 4:
                    System.out.println("q4");
                    System.out.println(token);
                    System.out.println(pila.peek());
                    System.out.println("->");

                    if (token.equals("c") && pila.isEmpty()) {
                        q = 4;
                        pila.pop();
                        System.out.println("q4");
                        System.out.println("&");
                    } else if (token.equals("$") && pila.isEmpty()) {
                        q = qf;
                        System.out.println("qf");
                        System.out.println("-");
                    } else {
                        q = qe;
                    }
                    break;
            }
        }
        if(q == qf){
            return true;
        }else {
            return false;
        }
    }
}
