package LAB7_2;

public class Kierowca {

    //Dane składowe klasy Kierowca.
    public String imie;
    protected String nazwisko;
    public int wiek;
    private String pesel;

    //Konstruktor klasy Kierowca.
    public Kierowca(String imie,String nazwisko, int wiek, String pesel){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.wiek=wiek;
        this.pesel=pesel;
    }
    //Metoda wypisująca informacje o kierowcy.
    public void wypiszInformacje(){
        System.out.println("Imię: " + this.imie);
        System.out.println("Nazwisko: " + this.nazwisko);
        System.out.println("Wiek: " + this.wiek);
        System.out.println("PESEL: " + this.pesel);
    }
}
