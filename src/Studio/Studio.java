/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studio;

import Studio.Pengguna;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Paramita
 */
public class Studio extends Pengguna implements StudioMenu {

    static ArrayList<String> studioList;

    public Studio(String nama) {
        super(nama);
    }

    @Override
    public void addStudio(String studio, String film) {
        try {
            FileWriter fileWriter = new FileWriter("studio.txt", true);
            fileWriter.append(String.format("%s%n", "Studio " + studio + " : " + film));
            fileWriter.close();

            File myObj = new File("Studio " + studio + ".txt");
            if (myObj.createNewFile()) {
                PrintWriter myWriter = new PrintWriter("Studio " + studio + ".txt");

                char a = 'a';
                for (int i = 0; i < 11; i++) {
                    for (int j = 0; j < 21; j++) {
                        if (i == 0 && j == 0) {
                            myWriter.print("+ ");
                        } else if (j == 0 && i != 0) {
                            myWriter.print(a + " ");
                            a++;
                        } else if (i == 0 && j != 0) {
                            myWriter.print("\t" + j);
                        } else {
                            myWriter.print("\t*");
                        }
                    }
                    myWriter.println("");
                }

                myWriter.close();
                System.out.println("Studio created: " + myObj.getName());
                System.exit(0);
            } else {
                System.out.println("Studio already exists.");
                System.exit(0);
            }
        } catch (IOException ex) {
            System.out.println("Error => " + ex);
        }
    }

    @Override
    public void editStudio(String index, String film) {
        readStudio();
        System.out.println("----------------------------------------------------");
        int cursor = Integer.parseInt(index);

        try {
            if (cursor > studioList.size()) {
                throw new IndexOutOfBoundsException("Kamu memasukan data yang salah!");
            } else {
                String isi = studioList.get(cursor).toString();
                int titik = isi.indexOf(":") + 1;
                String replace = isi.substring(++titik, isi.length());
                String detail = isi.replace(replace, film);

                studioList.set(cursor, detail);
                System.out.println(studioList.toString());

                try {
                    FileWriter fileWriter = new FileWriter("studio.txt", false);

                    // write new data
                    for (String data : studioList) {
                        fileWriter.append(String.format("%s%n", data));
                    }
                    fileWriter.close();

                    System.out.println("Berhasil diubah!");
                    System.exit(0);
                } catch (IOException e) {
                    System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error > " + e.getMessage());
        }
    }

    @Override
    public void viewStudio() {
        try {
            System.out.println("-----------------------------------------------");
            int i = 0;
            File myObj = new File("studio.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(i + ". " + data);
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void buyTicket() {
        try {
            String[] seat = getSeat();
            String[] row = getRow();
        } catch (Exception e) {
            System.out.println("Error > " + e.getMessage());
        }
    }

    @Override
    public void viewSeat(String studio) {
        try {
            System.out.println("-----------------------------------------------");
            File myObj = new File(studio + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
            System.out.println("-----------------------------------------------");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    public void readStudio() {
        try {
            studioList = new ArrayList<>();
            File file = new File("studio.txt");
            Scanner fileReader = new Scanner(file);

            // load isi file ke dalam array todoLists
            studioList.clear();
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                studioList.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error > " + e.getMessage());
        }
    }

}
