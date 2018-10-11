package no.uib.ii.inf102.f18.mandatory1;

public class BSTDebugging {
	public static void main(String[] args) {
		boolean isValid = debug();
		
		if (isValid) {
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
		
		boolean largerExpected = false;
		if (m > prev) {
			largerExpected = true; // go right
			lb = prev;
		} else if (m < prev) {
			largerExpected = false; // go left
			ub = prev;
		} else {
			if (n > 1) return false;
			return true;
		}
		
		for (int i = 1; i < n; i++) {
			boolean isLarger = false;
			int current = io.getInt();
			if (current > prev) isLarger = true;

			if (isLarger != largerExpected) return false;
			if (current <= lb || current >= ub) return false;
			
			if (m > current) { // go right
				largerExpected = true;
				lb = current;
			} else if (m < current) { // go left
				largerExpected = false;
				ub = current;
			} else {
				if (i != n-1) return false;
				return true;
			}
			
			prev = current;
		}
		return true;
	}
}
