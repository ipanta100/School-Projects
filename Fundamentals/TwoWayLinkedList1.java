//*******************
//Italo Panta
//COSC 2336-01
//Instructor: Dr.Doershuk
//Due: 4/11/2018
//Submitted: 4/11/2018
//This program shows how to use a Two way linked list with different operators
//*******************

import java.util.*;
import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class TwoWayLinkedList {
  public static void main(String[] args) {
	MyTwoWayLinkedList<String> list = new MyTwoWayLinkedList<>();
	 
	 list.add("1");
	 list.add("2");
	 list.add("3");
	 list.add("4");
	 
	 System.out.println("Printing the list in order using toString(): "
			 + list.toString());
	 while(list.hasNext()){
		System.out.println("Advancing to the last element in the list using the next() operator: ");
         	list.next();
     }
	 
     	 while(list.hasPrevious()){
    		System.out.println("Printing the list in reverse order using previous() and hasPrevious() methods: ");
		System.out.print(list.previous() + " ");
     }
     
	 ListIterator<String> i = list.listIterator(2);
	 while (i.hasNext()) {
		 System.out.println("Printing elements starting with index 2 using listIterator(int index): ");
		 System.out.print(i.next() + " ");
	 }
  }
  
  public interface AbstractSequentialList<E> extends java.lang.Iterable {
	    /** Add a new element at the end of this list */
	    public void add(E e);

	    /** Add a new element at the specified index in this list */
	    public void add(int index, E e);

	    /** Clear the list */
	    public void clear();

	    /** Return true if this list contains the element */
	    public boolean contains(E e);

	    /** Return the element from this list at the specified index */
	    public E get(int index);

	    /** Return the index of the first matching element in this list.
	     *  Return -1 if no match. */
	    public int indexOf(E e);

	    /** Return true if this list contains no elements */
	    public boolean isEmpty();

	    /** Return the index of the last matching element in this list
	     *  Return -1 if no match. */
	    public int lastIndexOf(E e);

	    /** Remove the first occurrence of the element o from this list.
	     *  Shift any subsequent elements to the left.
	     *  Return true if the element is removed. */
	    public boolean remove(E e);

	    /** Remove the element at the specified position in this list
	     *  Shift any subsequent elements to the left.
	     *  Return the element that was removed from the list. */
	    public E remove(int index);

	    /** Replace the element at the specified position in this list
	     *  with the specified element and return the old element. */
	    public Object set(int index, E e);

	    /** Return the number of elements in this list */
	    public int size();
	  }

	  public abstract class MyAbstractList<E> implements AbstractSequentialList<E> {
	    protected int size = 0; // The size of the list

	    /** Create a default list */
	    protected MyAbstractList() {
	    }

	    /** Create a list from an array of objects */
	    protected MyAbstractList(E[] objects) {
	      for (int i = 0; i < objects.length; i++)
	        add(objects[i]);
	    }

	    /** Add a new element at the end of this list */
	    public void add(E e) {
	      add(size, e);
	    }

	    /** Return true if this list contains no elements */
	    public boolean isEmpty() {
	      return size == 0;
	    }

	    /** Return the number of elements in this list */
	    public int size() {
	      return size;
	    }

	    /** Remove the first occurrence of the element o from this list.
	     *  Shift any subsequent elements to the left.
	     *  Return true if the element is removed. */
	    public boolean remove(E e) {
	      if (indexOf(e) >= 0) {
	        remove(indexOf(e));
	        return true;
	      }
	      else 
	        return false;
	    }
	  }

	  public abstract class MyTwoWayLinkedList<E> extends MyAbstractList<E> {
	    private Node<E> head, tail;

	    /** Create a default list */
	    public MyTwoWayLinkedList() {
	    }
	    
	    public boolean hasNext() {
	        return (head != null);
	      }

	      public E next() {
	        E e = head.element;
	        head = head.next;
	        return e;
	      }
	      
	      public boolean hasPrevious() {
	    	  return (tail != null);
	      }
	      
	      public E previous() {
	    	  E e = tail.element;
	    	  tail = tail.previous;
	    	  return e;
	      }
	    /** Create a list from an array of objects */
	    public MyTwoWayLinkedList(E[] objects) {
	      super(objects);
	    }

	    /** Return the head element in the list */
	    public E getFirst() {
	      if (size == 0) {
	        return null;
	      }
	      else {
	        return head.element;
	      }
	    }

	    /** Return the last element in the list */
	    public E getLast() {
	      if (size == 0) {
	        return null;
	      }
	      else {
	        return tail.element;
	      }
	    }

	    /** Add an element to the beginning of the list */
	    public void addFirst(E e) {
	      Node<E> newNode = new Node<E>(e); // Create a new node
	      newNode.next = head; // link the new node with the head
	      head = newNode; // head points to the new node
	      size++; // Increase list size

	      if (tail == null) // the new node is the only node in list
	        tail = head;
	    }

	    /** Add an element to the end of the list */
	    public void addLast(E e) {
	      Node<E> newNode = new Node<E>(e); // Create a new for element e

	      if (tail == null) {
	        head = tail = newNode; // The new node is the only node in list
	      }
	      else {
	        tail.next = newNode; // Link the new with the last node
	        tail = tail.next; // tail now points to the last node
	      }

	      size++; // Increase size
	    }


	    /** Add a new element at the specified index in this list
	     * The index of the head element is 0 */
	    public void add(int index, E e) {
	      if (index == 0) {
	        addFirst(e);
	      }
	      else if (index >= size) {
	        addLast(e);
	      }
	      else {
	        Node<E> current = head;
	        for (int i = 1; i < index; i++) {
	          current = current.next;
	        }
	        Node<E> temp = current.next;
	        current.next = new Node<E>(e);
	        (current.next).next = temp;
	        size++;
	      }
	    }

	    /** Remove the head node and
	     *  return the object that is contained in the removed node. */
	    public E removeFirst() {
	      if (size == 0) {
	        return null;
	      }
	      else {
	        Node<E> temp = head;
	        head = head.next;
	        size--;
	        if (head == null) {
	          tail = null;
	        }
	        return temp.element;
	      }
	    }

	    /** Remove the last node and
	     * return the object that is contained in the removed node. */
	    public E removeLast() {
	      if (size == 0) {
	        return null;
	      }
	      else if (size == 1) {
	        Node<E> temp = head;
	        head = tail = null;
	        size = 0;
	        return temp.element;
	      }
	      else {
	        Node<E> current = head;

	        for (int i = 0; i < size - 2; i++) {
	          current = current.next;
	        }

	        Node<E> temp = tail;
	        tail = current;
	        tail.next = null;
	        size--;
	        return temp.element;
	      }
	    }

	    /** Remove the element at the specified position in this list.
	     *  Return the element that was removed from the list. */
	    public E remove(int index) {
	      if (index < 0 || index >= size) {
	        return null;
	      }
	      else if (index == 0) {
	        return removeFirst();
	      }
	      else if (index == size - 1) {
	        return removeLast();
	      }
	      else {
	        Node<E> previous = head;

	        for (int i = 1; i < index; i++) {
	          previous = previous.next;
	        }

	        Node<E> current = previous.next;
	        previous.next = current.next;
	        size--;
	        return current.element;
	      }
	    }

	    @Override
	    public String toString() {
	      StringBuilder result = new StringBuilder("[");

	      Node<E> current = head;
	      for (int i = 0; i < size; i++) {
	        result.append(current.element);
	        current = current.next;
	        if (current != null) {
	          result.append(", "); // Separate two elements with a comma
	        }
	        else {
	          result.append("]"); // Insert the closing ] in the string
	        }
	      }

	      return result.toString();
	    }

	    /** Clear the list */
	    public void clear() {
	      head = tail = null;
	    }

	    /** Return true if this list contains the element o */
	    public boolean contains(Object o) {
	      // Implement it in this exercise
	      Node<E> current = head;
	      for (int i = 0; i < size; i++) {
	        if (current.element.equals(o))
	          return true;
	        current = current.next;
	      }

	      return false;
	    }

	    /** Return the element from this list at the specified index */
	    public E get(int index) {
	      // Implement it in this exercise
	      if (index < 0 || index > size - 1)
	        return null;

	      Node<E> current = head;
	      for (int i = 0; i < index; i++)
	        current = current.next;

	      return current.element;
	    }

	    /** Returns the index of the first matching element in this list.
	     *  Returns -1 if no match. */
	    public int indexOf(Object o) {
	      // Implement it in this exercise
	      Node<E> current = head;
	      for (int i = 0; i < size; i++) {
	        if (current.element.equals(o))
	          return i;
	        current = current.next;
	      }

	      return -1;
	    }

	    /** Returns the index of the last matching element in this list
	     *  Returns -1 if no match. */
	    public int lastIndexOf(Object o) {
	      // Implement it in this exercise
	      int lastIndex = -1;
	      Node<E> current = head;
	      for (int i = 0; i < size; i++) {
	        if (current.element.equals(o))
	          lastIndex = i;
	        current = current.next;
	      }

	      return lastIndex;
	    }

	    /** Replace the element at the specified position in this list
	     *  with the specified element. */
	    public E set(int index, E e) {
	      if (index < 0 || index > size - 1)
	        return null;

	      Node<E> current = head;
	      for (int i = 0; i < index; i++)
	        current = current.next;

	      E temp =  current.element;
	      current.element = e;
	      
	      return temp;
	    }

	    /** Override the iterator method defined in Iterable */
	    public ListIterator<E> listIterator(int index) {
	      return new MyTwoWayListIterator(index);
	    }

	    private class MyTwoWayListIterator 
	        implements java.util.ListIterator<E> {
	      private Node<E> current = head; // Current index 
	      private int index = 0;
	      MyTwoWayListIterator(int i) {
	    	  index = i;
	    	  for (int k = 0; k < index; k++)
	    		  current = current.next;
	        }
	      public boolean hasNext() {
	    	  return (current != null);
	      }

	      public E next() {
	    	  E e = current.element;
	    	  current = current.next;
	    	  return e;
	      }
	      
	      public boolean hasPrevious() {
	    	  return (current != null);
	      }
	      
	      public E previous() {
	    	  E e = current.element;
	    	  current = current.previous;
	    	  return e;
	      }
	      
	      public int nextIndex(){
	          return index + 1;
	      }
	      
	      public int previousIndex() {
	          return index - 1;
	      }
		
	      public void add(E e) {
	    	// TODO Auto-generated method stub
		  Node<E> temp = current;
		  current.next = new Node<E>(e);
		  current.next.next = temp.next;
		  current.next.previous = current;
	      }
		
	      public void remove() {
	    	// TODO Auto-generated method stub
	    	  Node<E> temp = current;
		  current.previous.next = temp.next;
		  current.next.previous = current.previous;
	      }
		
	      public void set(E e) {
		// TODO Auto-generated method stub
		  Node<E> temp = current;
		  current.element = e;
		  current.next = temp.next;
		  current.previous = temp.previous;
	      }
	     
	    }
	    
	    private class Node<E> {
	      E element;
	      Node<E> next;
	      Node<E> previous;

	      public Node(E e) {
	        element = e;
	      }
	    }
	  }
	}