/**
 * Created by graf on 16.12.2016.
 */
public abstract class ParentForLists {
    int size;

    public int size(){
        return size;
    }

    public void ensureWithinBounds(int index) {
        if (index < 0 || index > size){
            throw new ListIndexOutOfBoundException();
        }
    }
}
