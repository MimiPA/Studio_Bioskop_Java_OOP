/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studio;

import java.util.Scanner;

/**
 *
 * @author Paramita
 */
public class test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Berapa banyak ?");
        int tiket = input.nextInt();

        for (int i = 1; i <= tiket; i++) {
            System.out.println("Tiket ke " + i);
            System.out.println("Masukkan row");
            String row = input.next();
            
            System.out.println("Masukkan seat");
            String seat = input.next();
        }
    }
}
