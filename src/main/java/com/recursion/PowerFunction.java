package com.recursion;

/**
 * Implement the power function pow(x, n) , which calculates the x raised to n
 * i.e. xn.
 * 
 * 
 * Examples: Input : x = 2.0000 , n = 10
 * 
 * Output : 1024.0000
 * 
 * Explanation : Answer = 2^10 => 1024.
 */

public class PowerFunction {

	public double myPow(double x, int n) {

		return supportingmyPow(x, (long) n);

	}

	public double supportingmyPow(double x, long n) {

		// Base Case:
		if (n == 0) {
			return 1;
		}

		if (n < 0) {
			return 1 / supportingmyPow(x, -n);
		}

		double half = supportingmyPow(x, (n / 2));

		if (n % 2 == 0) {

			return half * half;

		} else

		{
			return half * half * x;
		}
	}

	public static void main(String[] args) {

		PowerFunction powerFunction = new PowerFunction();
		double output = powerFunction.myPow(2, 100000);
		System.out.println(output);

	}

}
