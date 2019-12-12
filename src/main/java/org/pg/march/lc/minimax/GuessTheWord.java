package org.pg.march.lc.minimax;

import java.util.HashSet;
import java.util.Set;

public class GuessTheWord {

	public void findSecretWord(String[] wordlist, Master master) {

		int N = wordlist.length;
		int[][] matched = new int[N][N];
		Set<Integer> possibilities = new HashSet<>();
		for (int i = 0; i < N; i++) {
			possibilities.add(i);
			for (int j = 0; j < N; j++) {
				matched[i][j] = match(wordlist[i], wordlist[j]);
			}
		}

		int match = 0;
		while (!possibilities.isEmpty() && match < 6) {
			int guessIndex = findGuessWord(possibilities, matched);
			match = master.guess(wordlist[guessIndex]);
			Set<Integer> newPossibilities = new HashSet<>();
			for (int possibility : possibilities) {
				if (possibility == guessIndex)
					continue;
				if (matched[guessIndex][possibility] == match) {
					newPossibilities.add(possibility);
				}
			}
			possibilities = newPossibilities;
		}

	}

	private int findGuessWord(Set<Integer> possibleWords, int[][] matched) {
		int ideal = possibleWords.size() / 2 + (possibleWords.size() % 2);
		int guessIndex = possibleWords.iterator().next();
		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < matched.length; i++) {
			if (possibleWords.contains(i)) {
				int[] size = new int[7];
				for (int possible : possibleWords) {
					if (possible == i)
						continue;
					size[matched[i][possible]]++;
				}
				for (int s : size) {
					if (Math.abs(s - ideal) < minDistance) {
						minDistance = Math.abs(s - ideal);
						guessIndex = i;
					}
				}
			}
		}
		return guessIndex;
	}

	private int match(String word1, String word2) {
		int len = Math.min(word1.length(), word2.length());
		int match = 0;
		for (int i = 0; i < len; i++) {
			if (word1.charAt(i) == word2.charAt(i)) {
				match++;
			}
		}
		return match;
	}

}
