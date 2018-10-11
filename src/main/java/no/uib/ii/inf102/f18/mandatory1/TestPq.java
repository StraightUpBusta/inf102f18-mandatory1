package no.uib.ii.inf102.f18.mandatory1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPq {

	@Test
	void testSanity() {
		IndexMinPq<String> pq = new IndexMinPq<>(10);
		
		// peek() - correct index
		pq.add(2, "a");
		assertTrue(pq.peek() == 2);
		
		// add() - correct index and key
		pq = new IndexMinPq<>(10);
		pq.add(4, "a");
		assertTrue(pq.getKey(4).equals("a")); 

		// changeKey() - new value
		pq.changeKey(4, "b");
		assertTrue(pq.getKey(4).equals("b")); 
		
		// changeKey() - priority maintained
		pq = new IndexMinPq<>(10);
		pq.add(1, "b");
		pq.add(2, "a");
		assertTrue(pq.peek() == 2);
		pq.changeKey(2, "c");
		assertTrue(pq.peek() == 1);
		pq.changeKey(2, "a");
		assertTrue(pq.peek() == 2);

		// contains() - true and false
		pq = new IndexMinPq<>(10);
		pq.add(1, "b");
		assertTrue(pq.contains(1));
		assertFalse(pq.contains(2));
		
		// deleted() - priority is maintained
		pq = new IndexMinPq<>(10);
		pq.add(1, "b");
		pq.add(2, "a");
		assertTrue(pq.peek() == 2);
		pq.delete(2);
		assertTrue(pq.peek() == 1);
		
	
	}
}
