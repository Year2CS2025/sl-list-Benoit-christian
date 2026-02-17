package SLIST;


import java.util.NoSuchElementException;

public class SLinkedList<T> {
    class Node<T>{
        T data;
        Node<T> next;
        Node(T data){
            this.data=data;
            next=null;
        }

    }

    private Node<T> head;
    private Node<T> tail;
    private int size=0;
    public SLinkedList(){
        head=null;
        size=0;

}
    
   
               
    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        tail=newNode;
        size++;
    }
    public void addLast(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail=newNode;
        } else {
            tail.next = newNode;
        }
        size++;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public T deleteFirst(){
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        T data = head.data;
        head = head.next;
        size--;
        if (head == null) {
            tail = null; // If the list becomes empty, set tail to null
        }
        return data;
    }
    public T deleteLast(){
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        if (head.next == null) { // Only one element
            T data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        }
        Node<T> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        T data = tail.data;
        current.next = null;
        tail = current;
        size--;
        return data;
    }
    public void display(){
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public boolean contains(T data){
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void clear(){
        head = null;
        tail=null;
        size=0;
    }
    public T getFirst(){
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }
    public T getLast(){
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.data;
    }
    public void remove (T e) {
        //removes first occurrence of e
    }
    public void reverse(){
        
    //TODO

        Node<T> prev = null;
        Node<T> current = head;
        tail = head; 
        while (current != null) {
            Node<T> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    public void deleteConsecutiveDuplicates(){
       //TODO
        Node<T> current = head;
        while (current != null && current.next != null) {
            if (current.data.equals(current.next.data)) {
                current.next = current.next.next;
                size--;
                if (current.next == null) {
                    tail = current; // update tail if last node was removed
                }
            } else {
                current = current.next;
            }
    }
    //two lists are equal if they have the same 
    // size and the same elements in the same order
    @Override
    public boolean equals(Object obj){
        //TODO
        if (obj == null || !(obj instanceof SLinkedList)) return false;

        SLinkedList<?> other = (SLinkedList<?>) obj;
        if (this.size != other.size) return false;

        Node<T> thisCurrent = this.head;
        Node<?> otherCurrent = other.head;
        while (thisCurrent != null) {
            if (!thisCurrent.data.equals(otherCurrent.data)) return false;
            thisCurrent = thisCurrent.next;
            otherCurrent = otherCurrent.next;
        }
        return true;
    }

}
