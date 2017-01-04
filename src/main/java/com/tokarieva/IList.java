package com.tokarieva;

import com.tokarieva.exception.ListIndexOutOfBoundException;

import java.util.Iterator;

public interface IList<E> extends Iterable<E>{

    void add(E value);
    void addToBeginning(E value);
    void add(int index, E value);
    <E> E [] toArray();
    int size();
    void clear();
    String toString();
    boolean contains(E value);
    E get(int index) throws ListIndexOutOfBoundException;
    void remove(int index);
    void remove(E value);
    void set(int index, E value);
//    Iterator <E> iterator();
}
