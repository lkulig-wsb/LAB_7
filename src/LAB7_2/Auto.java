package LAB7_2;
public class Auto {

    //Dane składowe(atrybuty) klasy Auto.
    private String vin;
    protected int rocznik;
    public String marka;
    public String model;

    //Konstruktor klasy Auto.
    public Auto(String vin, int rocznik,String marka,String model){
        this.vin=vin;
        this.rocznik=rocznik;
        this.marka=marka;
        this.model=model;
    }
    //Metoda wypisująca dane na temat auta.
    public void wypiszAuto(){
        System.out.println("VIN: " + this.vin);
        System.out.println("Rocznik: " + this.rocznik);
        System.out.println("Marka: " + this.marka);
        System.out.println("Model: " + this.model);
    }
}
