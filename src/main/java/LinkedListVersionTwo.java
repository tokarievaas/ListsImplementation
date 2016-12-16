/**
 * Created by graf on 15.12.2016.
 */
public class LinkedListVersionTwo extends ParentForLists implements MyImplementationList {
    Node head;
    Node tail;

    public void add(int value){
        if (size == 0){
            head = new Node(value);
            tail = head;
        } else {
            tail.next = new Node(value);
            tail.next.previous = tail;
            tail = tail.next;
        }
        size++;
    }

    public void addToBeginning(int value) {  //!!!!
        Node newNode = new Node(value);
        if (size == 0){
            head = new Node(value);
            tail = head;
        }

        if (size == 1){
            tail.previous = newNode;
            newNode.next = tail;
        } else {
            head.previous = newNode;
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public void add(int index, int value) {
        ensureWithinBounds(index);
        if (index == 0) {
            addToBeginning(value);
            return;
        }
        Node newNode = new Node(value);
        Node tempNode = getSpesifiedNode(index - 1);
        newNode.next = tempNode.next;
        newNode.previous = tempNode.previous;
        tempNode.next = newNode;
        size++;
    }

    private Node getSpesifiedNode(int index) {
        ensureWithinBounds(index);
        Node specifiedNode = head;
        while ((index) != 0){
            specifiedNode = specifiedNode.next;
            index--;
        }
        return specifiedNode;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public boolean contains(int value) {
        Node node = head;

        for (int i = 0; i < size; i++){
            if (node.value == value) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public int get(int index) {
        ensureWithinBounds(index);
        return getSpesifiedNode(index).value;
    }

    public void remove(int index) {
        ensureWithinBounds(index);
        if (index == 0){
            head = head.next;
        } else {
            if (index == size - 1) {
                tail = tail.previous;
                tail.next = null;
            } else {
                Node previousNode = getSpesifiedNode(index - 1);
                previousNode.next = previousNode.next.next;
            }
        }
        size--;
    }

    public void set(int index, int value) {
        ensureWithinBounds(index);
        getSpesifiedNode(index).value = value;
    }

    public int size(){
        return size;
    }

    public String toString(){
        Node currentNode = head;
        String listToString = "";

        while (currentNode != null){
            listToString = listToString + currentNode.value + ",";
            currentNode = currentNode.next;
        }
        return "{" + listToString.substring(0, listToString.length() - 1) + "}";
    }

    public int[] toArray(){

        Node currentNode = head;
        int index = 0;
        int [] arrayToReturn = new int[size];

        while (currentNode != null){
            arrayToReturn[index] = currentNode.value;
            index++;
            currentNode = currentNode.next;
        }
        return arrayToReturn;
    }

    private class Node {

        int value;
        Node next;
        Node previous;

        public Node(int i) {
            value = i;
        }
    }
}
