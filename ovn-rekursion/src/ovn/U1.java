package ovn;

public class U1 {

	public static void main(String[] args) {
		System.out.print(power(2, 4));
		System.out.println(power2(2, 4));

		System.out.print(power(5, 3));
		System.out.println(power2(5, 3));

		System.out.println(power2(2, -4));

		System.out.println(isPalindrome("Claudio"));
		System.out.println(isPalindrome("NITALARBRALATIN"));
		System.out.println();
		move(5, 1, 2, 3);
	
	}

	public static double power(double x, int n) {
		if (n == 0)
			return 1;
		else
			return x * power(x, n - 1);
	}

	public static double power2(double x, int n) {
		if (n <= 0)
			x = 1 / x;
		return power2Iter(x, n);
	}

	private static double power2Iter(double x, int n) {
		if (n == 0)
			return 1;
		else if (n % 2 == 0)
			return power2Iter(x, n / 2) * power2Iter(x, n / 2);
		else
			return x * power2Iter(x, n / 2) * power2Iter(x, n / 2);
	}

	public static boolean isPalindrome(String s) {
		return isPalindrome(s, 0, s.length() - 1);
	}

	private static boolean isPalindrome(String s, int fir, int las) {
		if (las <= fir) {
			return true;
		} else {
			System.out.println(s.charAt(fir) + ":" + s.charAt(las));
			return s.charAt(fir) != s.charAt(las) ? false : isPalindrome(s, fir + 1, las - 1);
		}
	}

	public static void move(int n, int start, int dest, int temp) {
		if (n == 1) {
			System.out.println("Move 1 from " + start + " to " + dest);
		} else {
			move(n - 1, start, temp, dest);
			System.out.println("Move "+ n +" from " + start + " to " + dest);
			move(n - 1, temp, dest, start);
		}
	}
}
