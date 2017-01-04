package com.tokarieva;

import org.junit.Before;

public class LLVersionTwoTest extends AbstractMyImplementationListTest{
    @Before
    public void setUp(){
        newList = new MyLinkedList();
        newList1 = new MyLinkedList<Integer>();
        newListDifferentInstance = new MyArrayList<Integer>();
        newListObjectInstance = new MyLinkedList<Object>();
        newListString = new MyLinkedList<String>();
    }
}
