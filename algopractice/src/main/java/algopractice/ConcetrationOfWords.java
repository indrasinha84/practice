package algopractice;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class ConcetrationOfWords {

	public static void main(String[] args) {
		ConcetrationOfWords cow = new ConcetrationOfWords();
		String[] words = { "bar", "foo", "the" };
		String s = "barfoofoobarthefoobarman";
		System.out.println(cow.findSubstring(s, words));

	}

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> indexList = Lists.newArrayList();
		for (String word : words) {
			int startIndex = s.indexOf(word);
			while (startIndex != -1) {
				System.out.println("Iterating for " + s + ":" + word + ":" + ":" + startIndex + ":" + words.length);

				List<String> newWords = Lists.newArrayList(words);
				newWords.remove(word);
				if (findSubstring(s.substring(startIndex + word.length()), newWords)) {
					indexList.add(startIndex);
				}
				startIndex = s.indexOf(word, startIndex + word.length());
			}
		}
		return indexList;

	}

	public boolean findSubstring(String s, List<String> words) {
		if (words.size() == 0) {
			return true;
		} else if (s.isEmpty() && words.size() > 0) {
			return false;
		}
		for (String word : words) {
			int startIndex = s.indexOf(word);
			System.out.println(s + ":" + word + ":" + ":" + startIndex + ":" + words.size());
			if (startIndex == 0) {
				List<String> newWords = Lists.newArrayList(words);
				newWords.remove(word);
				return findSubstring(s.substring(startIndex + word.length()), newWords);
			}
		}
		return false;

	}
}
