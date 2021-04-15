import java.util.Map;
// clase de asociacion para guardar los datos y poder asociarlos y comprarlos (basada ern la viste en clase)
public class Association <K,V> implements MapEntry<K,V>{


    protected K theKey; // the key of the key-value pair

    protected V theValue; // the value of the key-value pair

    public Association(K key, V value)
    {
        theKey = key;
        theValue = value;
    }


    public Association(K key)
    {
        this(key,null);
    }


    public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }


    public int hashCode()
    {
        return getKey().hashCode();
    }


    public V getValor()
    {
        return theValue;
    }


    public K getKey()
    {
        return theKey;
    }

    public V setValor(V value)
    {
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }

    public String toString()
    {
        return "<Association: " + getKey() + "=" + getValor() + ">";
    }
}

