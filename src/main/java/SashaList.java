import java.lang.reflect.Array;

/**
 * Created by graf on 28.11.2016.
 */
public interface SashaList {
    void add(int i);
    void addToBeginning(int value);
    void add(int index, int value);
    void clear();
    boolean contains(int value);
    int get(int index) throws ListIndexOutOfBoundException;   //no such element???
    void remove(int index);
    void set(int index, int value);   //???? should be a value?
    int size();
    String toString();
    int[] toArray();
}
