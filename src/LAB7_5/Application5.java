package LAB7_5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Application5 {
    public static void main(String[] args){

        //Utworzenie obiektów klasy Kierowca i Klasy Auto.
        Kierowca k1 = new Kierowca("Jan","Kowalski",32,"89051298673");
        Auto a1 = new Auto("W VGZZZ5N Z 8 W 031284",2011,"Ford","Mondeo");

        //Wypisanie danych obiektu typu Kierowca i obiektu typu Auto
        k1.wypiszInformacje();
        System.out.println();
        a1.wypiszAuto();

        //Zapis info o kierowcy do pliku.
        String filePathKierowca = "C:/Users/l.kulig/Desktop/plikiJava/";
        String fileNameKierowca = "kierowcaInfo.txt";
        savetoFile(filePathKierowca,fileNameKierowca,k1.infoToSave());

        //Zapisz info o Aucie do pliku
        String filePathAuto = "C:/Users/l.kulig/Desktop/plikiJava/";
        String fileNameAuto = "autoInfo.txt";
        savetoFile(filePathAuto,fileNameAuto, a1.infoToSave());
    }
    //Metoda do zapisu danych do pliku.
    //Metoda jako argumenty przyjmuje ścieżkę do pliku, nazwę pliku oraz dane do zapisu.
    //Metoda tworzy objekt FileWriter i operacj write() do zapisu danych do pliku.
    private static void savetoFile(String path, String fileName, String data){

        try(FileWriter fileWriter = new FileWriter(path + File.separator + fileName)){
            fileWriter.write(data);
            System.out.println("Dane zapisan: " +  path + File.separator + fileName);
        }catch (IOException e){
            System.err.println("Błąd podczas zapisu: " + e.getMessage());
        }
    }
}
