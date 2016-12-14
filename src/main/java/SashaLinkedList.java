/**
 * Created by graf on 29.11.2016.
 */
public class SashaLinkedList implements SashaList {
    Node head;
    int size;

    public void add(int value){
        Node lastNode;
        if (size == 0){
            head = new Node(value);
        } else {
            lastNode = getLastNode();
            lastNode.next = new Node(value);
        }
        size++;
    }

    public void addToBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void add(int index, int value) {
        if (index == 0) {
            addToBeginning(value);
            return;
        }
        Node spesifiedNode = new Node(value);
        Node tempNode = getSpesifiedNode(index - 1);
        spesifiedNode.next = tempNode.next;
        tempNode.next = spesifiedNode;
        size++;
    }

    private Node getSpesifiedNode(int index) {
        Node specifiedNode = head;
        while ((index) != 0){
            specifiedNode = specifiedNode.next;
            index--;
        }
        return specifiedNode;
    }

    private Node getLastNode() {
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        return lastNode;
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
        if (index < 0 || index >= size){
            throw new ListIndexOutOfBoundException();
        }
        return getSpesifiedNode(index).value;
    }

    public void remove(int index) {
        if (index == 0){
            head = head.next;
        } else {
            Node previousNode = getSpesifiedNode(index - 1);
            previousNode.next = previousNode.next.next;
        }
        size--;
    }

    public void set(int index, int value) {

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

        public Node(int i) {
            value = i;
        }
    }
}
