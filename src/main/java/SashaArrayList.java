import java.lang.reflect.Array;

/**
 * Created by graf on 28.11.2016.
 */
public class SashaArrayList implements SashaList {

    int size;
    int[] myArray;

    public SashaArrayList(){
        myArray = new int[4];
    }

    public void add(int value){
        if (currentArrayIsFull()) {
            resize();
        }
        myArray[size] = value;
        size++;
    }

    public void addToBeginning(int value) {
        add(0, value);
    }

    public void add(int index, int value) {
        if (currentArrayIsFull()) {
            resize();
        }
        int indexPrevious = index;
        int [] temporaryArray = new int[myArray.length];

        for (int i = 0; i < index; i++){
            temporaryArray[i] = myArray[i];
        }
        temporaryArray[index] = value;
        for (int i = index + 1; i < myArray.length; i++){
            temporaryArray[i] = myArray[indexPrevious];
            indexPrevious++;
        }
        myArray = temporaryArray;
        size++;
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
        if (index < 0 || index >= size){
            throw new ListIndexOutOfBoundException();
        }
        return myArray[index];
//        try {
//            return myArray[index];
//        } catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("No such value in array!");
//            throw new ListIndexOutOfBoundException();
//        }
    }

    public void remove(int index) {
        for (int i = index; i < size - 1; i++){
            myArray[i] = myArray[i+1];
        }
        size--;
    }

    public void set(int index, int value) {
//        myArray[index] =
    }

    public int size(){
        return size;
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
}
