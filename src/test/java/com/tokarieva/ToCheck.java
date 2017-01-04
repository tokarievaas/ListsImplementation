package com.tokarieva;

import com.tokarieva.IList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToCheck {
    public static void main(String[] args) {

//        Iterator it =

        List <Integer> myList = new ArrayList<Integer>();
//        MyArrayList <Integer> mmm= new MyArrayList<Integer>();
//        MyLinkedList<Integer> nnn = new MyLinkedList<Integer>();

//        GenericListMethods glm = new GenericListMethods();
//        Integer [] intArray = {1,2,3,4};
//        glm.printArray(intArray);
//        Double [] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
//        glm.printArray(doubleArray);

//        com.tokarieva.ToCheck tc = new com.tokarieva.ToCheck();

//        MyImplementationList mlal1 = new MyImplementationArrayList();
////        ArrayList <MyImplementationList>
//        tc.checkTimeForAdd(mlal1, "Array List, version one");
//        MyImplementationList mlll1 = new MyImplementationLinkedList();
//        tc.checkTimeForAdd(mlll1, "Linked List, version one");
//        MyImplementationList alvt = new com.tokarieva.MyArrayList();
//        tc.checkTimeForAdd(alvt, "Array List, version two");
//        MyImplementationList llvt = new com.tokarieva.MyLinkedList();
//        tc.checkTimeForAdd(llvt, "Linked List, version two");


//        com.tokarieva.Transform t = new com.tokarieva.Transform();
//        t.milisecsSinceDay(1984, 07, 24, 2, 05);

//        System.out.println(t.milisToSecs(1000));
//        System.out.println(t.milisToMins(1000*60));
//        System.out.println(t.milisToHours(3600000));
//        long val = (long) 1481918605842;
//        System.out.println(t.milisToDays(val));

    }

    public void checkTimeForAdd(IList myList, String listName){
        long currentTimeImMilis = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++){
            myList.addToBeginning(1);
        }
        currentTimeImMilis = System.currentTimeMillis() - currentTimeImMilis;
        System.out.println("Total time for " + listName + " method addToBeginning is: " + currentTimeImMilis);


        currentTimeImMilis = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++){
            myList.add(1);
        }
        currentTimeImMilis = System.currentTimeMillis() - currentTimeImMilis;
        System.out.println("Total time for " + listName + " method add is: " + currentTimeImMilis);

        currentTimeImMilis = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++){
            myList.get(1);
        }
        currentTimeImMilis = System.currentTimeMillis() - currentTimeImMilis;
        System.out.println("Total time for " + listName + " method get is: " + currentTimeImMilis);

        currentTimeImMilis = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++){
            myList.contains(1);
        }
        currentTimeImMilis = System.currentTimeMillis() - currentTimeImMilis;
        System.out.println("Total time for " + listName + " method contains is: " + currentTimeImMilis);

        currentTimeImMilis = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++){
            myList.remove(1);
        }
        currentTimeImMilis = System.currentTimeMillis() - currentTimeImMilis;
        System.out.println("Total time for " + listName + " method remove is: " + currentTimeImMilis);
        System.out.println("****************************");
    }

}
