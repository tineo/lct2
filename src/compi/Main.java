/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author tineo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Ventana v = new Ventana();

        Automata automata =  new Automata();

        v.btnComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(v.txtIngreso.getText());

                try {
                    if(automata.comprobar(v.txtIngreso.getText(), v.txtPila)){
                        System.out.println("Si");
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });


        v.setVisible(true);

    }


}
