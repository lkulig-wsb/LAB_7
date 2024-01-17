package LAB7_3;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.sql.SQLOutput;

public class Application3 {
    public static void main(String[] args){

    String filePath = "C:/Users/l.kulig/Desktop/plikiJava/tablica.txt";
    PrintStream originalOut = System.out;
    try{

        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));

        PrintStream customOut = new PrintStream(fileOutputStream);

        System.setOut(customOut);

        //Utworzenie tablicy.
        int[] Tablicaliczby = {1,2,6,7,44,13,89,13,2};
        //Zapisanie elementów tablicy do pliku.
        for(int liczba : Tablicaliczby){
            System.out.println(liczba);
        }

        System.setOut(System.out);

        customOut.close();
        //System.out.println("\n Dane Tablicy zostały pomyślnie zapisane do pliku.");


    }catch(Exception e){
        e.printStackTrace();
    }finally {
        System.setOut(originalOut);
        System.out.println("\nDane Tablicy zostały pomyślnie zapisane do pliku.");
    }
        System.out.println("Co dalej? Ale to już jutro");
        System.out.println("Czas odczytać tablice z pliku..");



    try{

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        bufferedReader.close();
        fileReader.close();

    }catch (Exception e){

        e.printStackTrace();
    }


    }
}
