package no.uib.ii.inf102.f18.mandatory1;
import java.util.SplittableRandom;

public class IterativeQuick {
	private static MyStack<Integer> ranges = new MyStack<>();
	
	public static Comparable[] sort(Comparable[] arr) {
		shuffle(arr);
		ranges.push(arr.length); // ub exclusive
		ranges.push(0); // lb inclusive
		
		while(!ranges.empty()) {
			int lb = ranges.pop();
			int ub = ranges.pop();
			if (lb + 1 >= ub) continue;
			int pivotPosition = partition(arr, lb, ub);
			ranges.push(ub);
			ranges.push(pivotPosition + 1);
			ranges.push(pivotPosition);
			ranges.push(lb);
		}
		
		return arr;
	}
	
	public static int partition(Comparable[] arr, int lb, int ub) {
		Comparable pivot = arr[lb];
		int i = lb;
		int j = ub;
		
		while(true) {
			while(++i < ub && arr[i].compareTo(pivot) < 0);
			while(arr[--j].compareTo(pivot) > 0);
			
			if (i >= j) break;
			swap(i, j, arr);
		}
		
		swap(lb, j, arr);
		return j;
	}
	
    /**
     * Simple shuffling procedure (Fisher-Yates/Durstenfeld/Knuth)
     * Resulting permutation is chosen uniformly at random
     *
     * @param arr array to be shuffled
     */
    private static void shuffle(Comparable[] arr) {
        SplittableRandom r = new SplittableRandom();
        for (int i = 0; i < arr.length; i++) {
            int j = r.nextInt(arr.length-i) + i;
            swap(i, j, arr);
        }
    }
    
    private static void swap(int i, int j, Comparable[] arr) {
    	Comparable temp = arr[j];
    	arr[j] = arr[i];
    	arr[i] = temp;
    }
}
