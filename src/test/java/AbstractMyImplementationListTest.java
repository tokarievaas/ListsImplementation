import org.junit.Assert;
import org.junit.Test;

/**
 * Created by graf on 28.11.2016.
 */
public abstract class AbstractMyImplementationListTest {

    protected MyImplementationList sal;

    @Test
    public void testToArray(){
        Assert.assertArrayEquals(new int[0], sal.toArray());
    }

    @Test
    public void testToArrayOneValue(){
        int [] expectedArray = {1};
        sal.add(1);
        Assert.assertArrayEquals(expectedArray, sal.toArray());
    }

    @Test
    public void testAdd(){
        int [] expectedArray = {1,2};
        sal.add(1);
        sal.add(2);
        Assert.assertArrayEquals(expectedArray, sal.toArray());
    }

    @Test
    public void testAddMoreThan4(){
        int [] expectedArray = {1,2,3,4,5};
        sal.add(1);
        sal.add(2);
        sal.add(3);
        sal.add(4);
        sal.add(5);
        Assert.assertArrayEquals(expectedArray, sal.toArray());
    }

    @Test
    public void testAddMoreThan8(){
        int [] expectedArray = {1,2,3,4,5,6,7,8,9};

        sal.add(1);
        sal.add(2);
        sal.add(3);
        sal.add(4);
        sal.add(5);
        sal.add(6);
        sal.add(7);
        sal.add(8);
        sal.add(9);
        Assert.assertArrayEquals(expectedArray, sal.toArray());
        Assert.assertEquals(expectedArray.length, sal.size());
    }

    @Test
    public void testClear(){
        int [] expectedArray = {};
        sal.add(1);
        sal.add(2);
        sal.clear();
        Assert.assertArrayEquals(expectedArray, sal.toArray());
        Assert.assertEquals(expectedArray.length, sal.size());
    }

    @Test
    public void testToString(){
        sal.clear();
        String expectedArray = "{1,2,3,4,5}";
        sal.add(1);
        sal.add(2);
        sal.add(3);
        sal.add(4);
        sal.add(5);
        Assert.assertEquals(expectedArray, sal.toString());
    }

    @Test
    public void testAddToBeginning(){
        sal.clear();
//        String expectedArray = "{1,2,3,4,5}";
        int [] expectedArray = {1,2,3,4,5};
        sal.addToBeginning(5);
        sal.addToBeginning(4);
        sal.addToBeginning(3);
        sal.addToBeginning(2);
        sal.addToBeginning(1);
//        sal.toString();
        Assert.assertArrayEquals(expectedArray, sal.toArray());
        Assert.assertEquals(expectedArray.length, sal.size());
    }

    @Test
    public void testAddToBeginning2(){
        sal.clear();
//        String expectedArray = "{1,2,3,4,5}";
        int [] expectedArray = {1,2,3,4,5};
        sal.addToBeginning(3);
        sal.addToBeginning(2);
        sal.addToBeginning(1);
        sal.add(4);
        sal.add(5);
//        sal.toString();
        Assert.assertArrayEquals(expectedArray, sal.toArray());
        Assert.assertEquals(expectedArray.length, sal.size());
    }

    @Test
    public void testAddToBeginningOneValue(){
        int [] expectedArray = {1,2,3};
        String expectedArrayString = "{1,2,3}";
        sal.clear();
        sal.add(2);
        sal.add(3);
        sal.addToBeginning(1);
        Assert.assertArrayEquals(expectedArray, sal.toArray());
        Assert.assertEquals(expectedArrayString, sal.toString());
    }

    @Test
    public void testAddToSpesifiesdIndex(){
        sal.clear();
        int [] expectedArray = {1,2,3};
        sal.add(1);
        sal.add(3);
        sal.add(1, 2);
        System.out.println(sal.toString());
        Assert.assertArrayEquals(expectedArray, sal.toArray());
    }

    @Test
    public void testAddToSpesifiesdIndexMoreThan4(){
        sal.clear();
        int [] expectedArray = {1,2,3,4,5};
        sal.add(1);
        sal.add(2);
        sal.add(4);
        sal.add(5);
        sal.add(2, 3);
        System.out.println(sal.toString());
        Assert.assertArrayEquals(expectedArray, sal.toArray());

    }
    @Test
    public void testAddToSpesifiesdIndexMoreThan4AllElements(){
        sal.clear();
        int [] expectedArray = {1,2,3,4,5};
        sal.add(5);
        sal.add(0, 4);
        sal.add(0, 1);
        sal.add(1, 3);
        sal.add(1, 2);
        System.out.println(sal.toString());
        Assert.assertArrayEquals(expectedArray, sal.toArray());
        Assert.assertEquals(expectedArray.length, sal.size());
    }

    @Test
    public void testAddMoreThan8ToSpesifiedIndex(){
        int [] expectedArray = {1,2,3,4,5,6,7,8,9};
        sal.clear();
        sal.add(1);
        sal.add(3);
        sal.add(1, 2);
        sal.add(9);
        sal.add(3, 4);
        sal.add(4, 7);
        sal.add(4, 5);
        sal.add(6,8);
        sal.add(5, 6);
        Assert.assertArrayEquals(expectedArray, sal.toArray());
        Assert.assertEquals(expectedArray.length, sal.size());
    }
    @Test (expected = ListIndexOutOfBoundException.class)
    public void addToSpecifiedIndexOutOfBounds () throws ListIndexOutOfBoundException{
        sal.clear();
        sal.add(1);
        sal.add(2);
        sal.add(3);
        sal.add(5, 4);
//        Assert.assertFalse();
    }

    @Test
    public void testContains(){
        sal.clear();
        sal.add(1);
        sal.add(2);
        sal.add(3);
        Assert.assertTrue(sal.contains(2));
        Assert.assertFalse(sal.contains(9));
    }

    @Test
    public void testGet() throws ListIndexOutOfBoundException {
        sal.clear();
        sal.add(1);
        sal.add(2);
        sal.add(3);
        sal.add(0);
        Assert.assertEquals(2, sal.get(1));
        Assert.assertEquals(0, sal.get(3));
//        Assert.assertEquals(0, sal.get(9));
    }

    @Test (expected = ListIndexOutOfBoundException.class)
    public void testGenWrongValue() throws ListIndexOutOfBoundException {
        sal.clear();
        sal.add(1);
        sal.add(2);
        Assert.assertEquals(0, sal.get(9));
    }

    @Test
    public void testRemove(){
        int [] expectedArray = {1,2,4};
        sal.clear();
        sal.add(1);
        sal.add(2);
        sal.add(3);
        sal.add(4);
        sal.remove(2);
        Assert.assertArrayEquals(expectedArray, sal.toArray());
        Assert.assertEquals(expectedArray.length, sal.size());
    }

    @Test
    public void testRemoveLast(){
        int [] expectedArray = {1,2,3};
        sal.clear();
        sal.add(1);
        sal.add(2);
        sal.add(3);
        sal.add(4);
        sal.remove(3);
        Assert.assertArrayEquals(expectedArray, sal.toArray());
        Assert.assertEquals(expectedArray.length, sal.size());
    }

    @Test
    public void testRemoveFirstElement(){
        int [] expectedArray2 = {2,3};
        sal.clear();
        sal.add(1);
        sal.add(2);
        sal.add(3);
        sal.remove(0);
        Assert.assertArrayEquals(expectedArray2, sal.toArray());
        Assert.assertEquals(expectedArray2.length, sal.size());
    }

    @Test (expected = ListIndexOutOfBoundException.class)
    public void testRemoveOutOfBoundary(){
        sal.clear();
        sal.add(1);
        sal.add(2);
        sal.add(3);
        sal.remove(6);
    }


    @Test
    public void testSet(){
        int [] expectedArray = {1,2};
        sal.clear();
        sal.add(1);
        sal.add(3);
        sal.set(1, 2);
        Assert.assertArrayEquals(expectedArray, sal.toArray());
    }

    @Test (expected = ListIndexOutOfBoundException.class)
    public void testSetOutOfBoundary(){
        sal.clear();
        sal.add(1);
        sal.add(2);
        sal.add(3);
        sal.set(6, 2);
    }
}
