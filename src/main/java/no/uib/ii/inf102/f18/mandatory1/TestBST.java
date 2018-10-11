package no.uib.ii.inf102.f18.mandatory1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBST {

	@Test
	void test() {
		// test get()
		BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
		bst.put(12, "12");
		bst.put(1, "1");
		bst.put(123, "123");
		assertTrue(bst.get(123).equals("123"));
		
		// test iterator
		bst = new BinarySearchTree<>();
		
		for (int i = 0; i < 50; i++) {
			bst.put(i, Integer.toString(i));
		}
		
		Iterable<Integer> keys = bst.keys();
		
		for (Integer s : keys) {
			System.out.println(s);
		}
	}
}
