package com.tokarieva;

import java.io.Serializable;
import java.util.Iterator;

public class MyLinkedList<E> extends AbstractList<E> implements Serializable{//} implements IList<E> {
    Node head;
    Node tail;

    public void add(E value){
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

    public void addToBeginning(E value) {
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

    public void add(int index, E value) {
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

    public void clear(){
        super.clear();
        head = null;
    }

    public boolean contains(E value) {
        Node node = head;

        for (int i = 0; i < size; i++){
            if (node.value == value) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public E get(int index) {
        ensureWithinBounds(index);
        return (E)getSpesifiedNode(index).value;
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

    public void remove(E value){
        Node node = head;
        int index = -1;

        for (int i = 0; i < size; i++){
            if (node.value.equals(value)) {
                index = i;
            }
            node = node.next;
        }
        if (index == -1) {
            System.out.println("No such element!");
        } else {
            remove(index);
        }
    }

    public void set(int index, E value) {
        ensureWithinBounds(index);
        getSpesifiedNode(index).value = value;
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

    public E[] toArray(){

        Node currentNode = head;
        int index = 0;
        E [] arrayToReturn = (E[])new Object[size];

        while (currentNode != null){
            arrayToReturn[index] = (E) currentNode.value;
            index++;
            currentNode = currentNode.next;
        }
        return arrayToReturn;
    }

    public Iterator <E> iterator(){
        return new Iterator<E>() {
            Node<E> node = head;
            public boolean hasNext() {
                if (node != null){
                    return true;
                }
                return false;
            }

            public E next() {
                E value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    public boolean equals(Object other){
        if (!(other instanceof MyLinkedList)){
            return false;
        }
        return super.equals(other);

    }

    private class Node<E> {

        E value;
        Node<E> next;
        Node<E> previous;

        public Node(E i) {
            value = i;
        }
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

    private void meth1(int i, char z){}
    private void meth1(char i, int z){}


}
