package no.uib.ii.inf102.f18.mandatory1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyStackTest {

	@Test
	void test() {
		MyStack<Integer> s = new MyStack<>();
		for (int i = 0; i < 5; i++) {
			s.push(i);
		}
		
		assertFalse(s.empty());
		
		for (int i = 0; i < 5; i++) {
			System.out.println(s.pop());
		}
		
		assertTrue(s.empty());
	}
}
