package LAB7_4;

import java.io.*;
//Utworzenie klasy Osoba. Klasa implementuje interface Serializable.
// Pozwoli to na serializację objektów(czyli ich zmianę na sekwencję bitów.)
//Ułatwia to zapisywanie objektów do pliku, przesyłania przez sieć.
class Osoba implements Serializable {
    private String imie;
    private String nazwisko;
    private int wiek;

    //Konstruktor klasy Osoba.
    public Osoba (String imie, String nazwisko, int wiek){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.wiek=wiek;
    }

    //Metoda wyświetlająca dane Osoby.
    public void dispInfo(){
        System.out.println("Imię: " + this.imie + ", Nazwisko: " + this.nazwisko + ", Wiek: " + this.wiek);
    }


}
public class Application4 {
    public static void main(String[] args){
        //Ścieżka do pliku z zaserialiowanymi elementami tablicy objektów.
        String filePath = "C:/Users/l.kulig/Desktop/plikiJava/tablica_obj.txt";
        //Scieżka do w której znajdować się będą deserializowane dane tablicy objektów.
        String fileDeserialized = "C:/Users/l.kulig/Desktop/plikiJava/tablica_obj_des.txt";

        PrintStream originalOut = System.out;

        try{

            ////Utworznie obiektu FileOutputStream. Wskazuje on na plik do którego będą zapisywane dane.
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));

           //Utworznie objektu ObjectOutputStream. Będzie on uzywany do zapisywania objektów do strumienia bajtów.
            // Umożliwi to serializację objektów i ich zapisanie do pliku.
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);


            //Utworznie tablicy objektów.
            Osoba[] osobyTablica = {
                    new Osoba("Jan","Kowalski",23),
                    new Osoba("Maria","Klimczak",21),
                    new Osoba("Łukasz","Nowak",18),
                    new Osoba("Dawid","Waśko",23)
            };

            //Zapisanie tablicy do strumienia bajtów.
            objectOutputStream.writeObject(osobyTablica);

            //Zamknięcie objektu objectOutputStream, ukończenie zapisu pliku.
            objectOutputStream.close();

        }catch(Exception e){
            e.printStackTrace();
        } finally { //przywrócenie standardowego strumienia wyjścia.
            System.setOut(originalOut);
            System.out.println("\nDane Tablicy Objektów zostały pomyślnie zapisane do pliku.");
        }

        try{

            //Utworznie objektu  FileInputStream do służy do odczytu danych z pliku.
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));

            //Utworznie objektu  ObjectInputStream do odczytu zserializowanej tablicy objektów.
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

           //Deserializacja

            Osoba[] zaladowanaTablica = (Osoba[]) objectInputStream.readObject();
            for(Osoba o: zaladowanaTablica){
                o.dispInfo();
            }

            objectInputStream.close();

        }catch (Exception e){

            e.printStackTrace();
        }

    }
}
