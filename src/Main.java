import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree bstig = new BinarySearchTree();
        BinarySearchTree bstes = new BinarySearchTree();
        BinarySearchTree bstfr = new BinarySearchTree();

        try {
            File myObj = new File("diccionario.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] temp = data.split(",");
                Datos dt = new Datos(temp);
                ComparableAssociation ingl = new ComparableAssociation(temp[0],dt);
                ComparableAssociation espa = new ComparableAssociation(temp[1],dt);
                ComparableAssociation fran = new ComparableAssociation(temp[2],dt);

                bstig.add(ingl);
                bstes.add(espa);
                bstfr.add(fran);
            }
            myReader.close();
        }catch (Exception e) {
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        }
        System.out.println("Print INORDER de las traducciones");
        System.out.println("-----------------------------------");
        bstig.iterator();

    }
}
