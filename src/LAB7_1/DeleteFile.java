package LAB7_1;
import java.io.File;
public class DeleteFile {

    public static void main(String[] args) {

        //Ścieżka do pliku, który chcemy usunąć:
        String filePath = "C:/Users/l.kulig/Desktop/plikiJava/file.txt";

        //Utworznie obiektu File. Będzie on reprezentował plik.

        File fileToDelete = new File(filePath);

        //Sprawdzenie czy plik istnieje przed jego usunięciem.

        if (fileToDelete.exists()) {
            //Usuwamy plik.\
            if (fileToDelete.delete()) {
                System.out.println("File was deleted successfully!");
            } else {
                System.out.println("Couldn't delete the file!");
            }
        }else{
            System.out.println("File does not exist!");
        }

        }
    }

