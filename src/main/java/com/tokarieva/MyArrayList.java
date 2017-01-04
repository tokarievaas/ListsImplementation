package com.tokarieva;

import com.tokarieva.exception.ListIndexOutOfBoundException;

import java.io.Serializable;
import java.util.Iterator;


public class MyArrayList<E> extends AbstractList<E> implements Serializable {

    private Object[] myArray;
    int start;
    int end;

    public MyArrayList(){
        myArray = new Object[4];
    }

    public void add(E value) {
        ensureCapacity();
        myArray[end] = value;
        end++;
        size++;
    }

    public void addToBeginning(E value) {
        ensureCapacity();

        if (start == 0){
            start = myArray.length - 1;
        } else {
            start--;
        }
        myArray[start] = value;
        size++;
    }

    public void add(int index, E value) {

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
    }

    public boolean contains(E value) {
        for (int i = 0; i < size; i++){
            if (myArray[i] == value){
                return true;
            }
        }
        return false;
    }

    public E get(int index) {
        ensureWithinBounds(index);
        if (index < 0 || index >= size){
            throw new ListIndexOutOfBoundException();
        }
        return (E)myArray[index];
    }

    public void remove(int index) {
        ensureWithinBounds(index);
        for (int i = index; i < size - 1; i++){
            myArray[i] = myArray[i+1];
        }
        size--;
    }

    public void remove(E value){
        int index = -1;

        for (int i = index + 1; i < size; i++){
            if (myArray[i].equals(value)){
                index = i;
            }
        }

        if (index == -1){
            System.out.println("No such element!");
        } else {
            remove(index);
        }
    }

    public void set(int index, E value) {
        ensureWithinBounds(index);
        myArray[index] = value;
    }


    public E[] toArray(){
        Object [] arrayToReturn = new Object[size];
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
        return (E[])arrayToReturn;
    }

    public String toString(){
        String arrayToString = "";
        if (size == 0){
            return "";
        }
        Object [] arrayToReturn = toArray();
        for (int i = 0; i < size; i++){
            arrayToString = arrayToString + arrayToReturn[i] + ",";
        }
        return "{" + arrayToString.substring(0,arrayToString.length() - 1) + "}";
    }

    public boolean equals(Object other){
        if (!(other instanceof MyArrayList)){
            return false;
        }
        return super.equals(other);

    }

    private void resize() {
        E [] temporaryArray = toArray();
        E [] myArrayExtended = (E[])new Object[size*2];
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


//**************alternative***********************
    public Iterator<E> iterator() {
        return new MyArrayListIterator<E>();
    }

    private class MyArrayListIterator<E> implements Iterator<E>{
        int currentIdx = 0;

        public boolean hasNext() {
            return (currentIdx) != size;
        }

        public E next() {
            Object[] elementData = MyArrayList.this.myArray;
            return (E) elementData[currentIdx++];
        }
    }
//*************************************************

//    public Iterator <E> iterator() {
//        return new Iterator() {
//            int currentIdx = - 1;
//            public boolean hasNext() {
//                if ((currentIdx + 1) != size) {
//                    return true;
//                }
//                return false;
//            }
//
//            public E next() {
////                currentIdx++;
//                return (E)myArray[++currentIdx];
//            }
//        };
//    }
}
