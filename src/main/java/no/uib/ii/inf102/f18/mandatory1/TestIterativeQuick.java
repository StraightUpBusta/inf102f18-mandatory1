package no.uib.ii.inf102.f18.mandatory1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestIterativeQuick {

	@Test
	void test() {
		IterativeQuick iq = new IterativeQuick();
		Integer[] arr = {1, 2, 3, 5, 3, 99, 55, 44, 22};
		iq.sort(arr);
		
		Integer prev = arr[0];
		for (int i = 1; i < arr.length; i++) {
			assertTrue(prev <= arr[i]);
			prev = arr[i];
		}
	}

}
