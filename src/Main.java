import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree bstig = new BinarySearchTree();
        BinarySearchTree bstes = new BinarySearchTree();
        BinarySearchTree bstfr = new BinarySearchTree();
        Scanner scan = new Scanner(System.in);

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
        System.out.println("-----------------------------------");

        System.out.println("Ingrese que Idioma es el Texto");
        System.out.println("1. Ingles");
        System.out.println("2. Espanol");
        System.out.println("3. Frances");
        int op = scan.nextInt();
        int op2= 0;
        if(op == 1){
            System.out.println("Ingrese que Idioma desea de salida");
            System.out.println("2. Espanol");
            System.out.println("3. Frances");
            op2 = scan.nextInt();
        }
        else if(op == 2){
            System.out.println("Ingrese que Idioma desea de salida");
            System.out.println("1. Ingles");
            System.out.println("3. Frances");
            op2 = scan.nextInt();
        } else if(op == 3){
            System.out.println("Ingrese que Idioma desea de salida");
            System.out.println("1. Ingles");
            System.out.println("2. Espanol");
            op2 = scan.nextInt();
        }

        try {
            File myObj = new File("texto.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] temp = data.split("\\.");
                for (int i = 0; i < temp.length; i++) {
                    traductor(temp[i]);
                }
            }
            myReader.close();
        }catch (Exception e) {
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        }

    }

    public static void traductor(String oracion){
        String[] No_traducido = oracion.split(" ");


    }
}
