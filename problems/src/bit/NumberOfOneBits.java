package bit;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits 
 * it has (also known as the Hamming weight).
 * 
 * https://leetcode.com/problems/number-of-1-bits/description/
 */
public class NumberOfOneBits {
	/*
	 * Brute-force solution, Runtime : O(N)
	 */
	public static int countOneBits(int number) {
		int count = 0;
		while(number != 0) {
			int val = number & 1;
			if(val > 0) {
				count++;
			}
			number = number >>> 1; // number >> 1 doesn't work for -ve numbers (infinite loop)
		}
		return count;
	}
	
	// Solution, check only one bits and would be faster
	// Runtime : O(K) - where K = number of 1 bits
	public static int countOneBitsFast(int number) {
		int count = 0;
		while(number != 0) {
			count++;
			number &= (number - 1);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countOneBits(0));
		System.out.println(countOneBits(1));
		System.out.println(countOneBits(2));
		System.out.println(countOneBits(3));
		System.out.println(countOneBits(4));
		System.out.println(countOneBits(-19));  // this solution doesn't work for -ve numbers - infinite loop
	
		System.out.println(countOneBitsFast(0));
		System.out.println(countOneBitsFast(1));
		System.out.println(countOneBitsFast(2));
		System.out.println(countOneBitsFast(3));
		System.out.println(countOneBitsFast(4));
		System.out.println(countOneBitsFast(-19));
	}

}
