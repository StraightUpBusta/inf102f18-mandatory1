package no.uib.ii.inf102.f18.mandatory1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test
 */
class UnorderedIndexMaxPQTest {
	
	private IIndexPQ<String> pq;

	@BeforeEach
	void setup() {
		this.pq = new UnorderedIndexMaxPQ<String>();
	}

	@Test
	void sanityTest() {
        pq.add(0, "A");
        pq.add(3, "K");
        pq.add(6, "E");
        pq.add(2, "J");
        assertEquals(4, pq.size());
        assertEquals(3, pq.peek());
        assertEquals("K", pq.peekKey());
        assertEquals("K", pq.getKey(3));
        assertEquals("A", pq.getKey(0));
        assertEquals("J", pq.getKey(2));

        assertTrue(pq.contains(3));
        assertEquals(3, pq.poll());
        assertFalse(pq.contains(3));
        assertEquals(2, pq.poll());

        pq.changeKey(0, "Z");
        assertEquals("Z", pq.peekKey());
        assertEquals(0, pq.poll());
        assertEquals("E", pq.peekKey());
        assertEquals(6, pq.poll());
        assertEquals(0, pq.size());
	}
	
}
