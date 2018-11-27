package dailycoding;

import java.util.Arrays;
import java.util.Random;

/**
 * #51 : This problem was asked by Facebook.

Given a function that generates perfectly random numbers between 1 and k (inclusive), 
where k is an input, write a function that shuffles a deck of cards represented as an array using only swaps.

It should run in O(N) time.

Hint: Make sure each one of the 52! permutations of the deck is equally likely.
 */
public class ShuffleDeckOfCards {
	public static void shuffleDeck(int[] cards) {
		if(cards == null || cards.length < 52)
			return;
		
		Random random = new Random();
		for (int i = 0; i < cards.length; i++) {
			int rand = random.nextInt(i + 1);
			//int rand = i + random.nextInt(cards.length - i);
			swap(cards, i, rand);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] cards = new int[52];
		for (int i = 1; i <= 52; i++) {
			cards[i - 1] = i;
		}
		shuffleDeck(cards);
		System.out.println(Arrays.toString(cards));
	}
}