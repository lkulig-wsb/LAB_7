package LAB7_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
public class TextFile {

    public static void main(String[] args){

        //Ścieżka do pliku gdzie bedziemy dawać wyjście.
        String filePath = "C:/Users/l.kulig/Desktop/plikiJava/file.txt";
        PrintStream originalOut = System.out;

        try{

            //Utworznie obiektu FileOutputStream. Wskazuje on na plik do którego będą zapisywane dane.
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));

            //Utworzenie obiektu PrintScreen. Będzie on wskazywał na nasz niestandardowy strumień wyjścia.
            PrintStream customOut = new PrintStream(fileOutputStream);

            //Zapisanie niestandardowego strumienia wyjścia (PrintStream) jako standardowy strumień wyjścia.
            System.setOut(customOut);

            //Wszystko co zostanie wpisane na System.out, zostanie zapisane do pliku.

            //Przykład:

            System.out.println("To jest przykładowa linia tekstu która zostanie wpisana do pliku.");
            System.out.println("A to kolejna linia.");
            System.out.println("A to kolejna linia.");

            //Powrót do standardowego strumienia wyjścia .
            System.setOut(System.out);

            //Zamknięcie strumienia wyjścia, a jednocześnie zamknięcie pliku.
            customOut.close();
            //System.out.println("\n Dane zostały zapisane do pliku.");


        }catch(Exception e){
            //Obsługa błędów związanych z operacją zapisu danych do pliku.
            e.printStackTrace();
        } finally {
            System.setOut(originalOut);

            System.out.println("\n Dane zostały zapisane do pliku.");
        }
    }
}
