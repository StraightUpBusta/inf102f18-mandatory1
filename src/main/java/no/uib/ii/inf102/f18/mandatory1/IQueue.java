package no.uib.ii.inf102.f18.mandatory1;

public interface IQueue<E> {
	public void enqueue(E item);
	public E dequeue();
	public boolean isEmpty();
}
