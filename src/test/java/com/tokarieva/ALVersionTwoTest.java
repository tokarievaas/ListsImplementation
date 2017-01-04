package com.tokarieva;

import org.junit.Before;

public class ALVersionTwoTest extends AbstractMyImplementationListTest {
    @Before
    public void setUp(){
        newList = new MyArrayList<Integer>();
        newList1 = new MyArrayList<Integer>();
        newListDifferentInstance = new MyLinkedList<Integer>();
        newListObjectInstance = new MyArrayList<Object>();
        newListString = new MyArrayList<String>();
    }
}
