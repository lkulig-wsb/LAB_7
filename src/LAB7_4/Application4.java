package LAB7_4;

import javax.sound.midi.Soundbank;
import java.io.*;
class Osoba implements Serializable {
    private String imie;
    private String nazwisko;
    private int wiek;

    public Osoba (String imie, String nazwisko, int wiek){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.wiek=wiek;
    }

    public void dispInfo(){
        System.out.println("Imię: " + this.imie + ", Nazwisko: " + this.nazwisko + ", Wiek: " + this.wiek);
    }


}
public class Application4 {
    public static void main(String[] args){
        //Ścieżka do pliku
        String filePath = "C:/Users/l.kulig/Desktop/plikiJava/tablica_obj.txt";
        String fileDeserialized = "C:/Users/l.kulig/Desktop/plikiJava/tablica_obj_des.txt";
        PrintStream originalOut = System.out;

        try{

            ////Utworznie obiektu FileOutputStream. Wskazuje on na plik do którego będą zapisywane dane.
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);


            Osoba[] osobyTablica = {
                    new Osoba("Jan","Kowalski",23),
                    new Osoba("Maria","Klimczak",21),
                    new Osoba("Łukasz","Nowak",18),
                    new Osoba("Dawid","Waśko",23)
            };
            objectOutputStream.writeObject(osobyTablica);

            objectOutputStream.close();

        }catch(Exception e){
            e.printStackTrace();
        } finally {
            System.setOut(originalOut);
            System.out.println("\nDane Tablicy Objektów zostały pomyślnie zapisane do pliku.");
        }

        try{

            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
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
