package interviews.rubrick;

public class problem1 {

	public static void main(String[] args) {
		//   0  1  2  3  4  5  6  7  8  9   10 
		// { 1, 2, 3, 4, 4, 5, 7, 8, 9, 12, 30}
		int[] a = new int[] { 1, 3, 9, 4, 12, 5, 7, 8, 30, 2, 4 };

		// System.out.println(alg1(array,-2));
		System.out.println(alg1(a, 5));
		//System.out.println(alg2(a, 0, a.length-1,0));
		
//		for (int i = 0; i < a.length; i++) 
//			System.out.print(a[i] + " ");
	}

	static int alg1(int[] a, int b) {
		int c = 0;
		int d = a.length - 1;
		while (d >= c) {
			System.out.println("alg1");
			int e = alg2(a, c, d, c);
			if (e == b) {
				return a[e];
			} else if (e < b) {
				c = e + 1;
			} else {
				d = e - 1;
			}
		}
		return -1;
	}

	static int alg2(int[] a, int b, int c, int d) {
		System.out.println("[alg2] b = " + b + " c = " + c + " d = " + d);
		int e = a[d];
		int f = b;
		alg3(a, d, c);
		for (int i = b; i < c; i++) {
			System.out.println("[alg2] " + a[i] + " < " + e + "?");
			if (a[i] < e) {
				alg3(a, i, f);
				f++;
			}
		}
		alg3(a, c, f);
		System.out.println("[alg2] return f = " + f);
		return f;
	}

	static void alg3(int[] a, int b, int c) {
		if (b != c) {
			a[c] = (a[b] = (a[c] = a[b] ^ a[c]) ^ a[b]) ^ a[c];
		}
		System.out.print("[alg3] ");
		for (int i = 0; i < a.length; i++) 
			System.out.print(a[i] + " ");
		System.out.println();
	}
}