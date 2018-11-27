package math;

/**
 * https://leetcode.com/articles/power-of-three/
 * Given an integer, write a function to determine if it is a power of three.
 */
public class PowerOf3 {
	
	public static boolean powerOfThree(int number) {
		if (number < 1)
			return false;
		while (number % 3 == 0) {
			number /= 3;
		}
		return number == 1;
	}

	public static void main(String[] args) {
		System.out.println(powerOfThree(28)); //f
		System.out.println(powerOfThree(81)); //t
		System.out.println(powerOfThree(27)); //t
		System.out.println(powerOfThree(241)); //f
	}

}
