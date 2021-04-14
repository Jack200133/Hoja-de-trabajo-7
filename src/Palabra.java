public class Palabra<K, V> {

    protected K llave;
    protected V valores;

    public Palabra(K lla,V val){
        llave = lla;
        valores= val;
    }

    public K getLlave() {
        return llave;
    }

    public V getValores() {
        return valores;
    }
}
