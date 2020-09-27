/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.Random;

/**
 *
 * @author vinni
 */
public class NewClass {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Random geradorNumeroAleatorio = new Random();
            System.out.println(geradorNumeroAleatorio.nextInt(1));
        }
    }
}
