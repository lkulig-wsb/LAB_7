package LAB7_6;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

 class Ksiazka{

    private String tytul;
    private String autor;
    private int rokWydania;
    private String gatunek;
    private String jezykWydania;

    public Ksiazka(String tytul, String autor, int rokWydania, String gatunek, String jezykWydania){
        this.tytul = tytul;
        this.autor = autor;
        this.rokWydania = rokWydania;
        this.gatunek = gatunek;
        this.jezykWydania = jezykWydania;
    }

    public String getTytul(){return this.tytul;}
    public String getAutor(){return this.autor;}
    public int  getRokWydania(){return this.rokWydania;}
    public String getGatunek(){return this.gatunek;}
    public String getJezykWydania() {return this.jezykWydania;}
}
public class Application6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String filePath ="C:/Users/l.kulig/Desktop/plikiJava/ksiazkaInfo.txt";

        System.out.println("Podaj tytuł książki: ");
        String tytul = scanner.nextLine();
        System.out.println("Podaj autora książki: ");
        String autor = scanner.nextLine();
        System.out.println("Podaj rok wydania książki: ");
        int rokWydania = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj gatunek książki: ");
        String gatunek = scanner.nextLine();
        System.out.println("Podaj język wydania książki: ");
        String jezykWydania = scanner.nextLine();

        Ksiazka k1 = new Ksiazka(tytul,autor,rokWydania,gatunek,jezykWydania);

        try{

            //LAB7_7 - parametr append ustawiony na true pozwoli na dopisanie obiektu do pliku. Bez tego parametru plik będzie nadpisywany.
            FileWriter fileWriter = new FileWriter(filePath,true);

            fileWriter.write("Tytuł: " + k1.getTytul()+"\n");
            fileWriter.write("Autor: " + k1.getAutor()+"\n");
            fileWriter.write("Rok Wydania: " + k1.getRokWydania()+"\n");
            fileWriter.write("Gatunek: " + k1.getGatunek()+"\n");
            fileWriter.write("Język wydania: " + k1.getJezykWydania()+"\n");
            fileWriter.write("\n");

            fileWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            scanner.close();
            System.out.println("\nDane zostały pomyślnie zapisane do pliku ksiazkaInfo.txt ");
        }
    }
}
