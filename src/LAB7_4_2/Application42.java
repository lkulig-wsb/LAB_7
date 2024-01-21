package LAB7_4_2;

import javax.sound.midi.Soundbank;
import java.io.*;
class Osoba2 implements Serializable {
    private String imie;
    private String nazwisko;
    private int wiek;

    public Osoba2 (String imie, String nazwisko, int wiek){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.wiek=wiek;
    }
    public void dispInfo(){
        System.out.println("Imię: " + this.imie + ", Nazwisko: " + this.nazwisko + ", Wiek: " + this.wiek);
    }
    public String getInfoString(){
        return "Imię: " + this.imie + ", Nazwisko: " + this.nazwisko + ", Wiek: " + this.wiek;
    }


}
public class Application42 {
    public static void main(String[] args){
        //Ścieżka do pliku
        String filePath = "C:/Users/l.kulig/Desktop/plikiJava/tablica_obj_des.txt";

        PrintStream originalOut = System.out;

        try{

            //Utworznie obiektu BufferedWriter do zapisu tekstu do pliku.
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));

            //Tablica objektów.
            Osoba2[] osobyTablica = {
                    new Osoba2("Jan","Kowalski",23),
                    new Osoba2("Maria","Klimczak",21),
                    new Osoba2("Łukasz","Nowak",18),
                    new Osoba2("Dawid","Waśko",23)
            };
            //Zapisanie informacji o osobach do pliku
            for(Osoba2 o : osobyTablica){
                bufferedWriter.write(o.getInfoString());
                bufferedWriter.newLine();//Utorzenie nowej linii, lepsza czytelność
            }
            bufferedWriter.close();
            //Odczytanie danych z pliku.
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            System.out.println("\n Wyświetlenie dancy z pliku zlokalizowanego pod filePath:");

            while((line = bufferedReader.readLine()) !=null){
                System.out.println(line);
            }
            bufferedReader.close();



        }catch(Exception e){
            e.printStackTrace();
        } finally {
            System.setOut(originalOut);
            System.out.println("\nDane Tablicy Objektów zostały pomyślnie zapisane do pliku.");
        }

    }
}