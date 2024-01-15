package LAB7_2;
public class Application2 {
    public static void main(String[] args){

        //Utworzenie obiektów klasy Kierowca i Klasy Auto
        Kierowca k1 = new Kierowca("Jan","Kowalski",32,"89051298673");
        Auto a1 = new Auto("W VGZZZ5N Z 8 W 031284",2011,"Ford","Mondeo");

        //Wypisanie danych obiektu typu Kierowca i obiektu typu Auto
        k1.wypiszInformacje();
        System.out.println();
        a1.wypiszAuto();

    }
}
