package LAB7_8;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

//A.Utworzenie klasy Abstrakcyjnej Book.
abstract class Book{

    //Pola klasy Book.
    private String tytul;
    private String autor;
    private int rokWydania;

    //Konstruktor klasy Book.
    public Book(String tytul, String autor, int rokWydania){
        this.tytul = tytul;
        this.autor = autor;
        this.rokWydania = rokWydania;
    }
    //Gettery klasy Book.

    public String getTytul(){return tytul;}
    public String getAutor(){return autor;}
    public int getRokWydania(){return rokWydania;}


    //A. Utworznie abstrakcyjnej metody displayInfo() Metoda będzie wyświetlać info o książce.

    abstract void displayInfo();
}

//B. Utworzenie Klasy FictionBook. Klasa dziedziczy po klasie Book.
class FictionBook extends Book{

    //Pola klasy FictionBook .
    private String gatunek;
    private String jezykWydania;

    //Konstruktor klasy FictionBook.
    public FictionBook(String tytul, String autor, int rokWydania, String gatunek, String jezykWydania){

        super(tytul, autor, rokWydania); //słowo kluczowe super służy do odwołania się do pól klasy bazowej Book, a dokładnie konstruktora bazowego.
        this.gatunek = gatunek;
        this.jezykWydania = jezykWydania;
    }
    //Gettery klasy FictionBook.
    public String getGatunek(){return gatunek;}
    public String getJezykWydania(){return jezykWydania;}


    //Przesłonięcie metody displayInfo().
    @Override
    void displayInfo(){
        System.out.println("FictionBook >> Tytuł: " + getTytul() + ", Autor: " +
                getAutor() + ", Rok Wydania: " + getRokWydania() +
                ", Gatunek: " + getGatunek() + ", Język Wydania: " + getJezykWydania() );
    }
}

//B. Utworznie klasy NonFictionBook, która dziedziczy po klasie Book.

class NonFictionBook extends Book{

    //Pola klasy NonFictionBook.
    private String opis;

    //Konstruktor klasy NonFictionBook.
    public NonFictionBook(String tytul, String autor, int rokWydania, String opis){
        super(tytul, autor, rokWydania);
        this.opis = opis;
    }
    //Gettery klasy NonFictionBook.
    public String getOpis(){return opis;}

    //Przesłonięcie metody displayInfo().
    @Override
    void displayInfo(){
        System.out.println("NonFictionBook >> Tytuł: " + getTytul() + ", Autor: " +
                getAutor() + ", Rok Wydania: " + getRokWydania() +
                ", Opis: " + getOpis());
    }


}

//C. Utworzenie klasy BookManager. Klasa bedzie zwaierała listę książek.

class BookManager {

    //Pola klasy. Pole typu lista do przechowywania obiektów klasy Book.
    private List<Book> listaKsiazek;

    //Konstruktor klasy BookManager .
    public BookManager() {
        this.listaKsiazek = new ArrayList<>();
    }

    //C. Metoda dodająca ksiązki do listy. Dodawane są obiekty klasy Book, a także obiekty klas pochodnych, gdyż Book
    //jest klasą abstrakcyjną.
    public void dodajKsiazke(Book b) {
        listaKsiazek.add(b);
    }

    //C. Metoda wyświetlająca wszystkie książki.
    public void pokazKsiazki() {
        for (Book b : listaKsiazek) {
            b.displayInfo();
        }
    }

    //C. Metoda zapisująca informacje o ksiazkach do pliku.
    public void zapisDoPliku(String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {

            fileWriter.write("Katalog Ksiazek\n");
            fileWriter.write("---------------");
            fileWriter.write("\n");
            for (Book b : listaKsiazek) {
                fileWriter.write("Tytul: " + b.getTytul() + ", ");
                fileWriter.write("Autor: " + b.getAutor() + ", ");
                fileWriter.write("Rok Wydania: " + b.getRokWydania() + ", ");

                //Ten fragment bloku sprawdza jakiego typu jest obiekt i na tej podstawie dobiera jaka informacja ma być drukowana do pliku.
                //Jeżeli obiekt jest typu Fiction, wybiera dane tej klasy do zapisania w pliku.
                if (b instanceof FictionBook) {
                    fileWriter.write("Gatunek: " + ((FictionBook) b).getGatunek() + ", ");
                    fileWriter.write("Język Wydania: " + ((FictionBook) b).getJezykWydania() + ", ");
                } else if (b instanceof NonFictionBook) {
                    fileWriter.write("Opis: " + ((NonFictionBook) b).getOpis() + ", ");
                }
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //E. Odczyt danych z pliku.
    public void odczytZPliku(String filePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            System.out.println("\nWyświetlenie dancy z pliku zlokalizowanego w :" + filePath);

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
public class Application8 {
    public static void main(String[] args) {

        //Określenie ścieżki do której zapisywane będą objekty klasy BookManager.
        String filePath = "C:/Users/l.kulig/Desktop/plikiJava/BookManager.txt";


        //D.Utworznie obiektów klas FictionBook oraz NonFictionBook.
        FictionBook fb = new FictionBook("Title1 ", "Author 1 ", 1995, "gatunek1", "jezyk1");
        NonFictionBook nfb = new NonFictionBook("Tytul2", "Author2", 2012, "Opis ksiązki 2.");
        FictionBook fb1 = new FictionBook("Tytul3","Autor3",2014,"gatunek1","jezyk1");
        NonFictionBook nfb1 = new NonFictionBook("Tytul4","Autor4",2021,"Opis ksiazki 4.");
        NonFictionBook nfb2 = new NonFictionBook("Tytul5","Autor5",2018,"Opis ksiązki 5.");

        //Utworzenie obiektu klasy BookManager.
        BookManager bookManager = new BookManager();

        //D.Dodanie książek do BookManager.
        bookManager.dodajKsiazke(fb);
        bookManager.dodajKsiazke(nfb);
        bookManager.dodajKsiazke(fb1);
        bookManager.dodajKsiazke(nfb1);
        bookManager.dodajKsiazke(nfb2);

        //D.Wyświetlenie informacji o ksiazkach znajdujacych się w BookManager.
        System.out.println("Wyświetlenie informacji o wszystkich książkach.");
        System.out.println("===============================================");
        bookManager.pokazKsiazki();
        System.out.println();

        //D.Zapisanie informacji o ksiązkach do pliku.
        bookManager.zapisDoPliku(filePath);

        //E.Odczyt informacji o książkach z pliku tekstowego.
        System.out.println("Odczyt informacji o książkach z pliku tekstowego");
        System.out.println("===============================================");
        bookManager.odczytZPliku(filePath);
    }
}

