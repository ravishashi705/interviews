package com.google;

import java.util.Arrays;

public class PlusOne {
	// brute-force with extra space 
	// runtime : O(n),space : O(N);
	public static int[] plusOne(int[] digits) {
		String s = "";
		for(int i = 0; i < digits.length; i++) {
			s += digits[i];
		}
		int result = 1 + Integer.parseInt(s);
		s = String.valueOf(result);
		
		int[] output = new int[s.length()];
		
		for(int i = 0; i < s.length(); i++) {
			output[i] = s.charAt(i) - '0';
		}
		return output;
	}

	public static void main(String[] args) {
		int[] digits = {9, 9, 9};
		System.out.println(Arrays.toString(plusOne(digits)));
	}

	
}
