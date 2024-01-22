package LAB7_3;

import java.io.*;
public class Application3 {
    public static void main(String[] args){

    //Deklaracja ścieżki do pliku w którym zapisane zostaną elementy tablicy typów prostych.
    String filePath = "C:/Users/l.kulig/Desktop/plikiJava/tablica.txt";
    //Utworzenie obiektu PrintStream, jest to objekt strumienia wyjścia.
    PrintStream originalOut = System.out;
    try{

        //Utworznie obiektu FileOutputStream. Wskazuje on na plik do którego będą zapisywane dane.
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));

        //Utworzenie obiektu PrintScreen. Będzie on wskazywał na nasz niestandardowy strumień wyjścia.
        PrintStream customOut = new PrintStream(fileOutputStream);

        //Zapisanie niestandardowego strumienia wyjścia (PrintStream) jako standardowy strumień wyjścia.
        System.setOut(customOut);

        //Utworzenie tablicy typów prostych, a mianowicie liczb całkowitych(int).
        int[] Tablicaliczby = {1,2,6,7,44,13,89,13,2};
        //Zapisanie elementów tablicy do pliku. Wszystko co jest teraz wpisywane na System.out, będzie zapisywane do pliku.
        //Używam pętli for each żeby zapisać wszystkie elementy tablicy.
        for(int liczba : Tablicaliczby){
            System.out.println(liczba);
        }

        //Powrót do standardowego strumienia wyjścia .
        System.setOut(System.out);

        //Zamknięcie strumienia wyjścia, zamknięcie pliku.
        customOut.close();
        //System.out.println("\n Dane Tablicy zostały pomyślnie zapisane do pliku.");


    }catch(Exception e){
        e.printStackTrace();
    }finally {
        System.setOut(originalOut);
        System.out.println("\nDane Tablicy zostały pomyślnie zapisane do pliku.");
    }
        System.out.println("Co dalej? Ale to już jutro.");
        System.out.println("Czas odczytać tablice z pliku.");



    try{
        //Utworzenie obiektu FileReader. Obiekt odczytuje znaki z pliku.
        FileReader fileReader = new FileReader(filePath);
        //Utworznie obiektu BufferedReader. Obiekt umożliwia odczyt linii po linii.
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //Odczytujemy tekst z pliku linia po linii.
        String line;
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        //Zamykamy BufferedReader i FileReader
        bufferedReader.close();
        fileReader.close();

    }catch (Exception e){
        //Obsługa błędów związanych z operacją odczytu pliku.
        e.printStackTrace();
    }

    }
}
