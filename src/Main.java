import java.io.File;
import java.util.Scanner;

public class Main {
    static BinarySearchTree bstig = new BinarySearchTree();
    static BinarySearchTree bstes = new BinarySearchTree();
    static BinarySearchTree bstfr = new BinarySearchTree();
    static int op;
    static int op2;
    public static void main(String[] args) {


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
        op = scan.nextInt();
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
                for (String s : temp) {
                    traductor(s);
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
        StringBuilder res = new StringBuilder();
        if(op == 1){
            CadaPalabra(No_traducido, res, bstig);
        }else if (op == 2){
            CadaPalabra(No_traducido, res, bstes);
        }
        else if (op == 3){
            CadaPalabra(No_traducido, res, bstfr);
        }
        System.out.println(res);
    }

    private static void CadaPalabra(String[] no_traducido, StringBuilder res, BinarySearchTree bstfr) {
        for (String s : no_traducido) {
            ComparableAssociation top = new ComparableAssociation(s);
            if (bstfr.contains(top)) {
                BinaryTree dato = bstfr.locate(bstfr.root,top);
                ComparableAssociation temp = (ComparableAssociation) dato.getValor();
                Datos dt =(Datos) temp.getValor();
                res.append(dt.getD(op2));
                res.append(" ");
            }else{
                res.append("*").append(s).append("*");
                res.append(" ");
            }
        }
    }
}
