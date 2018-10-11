package no.uib.ii.inf102.f18.mandatory1;

public class BSTDebugging {
	public static void main(String[] args) {
		if (debug()) {
			System.out.print("valid");
		} else {
			System.out.print("invalid");
		}
	}
	
	public static boolean debug() {
		Kattio io = new Kattio(System.in, System.out);
		int n = io.getInt();
		int m = io.getInt();
		int lb = Integer.MIN_VALUE; // lower bound
		int ub = Integer.MAX_VALUE; // upper bound
		
		int prev = io.getInt();
		int compareExpected = 0;
		if (m > prev) {
			compareExpected = 1; // go right
			lb = prev;
		} else if (m < prev) {
			compareExpected = -1; // go left
			ub = prev;
		} else {
			if (n > 1) return false;
			return true;
		}
		
		for (int i = 1; i < n; i++) {
			int compare = -1;
			int current = io.getInt();
			if (current > prev) compare = 1;

			if (compare != compareExpected) return false;
			if (current <= lb || current >= ub) return false;
			
			if (m > current) { // go right
				compareExpected = 1;
				lb = current;
			} else if (m < current) { // go left
				compareExpected = -1;
				ub = current;
			} else {
				if (i < n-1) return false;
				return true;
			}
			
			prev = current;
		}
		return true;
	}
}
