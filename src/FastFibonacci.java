import java.math.BigInteger;

public class FastFibonacci {

	public static void main(String[] args) {
		System.out.println(fastFibonacciDoubling(8181));
	}

	/*
	 * Fast doubling method. 
	 * F(2n)   = F(n) * (2*F(n+1) - F(n)); 
	 * F(2n+1) = F(n+1)^2 + F(n)^2.
	 */
	private static BigInteger fastFibonacciDoubling(int n) {
		if (n < 0) throw new IllegalArgumentException("Please type in a number > 0");
		
		BigInteger nBigInteger = BigInteger.valueOf(n);
		BigInteger bigIntTwo = BigInteger.valueOf(2);
		
		BigInteger currentFib = BigInteger.ZERO; // = F(n)
		BigInteger nextFib = BigInteger.ONE; // = F(n+1)
		
		BigInteger steps = nBigInteger.mod(bigIntTwo) == BigInteger.ZERO ? nBigInteger.divide(bigIntTwo)
				: (nBigInteger.divide(bigIntTwo)).add(BigInteger.ONE);

		for (BigInteger i = steps; i.compareTo(BigInteger.ZERO) >= 0; i = i.subtract(BigInteger.ONE)) {
			
			BigInteger doubleCurrentFib = currentFib.multiply(bigIntTwo.multiply(nextFib).subtract(currentFib));
			BigInteger nextDoubleCurrentFib = currentFib.multiply(currentFib).add(nextFib.multiply(nextFib));

			currentFib = doubleCurrentFib;
			nextFib = nextDoubleCurrentFib;

			if (nBigInteger.divide(bigIntTwo.pow(i.intValue())).mod(bigIntTwo) != BigInteger.ZERO) {
				BigInteger c = currentFib.add(nextFib);
				currentFib = nextFib;
				nextFib = c;
			}
		}
		return currentFib;
	}

	private static long computeFibonacciRecursively(int n) {
		if (n <= 2)
			return 1;
		return computeFibonacciRecursively(n - 1) + computeFibonacciRecursively(n - 2);
	}
}