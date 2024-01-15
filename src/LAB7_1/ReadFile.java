package LAB7_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadFile {
    public static void main(String[] args){

        //Ścieżka do pliku.
        String filePath = "C:/Users/l.kulig/Desktop/plikiJava/file.txt";

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

        } catch(IOException e) {

            //Obsługa błędów związanych z operacją odczytu pliku.
            e.printStackTrace();
        }
    }
}
