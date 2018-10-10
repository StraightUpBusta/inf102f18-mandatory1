package no.uib.ii.inf102.f18.mandatory1;

public interface IStack<E> {
	public E pop();
	public void push(E data);
	public boolean empty();
}
