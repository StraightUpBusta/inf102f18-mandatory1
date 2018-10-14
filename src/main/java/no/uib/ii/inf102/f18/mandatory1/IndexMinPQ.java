package no.uib.ii.inf102.f18.mandatory1;

public class IndexMinPQ<Key extends Comparable<Key>> implements IIndexPQ<Key> {
	private int N;
	private int[] indices;
	private int[] pq;
	private Key[] keys;
	
	@SuppressWarnings("unchecked")
	public IndexMinPQ(int maxN) {
		keys = (Key[]) new Comparable[maxN + 1];
		indices = new int[maxN + 1];
		pq = new int[maxN + 1];
		for (int i = 0; i <= maxN; i++) indices[i] = -1;
	}
	
	@Override
	public void add(int index, Key key) {
		if (this.contains(index)) 
			throw new IllegalStateException("Index already in use");
		
		keys[index] = key;
		indices[index] = ++N;
		pq[N] = index;
		swim(N);
	}

	@Override
	public void changeKey(int index, Key key) {
		if (!this.contains(index)) 
			throw new IllegalStateException("Index not in use");
		
		this.delete(index);
		this.add(index, key);
	}

	@Override
	public boolean contains(int index) {
		if (index < 0 || index >= keys.length) {
			throw new IllegalArgumentException("Invalid index");
		}
		return indices[index] != -1;
	}

	@Override
	public void delete(int index) {
		if (!this.contains(index))
			throw new IllegalStateException("Index not in use");
		keys[index] = null;
		int i = indices[index];
		swap(i, N--);
		sink(i);
		indices[index] = -1;
	}

	@Override
	public Key getKey(int index) {
		if (!this.contains(index))
			throw new IllegalStateException("Index not in use");
		
		return keys[index];
	}

	@Override
	public Key peekKey() {
		if (isEmpty()) return null;
		return keys[pq[1]];
	}

	@Override
	public int peek() {
		if (isEmpty())
			return -1;
		return pq[1];
	}

	@Override
	public int poll() {
		if (isEmpty()) 
			return -1;
		
		int ret = pq[1];
		this.delete(ret);
		return ret;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	public void swim(int k) {
		while (k > 1 && less(k, k/2)) {
			swap(k, k/2);
			k = k/2;
		}
	}
	
	public void sink(int k) {
		while (2*k <= N) {
			int l = 2*k;
			if (l < N && less(l+1, l)) l++;
			if (less(k, l)) break;
			swap(l, k);
			k = l;
		}
	}
	
	public boolean less(int i, int j) {
		return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
	}
	
	public void swap(int i, int j) {
		int t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
		
		indices[pq[i]] = i;
		indices[pq[j]] = j;
	}
}
