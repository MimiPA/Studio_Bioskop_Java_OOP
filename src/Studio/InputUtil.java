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
public class InputUtil {

    private static Scanner input = new Scanner(System.in);

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = input.nextLine();
        return data;
    }
}
