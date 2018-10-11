package no.uib.ii.inf102.f18.mandatory1;

import java.util.Iterator;

public class MyQueue<E> implements IQueue<E>, Iterable<E> {
	Node first = null;
	Node last = null;
	
	private class Node {
		Node next;
		E item;
		
		public Node(E item) {
			this.item = item;
		}
	}
	
	private class MyQueueIterator<E> implements Iterator {
		Node curr = first;
		
		@Override
		public boolean hasNext() {
			return curr != null;
		}

		@Override
		public E next() {
			E ret = (E) curr.item;
			curr = curr.next;
			return ret;
		}
	}
	
	@Override
	public void enqueue(E item) {
		if (first == null) {
			first = new Node(item);
			last = first;
		} else {
			last.next = new Node(item);
			last = last.next;
		}
	}

	@Override
	public E dequeue() {
		E ret = first.item;
		first = first.next;
		return ret;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyQueueIterator<E>();
	}
}
