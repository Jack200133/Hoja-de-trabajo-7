// clse paraz mostrar los datos de una mejor manera
public class Datos {
    String D1;
    String D2;
    String D3;


    public Datos(String[] data){
        D1 = data[0].toLowerCase();
        D2 = data[1].toLowerCase();
        D3 = data[2].toLowerCase();
    }

    public String getD(int i) {
        return switch (i) {
            case (1) -> D1;
            case (2) -> D2;
            default -> D3;
        };

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
