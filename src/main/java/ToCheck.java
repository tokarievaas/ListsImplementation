import java.util.ArrayList;

/**
 * Created by graf on 15.12.2016.
 */
public class ToCheck {
    public static void main(String[] args) {
        ToCheck tc = new ToCheck();
//        MyImplementationList mlal1 = new MyImplementationArrayList();
////        ArrayList <MyImplementationList>
//        tc.checkTimeForAdd(mlal1, "Array List, version one");
//        MyImplementationList mlll1 = new MyImplementationLinkedList();
//        tc.checkTimeForAdd(mlll1, "Linked List, version one");
//        MyImplementationList alvt = new ArrayListVersionTwo();
//        tc.checkTimeForAdd(alvt, "Array List, version two");
//        MyImplementationList llvt = new LinkedListVersionTwo();
//        tc.checkTimeForAdd(llvt, "Linked List, version two");


        Transform t = new Transform();
        t.milisecsSinceDay(1984, 07, 24, 2, 05);
//        System.out.println(t.milisToSecs(1000));
//        System.out.println(t.milisToMins(1000*60));
//        System.out.println(t.milisToHours(3600000));
//        long val = (long) 1481918605842;
//        System.out.println(t.milisToDays(val));

    }

    public void checkTimeForAdd(MyImplementationList myList, String listName){
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
