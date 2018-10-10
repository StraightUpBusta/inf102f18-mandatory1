package no.uib.ii.inf102.f18.mandatory1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.SplittableRandom;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Torstein Strømme
 */
class QuickTest {
    private static final int N = 100_000;
    private static SplittableRandom r;
    private Integer[] arr;

    private void sort(Comparable[] arr) {
        Quick.sort(arr);
    }

    @SuppressWarnings("unchecked")
    private boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[i-1]) < 0)
                return false;
        }
        return true;
    }

    @BeforeAll
    static void setup() {
        r = new SplittableRandom(0);
    }

    @BeforeEach
    void createArray() {
        this.arr = new Integer[N];
    }

    @Test
    void sanityTest() {
        this.arr = new Integer[] {0, 9, 3, 5, 2, 1, 0, 4, 4, 4, 4, 9, 9, 7};
        Integer[] srt =          {0, 0, 1, 2, 3, 4, 4, 4, 4, 5, 7, 9, 9, 9};

        sort(this.arr);
        assertEquals(Arrays.toString(srt), Arrays.toString(this.arr));
        assertTrue(isSorted(this.arr));

        String[] sarr = {"hij", "abc", "cde", "zzz", "efg", "xzy"};
        String[] ssrt = {"abc", "cde", "efg", "hij", "xzy", "zzz"};

        assertFalse(isSorted(sarr));
        sort(sarr);
        assertEquals(Arrays.toString(ssrt), Arrays.toString(sarr));
        assertTrue(isSorted(sarr));
    }

    @Test
    void sortedTest() {
        int offset = - N / 2;
        for (int i = 0; i < N; i++) {
            arr[i] = i + offset;
        }

        sort(arr);
        assertTrue(isSorted(arr));
    }

    @Test
    void reversedTest() {
        int offset = N / 2;
        for (int i = 0; i < N; i++) {
            arr[i] = - i + offset;
        }

        sort(arr);
        assertTrue(isSorted(arr));
    }

    @RepeatedTest(5)
    void randomTest() {
        for (int i = 0; i < N; i++) {
            arr[i] = r.nextInt(N);
        }

        sort(arr);
        assertTrue(isSorted(arr));
    }

    @Test
    void twoNumbersTest() {
        for (int i = 0; i < N; i++) {
            arr[i] = r.nextBoolean() ? 1 : 0;
        }

        sort(arr);
        assertTrue(isSorted(arr));
    }

    @Test
    void oneNumbersTest() {
        for (int i = 0; i < N; i++) {
            arr[i] = 1;
        }

        sort(arr);
        assertTrue(isSorted(arr));
    }

    @Test
    void almostOneNumberTest() {
        for (int i = 0; i < N; i++) {
            arr[i] = 1;
        }
        arr[0] = 2;
        arr[N-1] = 0;
        arr[2*N/3] = 3;

        sort(arr);
        assertTrue(isSorted(arr));
    }
}
