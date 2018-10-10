package no.uib.ii.inf102.f18.mandatory1;

public class MyStack<E> implements IStack<E> {
	Node first;
	
	private class Node {
		Node next;
		E data;
		
		public Node(E data) {
			this.data = data;
		}
	}
	
	@Override
	public E pop() {
		if (empty()) throw new IllegalStateException("Calls pop() on empty stack");
		Node ret = first;
		first = first.next;
		return ret.data;
	}

	@Override
	public void push(E data) {
		if (first == null) {
			first = new Node(data);
		} else {
			Node oldFirst = first;
			first = new Node(data);
			first.next = oldFirst;
		}
	}

	@Override
	public boolean empty() {
		return first == null;
	}
	
}
