import java.util.ArrayList;

/**
 * Created by graf on 15.12.2016.
 */
public class ArrayListVersionTwo extends ParentForLists implements MyImplementationList{

    int[] myArray;
    int start;
    int end;

    public ArrayListVersionTwo(){
        myArray = new int[4];
    }

    public void add(int value){
        if (currentArrayIsFull()) {
            resize();
        }
        myArray[end] = value;
        end++;
        size++;
    }

    public void addToBeginning(int value) {
//        add(0, value);
        if (currentArrayIsFull()) {
            resize();
        }

        if (start == 0){
            start = myArray.length - 1;
        } else {
            start--;
        }
        myArray[start] = value;
        size++;

//        System.out.println(myArray.toString());
    }

    public void add(int index, int value) {

        ensureCapacity();
        ensureWithinBounds(index);

        int i = end;
        int workingIdx;

        if (start == 0) {
            workingIdx = index;
        } else {
            workingIdx = index - end;
        }

        while (i > 0 && i > workingIdx){
            myArray[i] = myArray[i-1];
            i--;
        }
        myArray[workingIdx] = value;
        size++;
        end++;


//        ensureWithinBounds(index);
//        if (currentArrayIsFull()) {
//            resize();
//        }
//
//        int indexPrevious = index;
//        int [] temporaryArray = new int[myArray.length];
//
//        for (int i = 0; i < index; i++){
//            temporaryArray[i] = myArray[i];
//        }
//        temporaryArray[index] = value;
//        for (int i = index + 1; i < myArray.length; i++){
//            temporaryArray[i] = myArray[indexPrevious];
//            indexPrevious++;
//        }
//
//        myArray = temporaryArray;
//        size++;
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
        if (index < 0 || index >= size){
            throw new ListIndexOutOfBoundException();
        }
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

//    public int size(){
//        return size;
//    }

    public int[] toArray(){
        int [] arrayToReturn = new int[size];
        int begin = start;
        for (int i = 0; i < size; i++){
            if (begin > 0 && begin < myArray.length){
                arrayToReturn[i] = myArray[begin];
                begin++;
            } else {
                begin = 0;
                arrayToReturn[i] = myArray[begin];
                begin++;
            }
        }
        return arrayToReturn;
    }

    public String toString(){
        String arrayToString = "";
        if (size == 0){
            return "";
        }
        int [] arrayToReturn = toArray();
        for (int i = 0; i < size; i++){
            arrayToString = arrayToString + arrayToReturn[i] + ",";
        }
        return "{" + arrayToString.substring(0,arrayToString.length() - 1) + "}";
    }


    private void resize() {
        int [] temporaryArray = toArray();
        int[] myArrayExtended = new int[size*2];
        for (int i = 0; i < size; i++){
            myArrayExtended[i] = temporaryArray[i];
        }
        start = 0;
        end = size;
        myArray = myArrayExtended;
    }

    private boolean currentArrayIsFull() {
        return size == myArray.length;
    }

    private void ensureCapacity() {
        if (currentArrayIsFull()) {
            resize();
        }
    }
}
