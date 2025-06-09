package model;

import java.util.Iterator;

public class CarList<T> implements Iterable<T> {
    private class Node {
        T data;
        Node next;
        Node(T data) { this.data = data; }
    }

    private Node head;
    private int size;

    public void add(T element) {
        Node newNode = new Node(element);
        if (head == null) head = newNode;
        else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    public void set(int index, T element) {
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        current.data = element;
    }

    public CarList<T> subList(int start, int end) {
        CarList<T> result = new CarList<>();
        Node current = head;
        for (int i = 0; i < start; i++) current = current.next;
        for (int i = start; i < end; i++) {
            result.add(current.data);
            current = current.next;
        }
        return result;
    }

    public void remove(int index) {
        if (index == 0) head = head.next;
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) current = current.next;
            current.next = current.next.next;
        }
        size--;
    }

    public int size() { return size; }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node current = head;
            public boolean hasNext() { return current != null; }
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
