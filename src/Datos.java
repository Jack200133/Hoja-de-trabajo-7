public class Datos {
    String D1;
    String D2;
    String D3;


    public Datos(String[] data){
        D1 = data[0];
        D2 = data[1];
        D3 = data[2];
    }

    @Override
    public String toString() {
        return "{" +
                 D1  +
                "," + D2  +
                "," + D3 +
                '}';
    }
}
