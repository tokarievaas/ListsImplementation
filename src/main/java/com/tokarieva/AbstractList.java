package com.tokarieva;

import com.tokarieva.exception.ListIndexOutOfBoundException;

import java.io.Serializable;
import java.util.Iterator;

public abstract class AbstractList<E> implements IList <E>, Serializable {
    int size;

    public int size(){
        return size;
    }

    public void clear(){
        size =0;
    }

    public void ensureWithinBounds(int index) {
        if (index < 0 || index > size){
            throw new ListIndexOutOfBoundException();
        }
    }

    public boolean equals(Object other){
        if (this == other){
            return true;
        }
        if (other == null){
            return false;
        }
        if (!(other instanceof IList)){
            return false;
        }

        IList otherList = (IList) other;
        if (otherList.size() != this.size()){
            return false;
        }

        //check that every element in other list is equal to every element in this list
        Iterator iterator = otherList.iterator();

        for (E element: this){
            if (!iterator.next().equals(element)){
                return false;
            }
        }



//        for (int i = 0; i < il.size(); i++) {
//            if (il.get(i) != this.get(i)){
//                return false;
//            }
//        }



        return true;
    }
}
