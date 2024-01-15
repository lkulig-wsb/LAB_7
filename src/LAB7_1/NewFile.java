package LAB7_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.util.Scanner;

public class NewFile {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //System.out.println("Provide file path:");
        String filePath = "C:/Users/l.kulig/Desktop/plikiJava/";
        System.out.println("Provide file name: ");
        String fileName = scanner.nextLine();
        System.out.println("Provide file extension: ");
        String fileExtension = scanner.nextLine();

        try {

            //Utworzenie obiektu File który bedzie reprezentował plik
            File newFile = new File(filePath+fileName+"."+fileExtension);

            //Sprawdzenie czy plik już istnieje
            if(newFile.createNewFile()){
                System.out.println("File was created successfully!");
            }else{
                System.out.println("File already exists!");
            }


        } catch (IOException e) {
            //Obsługa błędów związanych z operacją tworzenia pliku
            e.printStackTrace();

        }
    }
}