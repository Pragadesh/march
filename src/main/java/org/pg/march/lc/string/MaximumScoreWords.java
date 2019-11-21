package org.pg.march.lc.string;

/*
 * https://leetcode.com/contest/weekly-contest-162/problems/maximum-score-words-formed-by-letters/
 */
public class MaximumScoreWords {
	
	private String[] words;
	private int[] score;
	private static final char startChar = 'a';

	public int maxScoreWords(String[] words, char[] letters, int[] score) {
		this.score = score;
		this.words = words;
		int[] charCounter = new int[26];
		for(char letter : letters) {
			charCounter[letter - startChar]++;
		}
		return calculateScore(charCounter, 0, words.length - 1, 0);
	}
	
	
	private int calculateScore(int[] charCounter, int index, int maxIndex, int currentScore) {
		if(index == maxIndex) {
			String word = words[index];
			if(isWordPossible(word, charCounter)) {
				currentScore += score(word);
				returnWord(word, charCounter);
			}
			return currentScore;
		}else if (index < maxIndex) {
			int maxScore = calculateScore(charCounter, index+1, maxIndex, currentScore);
			String word = words[index];
			if(isWordPossible(word, charCounter)) {
				maxScore = Math.max(maxScore, calculateScore(charCounter, index+1, maxIndex, currentScore + score(word)));
				returnWord(word, charCounter);
			}
			return maxScore;
		}else {
			throw new IllegalStateException(String.format("Illegal index %d of %d", index, maxIndex));
		}
	}
	
	private boolean isWordPossible(String word, int[] charCounter) {
		for (int i = 0; i < word.length(); i++) {
			if (--charCounter[word.charAt(i) - startChar] < 0) {
				returnWord(word, i, charCounter);
				return false;
			}
		}
		return true;
	}
	
	private void returnWord(String word, int lastIdx, int[] charCounter) {
		for(int i=0; i<= lastIdx; i++) {
			charCounter[word.charAt(i) - startChar]++;
		}
	}
	
	private void returnWord(String word, int[] charCounter) {
		returnWord(word, word.length() - 1, charCounter);
	}
	
	private int score(String word) {
		int score = 0;
		for (int i = 0; i < word.length(); i++) {
			score += this.score[word.charAt(i) - startChar];
		}
		return score;
	}

}
