package telran.words.utils;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
	public static boolean isAnagram(String word, String part) {
		if (part == null || word == null || part.isEmpty() || word.isEmpty() || word.length() < part.length()) {
			return false;
		}

		part = part.toLowerCase();

		Map<Character, Integer> wordMap = new HashMap<>();
	
		for (int i = 0; i < word.length(); i++) {
			wordMap.merge(word.charAt(i), 1, (oldValue, value) -> oldValue + value);
		}

		for (int i = 0; i < part.length(); i++) {
			char ch = part.charAt(i);
			if (wordMap.get(ch) == null || wordMap.get(ch) == 0) {
				return false;
			}
			wordMap.put(ch, wordMap.get(ch) - 1);
		}

		return true;

	}

}
