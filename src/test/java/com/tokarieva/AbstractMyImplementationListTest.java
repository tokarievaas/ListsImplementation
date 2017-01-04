package com.tokarieva;

import com.tokarieva.exception.ListIndexOutOfBoundException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public abstract class AbstractMyImplementationListTest {

    protected IList<Integer> newList;
    protected IList<Integer> newList1;
    protected IList<Integer> newListDifferentInstance;
    protected IList<Object> newListObjectInstance;
    protected IList<String> newListString;

    @Test
    public void testToArray(){
        Assert.assertArrayEquals(new Integer[0], newList.toArray());
    }

    @Test
    public void testToArrayOneValue(){
        Integer [] expectedArray = {1};
        newList.add(1);
        Assert.assertArrayEquals(expectedArray, newList.toArray());
    }

    @Test
    public void testAdd(){
        Integer [] expectedArray = {1,2};
        addValuesToArray(2);
        Assert.assertArrayEquals(expectedArray, newList.toArray());
    }

    @Test
    public void testAddMoreThan4(){
        Integer [] expectedArray = {1,2,3,4,5};
        addValuesToArray(5);
        Assert.assertArrayEquals(expectedArray, newList.toArray());
    }

    @Test
    public void testAddMoreThan8(){
        Integer [] expectedArray = {1,2,3,4,5,6,7,8,9};
        addValuesToArray(9);
        Assert.assertArrayEquals(expectedArray, newList.toArray());
        Assert.assertEquals(expectedArray.length, newList.size());
    }

    @Test
    public void testClear(){
        Integer [] expectedArray = {};
        addValuesToArray(2);
//        newList.add(1);
//        newList.add(2);
        newList.clear();
        Assert.assertArrayEquals(expectedArray, newList.toArray());
        Assert.assertEquals(expectedArray.length, newList.size());
    }

    @Test
    public void testToString(){
        newList.clear();
        String expectedArrayString = "{1,2,3,4,5}";
        Integer [] expectedArray = {1,2,3,4,5};
        addValuesToArray(5);
        Assert.assertEquals(expectedArrayString, newList.toString());
    }

    @Test
    public void testAddToBeginning(){
        newList.clear();
        Integer [] expectedArray = {1,2,3,4,5};

        addValuesToBeginning(5);
//        for (int i = 5; i > 0; i--){
//            newList.addToBeginning(i);
//        }

        Assert.assertArrayEquals(expectedArray, newList.toArray());
        Assert.assertEquals(expectedArray.length, newList.size());
    }

    @Test
    public void testAddToBeginning2(){
        newList.clear();
//        String expectedArray = "{1,2,3,4,5}";
        Integer [] expectedArray = {1,2,3,4,5};
        addValuesToBeginning(3);
//        newList.addToBeginning(3);
//        newList.addToBeginning(2);
//        newList.addToBeginning(1);
        newList.add(4);
        newList.add(5);
//        newList.toString();
        Assert.assertArrayEquals(expectedArray, newList.toArray());
        Assert.assertEquals(expectedArray.length, newList.size());
    }

    @Test
    public void testAddToBeginningOneValue(){
        Integer [] expectedArray = {1,2,3};
        String expectedArrayString = "{1,2,3}";
        newList.clear();
        newList.add(2);
        newList.add(3);
        newList.addToBeginning(1);
        Assert.assertArrayEquals(expectedArray, newList.toArray());
        Assert.assertEquals(expectedArrayString, newList.toString());
    }

    @Test
    public void testAddToSpesifiesdIndex(){
        newList.clear();
        Integer [] expectedArray = {1,2,3};
        newList.add(1);
        newList.add(3);
        newList.add(1, 2);
        System.out.println(newList.toString());
        Assert.assertArrayEquals(expectedArray, newList.toArray());
    }

    @Test
    public void testAddToSpesifiesdIndexMoreThan4(){
        newList.clear();
        Integer [] expectedArray = {1,2,3,4,5};
        newList.add(1);
        newList.add(2);
        newList.add(4);
        newList.add(5);
        newList.add(2, 3);
        System.out.println(newList.toString());
        Assert.assertArrayEquals(expectedArray, newList.toArray());

    }
    @Test
    public void testAddToSpesifiesdIndexMoreThan4AllElements(){
        newList.clear();
        Integer [] expectedArray = {1,2,3,4,5};
        newList.add(5);
        newList.add(0, 4);
        newList.add(0, 1);
        newList.add(1, 3);
        newList.add(1, 2);
        System.out.println(newList.toString());
        Assert.assertArrayEquals(expectedArray, newList.toArray());
        Assert.assertEquals(expectedArray.length, newList.size());
    }

    @Test
    public void testAddMoreThan8ToSpesifiedIndex(){
        Integer [] expectedArray = {1,2,3,4,5,6,7,8,9};
        newList.clear();
        newList.add(1);
        newList.add(3);
        newList.add(1, 2);
        newList.add(9);
        newList.add(3, 4);
        newList.add(4, 7);
        newList.add(4, 5);
        newList.add(6,8);
        newList.add(5, 6);
        Assert.assertArrayEquals(expectedArray, newList.toArray());
        Assert.assertEquals(expectedArray.length, newList.size());
    }

    @Test (expected = ListIndexOutOfBoundException.class)
    public void addToSpecifiedIndexOutOfBounds () throws ListIndexOutOfBoundException{
        newList.clear();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        newList.add(5, 4);

    }

    @Test
    public void testContains(){
        newList.clear();
        addValuesToArray(3);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);
        Assert.assertTrue(newList.contains(2));
        Assert.assertFalse(newList.contains(9));
    }

    @Test
    public void testGet() throws ListIndexOutOfBoundException {
        newList.clear();
        addValuesToArray(3);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);
        newList.add(0);
        Assert.assertEquals((Integer)2, newList.get(1));
        Assert.assertEquals((Integer)0, newList.get(3));
//        Assert.assertEquals(0, newList.get(9));
    }

    @Test (expected = ListIndexOutOfBoundException.class)
    public void testGetWrongValue() throws ListIndexOutOfBoundException {
        newList.clear();
        addValuesToArray(2);
//        newList.add(1);
//        newList.add(2);
        Assert.assertEquals((Integer)0, newList.get(9));
    }

    @Test
    public void testRemove(){
        Integer [] expectedArray = {1,2,4};
        newList.clear();
        addValuesToArray(4);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);
//        newList.add(4);
        newList.remove(2);
        Assert.assertArrayEquals(expectedArray, newList.toArray());
        Assert.assertEquals(expectedArray.length, newList.size());
    }

    @Test
    public void testRemoveValue(){
        Integer [] expectedArray = {1,2,4};
        newList.clear();
        addValuesToArray(4);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);
//        newList.add(4);
        newList.remove(new Integer(3));
        Assert.assertArrayEquals(expectedArray, newList.toArray());
        Assert.assertEquals(expectedArray.length, newList.size());
    }

    @Test
    public void testRemoveNonExistingValue(){
        Integer [] expectedArray = {1,2,3,4};
        newList.clear();
        addValuesToArray(4);
        newList.remove(new Integer(5));
        Assert.assertArrayEquals(expectedArray, newList.toArray());
        Assert.assertEquals(expectedArray.length, newList.size());
    }

    @Test
    public void testRemoveLast(){
        Integer [] expectedArray = {1,2,3};
        newList.clear();
        addValuesToArray(4);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);
//        newList.add(4);
        newList.remove(3);
        Assert.assertArrayEquals(expectedArray, newList.toArray());
        Assert.assertEquals(expectedArray.length, newList.size());
    }

    @Test
    public void testRemoveFirstElement(){
        Integer [] expectedArray2 = {2,3};
        newList.clear();
        addValuesToArray(3);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);
        newList.remove(0);
        Assert.assertArrayEquals(expectedArray2, newList.toArray());
        Assert.assertEquals(expectedArray2.length, newList.size());
    }

    @Test (expected = ListIndexOutOfBoundException.class)
    public void testRemoveOutOfBoundary(){
        newList.clear();
        addValuesToArray(3);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);
        newList.remove(6);
    }


    @Test
    public void testSet(){
        Integer [] expectedArray = {1,2};
        newList.clear();
        newList.add(1);
        newList.add(3);
        newList.set(1, 2);
        Assert.assertArrayEquals(expectedArray, newList.toArray());
    }

    @Test (expected = ListIndexOutOfBoundException.class)
    public void testSetOutOfBoundary(){
        newList.clear();
        addValuesToArray(3);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);
        newList.set(6, 2);
    }

    @Test
    public void testIterator(){
        newList.clear();
        addValuesToArray(3);

//        newList.add(1);
//        newList.add(2);
//        newList.add(3);
        Iterator<Integer> myIt = newList.iterator();
        System.out.println("Iterator:");
        while (myIt.hasNext()){
            System.out.println(myIt.next());
        }
    }

    @Test
    public void testIteratorEmpty(){
        newList.clear();
        Iterator myIt = newList.iterator();
        System.out.println("Iterator:");
        while (myIt.hasNext()){
            System.out.println(myIt.next());
        }
    }

    @Test
    public void testForEach(){
        newList.clear();
        addValuesToArray(3);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);
        System.out.println("Testing For: Each");
        for (Integer element : newList){
            System.out.println(element);
        }
        System.out.println("end For: each");
    }

    @Test
    public void testEquals(){
        newList.clear();
        addValuesToArray(3);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);

        newList1.add(new Integer(1));
        newList1.add(2);
        newList1.add(3);

        Assert.assertTrue(newList.equals(newList1));
    }

    @Test
    public void testEqualsNegative(){
        newList.clear();
        newList1.clear();
        addValuesToArray(3);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);

        newList1.add(2);
        newList1.add(1);
        newList1.add(3);

        Assert.assertFalse(newList.equals(newList1));
    }

    @Test
    public void testEqualsSameObject(){
        newList.clear();
        addValuesToArray(3);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);

        Assert.assertTrue(newList.equals(newList));
    }

    @Test
    public void testEqualsNull(){
        newList.clear();
        addValuesToArray(3);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);

        newList1 = null;

        Assert.assertFalse(newList.equals(newList1));
    }

    @Test
    public void testEqualsInstances(){
        newList.clear();
        addValuesToArray(3);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);

        newListDifferentInstance.add(1);
        newListDifferentInstance.add(2);
        newListDifferentInstance.add(3);

        Assert.assertFalse(newList.equals(newListDifferentInstance));
    }

    @Test
    public void testEqualsObjectInstance(){
        newList.clear();
        addValuesToArray(3);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);

        newListObjectInstance.clear();

        newListObjectInstance.add("1");
        newListObjectInstance.add("2");
        newListObjectInstance.add(3);

        Assert.assertFalse(newList.equals(newListObjectInstance));
    }

    @Test
    public void testEqualsDifferentLists(){
        newList.clear();
        addValuesToArray(3);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);

        newList1.clear();

        newList1.add(1);
        newList1.add(2);

        Assert.assertFalse(newList1.equals(newList));
        Assert.assertFalse(newList.equals(newList1));
    }

    @Test
    public void testEqualsDifferentTypes(){
        newList.clear();
        addValuesToArray(3);
//        newList.add(1);
//        newList.add(2);
//        newList.add(3);

        newListString.clear();
        newListString.add("1");
        newListString.add("2");
        newListString.add("3");

        Assert.assertFalse(newList.equals(newListString));
    }

    private void addValuesToArray(int elements){
        for (int i = 1; i <= elements; i++){
            newList.add(i);
        }
    }

    private void addValuesToBeginning(int length){
        for (int i = length; i > 0; i--){
            newList.addToBeginning(i);
        }
    }
}
