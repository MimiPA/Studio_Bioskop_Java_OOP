/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Paramita
 */
public class Bioskop {

    private static Scanner input = new Scanner(System.in);
    public static String menu;
    static Studio xxi;

    public static void main(String[] args) {
        System.out.println("Masukkan nama anda");
        String nama = input.nextLine();
        xxi = new Studio(nama);
        xxi.setNama(nama);

        System.out.println("\n===================================================\n");

        System.out.println("Welcome, " + xxi.getNama());

        while (true) {
            showMenu(menu);
        }
    }

    public static void showMenu(String menu) {
        try {
            System.out.println("\n===================================================\n");

            File myObj = new File("menu.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();

            System.out.print("Pilih menu > ");
            String selectedMenu = input.nextLine();

            if (selectedMenu.equals("1")) {
                System.out.println("Masukkan studio baru");
                String newStudio = input.nextLine();

                System.out.println("Masukkan nama film baru");
                String newFilm = input.nextLine();
                xxi.addStudio(newStudio, newFilm);

            } else if (selectedMenu.equals("2")) {
                xxi.viewStudio();
                System.out.print("Pilih index > ");
                String edit = input.nextLine();

                System.out.println("Masukkan nama film baru");
                String newFilm = input.nextLine();
                xxi.editStudio(edit, newFilm);

            } else if (selectedMenu.equals("3")) {
                xxi.viewStudio();

                System.out.println("Apakah anda ingin melihat tempat diduduk pada studio yang tersedia ? (Y/N)");
                String jawab = input.nextLine();

                if (jawab.equalsIgnoreCase("Y")) {
                    System.out.println("Harap masukkan nama studio yang ingin dilihat (Perhatikan huruf besar kecil !)");
                    String namaStudio = input.nextLine();
                    xxi.viewSeat(namaStudio);
                }
                else if(jawab.equalsIgnoreCase("N")){
                    
                }
                else{
                    System.out.println("Anda salah memilih jawaban");
                }

            } else if (selectedMenu.equals("4")) {
                xxi.viewStudio();
                System.out.println("Masukkan nama studio yang diinginkan (Perhatikan huruf besar kecil !)");
                String namaStudio = input.nextLine();
                xxi.viewSeat(namaStudio);

                System.out.println("Kursi dengan tanda @ telah dibeli ! Harap jangan mengambil kursi orang !!!");
                System.out.println("Berapa banyak anda ingin membeli tiket ?");
                int tiket = input.nextInt();

                String[] rowArray = new String[tiket];
                String[] seatArray = new String[tiket];

                for (int i = 1; i <= tiket; i++) {
                    System.out.println("Tiket " + i);
                    System.out.print("Masukkan row [A-J] ke- ");
                    String row = input.next();
                    rowArray[i - 1] = row;
                    xxi.setRow(rowArray);

                    System.out.print("Masukkan seat [1-20] ke - ");
                    String seat = input.next();
                    seatArray[i - 1] = seat;
                    xxi.setSeat(seatArray);
                }

                xxi.buyTicket(namaStudio);
            } else if (selectedMenu.equals("5")) {
                System.exit(0);
            } else {
                System.out.println("Kamu salah pilih menu! Silahkan pilih ulang");
                showMenu(menu);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error => " + e);
        }
    }
}
