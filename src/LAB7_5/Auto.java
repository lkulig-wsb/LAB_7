package LAB7_5;
public class Auto {

    private String vin;
    protected int rocznik;
    public String marka;
    public String model;

    public Auto(String vin, int rocznik,String marka,String model){
        this.vin=vin;
        this.rocznik=rocznik;
        this.marka=marka;
        this.model=model;
    }
    public void wypiszAuto(){
        System.out.println("VIN: " + this.vin);
        System.out.println("Rocznik: " + this.rocznik);
        System.out.println("Marka: " + this.marka);
        System.out.println("Model: " + this.model);
    }
    public String infoToSave(){
        return "Marka: " + this.marka + "\n" +
                "Model: " + this.model + "\n" +
                "Rocznik: " + this.rocznik + "\n" +
                "VIN: " + this.vin + "\n";
    }
}
