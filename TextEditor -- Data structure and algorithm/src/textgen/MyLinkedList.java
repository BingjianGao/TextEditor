package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size=0;
		head=new LLNode<E>(null);
		tail=new LLNode<E>(null);
		
		head.next=tail;
		tail.prev=head;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		
		if(element==null) {
			throw new NullPointerException ("null element");
		}
		LLNode<E> newNode=new LLNode<E>(element);
		newNode.next=tail;
		newNode.prev=tail.prev;
		tail.prev.next=newNode;
		tail.prev=newNode;
		size++;
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		LLNode<E> tempNode=new LLNode<E>();
		if(index<0||index>size-1) {
			throw new IndexOutOfBoundsException ("out of bounds");
			
		}
		// get item from the head or from tail
		if(index<size/2) {
			tempNode=head;
			for(int i=0;i<=index;i++) {
				tempNode=tempNode.next;
			}
			
			
		}else {
			tempNode=tail;
			for(int i=0;i<=size-1-index;i++) {
				tempNode=tempNode.prev;
			}
			
		}
		//tempNode.prev=null;
		//tempNode.next=null;
		
		return tempNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		LLNode<E> newNode=new LLNode<E>(element);
		LLNode<E> tempNode=new LLNode<E>();
		
		if(index<0||index>size) {
			throw new IndexOutOfBoundsException ("out of bounds");
		}
		if(element==null) {
			throw new NullPointerException ("null element");
		}
		if(index==0) {
			newNode.prev=head;
			newNode.next=head.next;
			head.next.prev=newNode;
			head.next=newNode;
			size++;
		}else {
			tempNode=head;
			for(int i=0;i<index-1;i++) {
				tempNode=tempNode.next;
			}
			newNode.prev=tempNode.next;
			newNode.next=tempNode.next.next;
			tempNode.next.next.prev=newNode;
			tempNode.next.next=newNode;
			tempNode=new LLNode<E>();
			size++;
		}
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index<0||index>size-1) {
			throw new IndexOutOfBoundsException ("out of bounds remove");
		}
		LLNode<E> tempNode=head;
		for(int i=0;i<=index;i++) {
			tempNode=tempNode.next;
		}
		tempNode.prev.next=tempNode.next;
		tempNode.next.prev=tempNode.prev;
		tempNode.prev=null;
		tempNode.next=null;
		size--;
		
		return tempNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		E replaced;
		LLNode<E> tempNode=head;
		if(index<0||index>size-1) {
			throw new IndexOutOfBoundsException("out of bound set method");
		}
		if(element==null) {
			throw new NullPointerException("null element set method");
		}
		
		for(int i=0;i<index;i++) {
			tempNode=tempNode.next;
		}
		replaced=tempNode.next.data;
		tempNode.next.data=element;
		//tempNode=new LLNode<E>();
		
		return replaced;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	
	public LLNode() {
		this.data=null;
		this.prev=null;
		this.next=null;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
