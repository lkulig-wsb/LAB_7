package LAB7_5;

public class Kierowca {
    public String imie;
    protected String nazwisko;
    public int wiek;
    private String pesel;

    public Kierowca(String imie,String nazwisko, int wiek, String pesel){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.wiek=wiek;
        this.pesel=pesel;
    }
    public void wypiszInformacje(){
        System.out.println("Imię: " + this.imie);
        System.out.println("Nazwisko: " + this.nazwisko);
        System.out.println("Wiek: " + this.wiek);
        System.out.println("PESEL: " + this.pesel);
    }
    public String infoToSave(){
        return "Imię: " + this.imie + "\n" +
                "Nazwisko: " + this.nazwisko + "\n" +
                "Wiek: " + this.wiek + "\n" +
                "PESEL: " + this.pesel + "\n";
    }
}
