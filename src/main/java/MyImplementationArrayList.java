/**
 * Created by graf on 28.11.2016.
 */
public class MyImplementationArrayList extends ParentForLists implements MyImplementationList {

//    int size;   //modificators
    private int[] myArray;

    public MyImplementationArrayList(){
        myArray = new int[4];
    }

    public void add(int value){
        ensureCapacity();
        myArray[size] = value;
        size++;
    }

    public void addToBeginning(int value) {
        add(0, value);
    }

    public void add(int index, int value) {
        ensureCapacity();
        ensureWithinBounds(index);
//        for (int i = size; i > index; i--){
//            myArray[i] = myArray[i-1];
//        }
        int i = size;

        while (i > 0 && i > index){
            myArray[i] = myArray[i-1];
            i--;
        }
        myArray[index] = value;
        size++;
    }

    public void clear(){
        size =0;
    }

    public boolean contains(int value) {
        for (int i = 0; i < size; i++){
            if (myArray[i] == value){
                return true;
            }
        }
        return false;
    }

    public int get(int index) {
        ensureWithinBounds(index);
        return myArray[index];
    }


    public void remove(int index) {
        ensureWithinBounds(index);
        for (int i = index; i < size - 1; i++){
            myArray[i] = myArray[i+1];
        }
        size--;
    }

    public void set(int index, int value) {
        ensureWithinBounds(index);
        myArray[index] = value;
    }

    public int[] toArray(){
        int [] arrayToReturn = new int[size];
        for (int i = 0; i < size; i++){
            arrayToReturn[i] = myArray[i];
        }
        return arrayToReturn;
    }

    public String toString(){
        String arrayToString = "";
        for (int i = 0; i < size; i++){
            arrayToString = arrayToString + myArray[i] + ",";
        }
        return "{" + arrayToString.substring(0,arrayToString.length() - 1) + "}";
    }

    private void ensureCapacity() {
        if (currentArrayIsFull()) {
            resize();
        }
    }

    private void resize() {
        int[] myArrayExtended = new int[size*2];
        for (int i = 0; i < size; i++){
            myArrayExtended[i] = myArray[i];
        }
        myArray = myArrayExtended;
    }

    private boolean currentArrayIsFull() {
        return size == myArray.length;
    }
}
