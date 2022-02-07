package algopractice;

/******
 * 
 * 
 * 10. Regular Expression Matching
 * 
 * Given an input string s and a pattern p, implement regular expression
 * matching with support for '.' and '*' where:
 * 
 * '.' Matches any single character.​​​​ '*' Matches zero or more of the
 * preceding element. The matching should cover the entire input string (not
 * partial).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aa", p = "a" Output: false Explanation: "a" does not match the
 * entire string "aa". Example 2:
 * 
 * Input: s = "aa", p = "a*" Output: true Explanation: '*' means zero or more of
 * the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes
 * "aa". Example 3:
 * 
 * Input: s = "ab", p = ".*" Output: true Explanation: ".*" means "zero or more
 * (*) of any character (.)". Example 4:
 * 
 * Input: s = "aab", p = "c*a*b" Output: true Explanation: c can be repeated 0
 * times, a can be repeated 1 time. Therefore, it matches "aab". Example 5:
 * 
 * Input: s = "mississippi", p = "mis*is*p*." Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 20 1 <= p.length <= 30 s contains only lowercase English
 * letters. p contains only lowercase English letters, '.', and '*'. It is
 * guaranteed for each appearance of the character '*', there will be a previous
 * valid character to match.
 * 
 ********/

public class RegularExpressionMatching {

	public static void main(String[] args) {
		RegularExpressionMatching r = new RegularExpressionMatching();
//		System.out.println(r.isMatch("aaaabcdefgab", "a*aa*bc*.*efga*"));
//		System.out.println(r.isMatch("aaaabcdef", ".*"));
		String p = new String("aa");
		String s = new String("a");
//System.out.println(p == p1);
		System.out.println(r.isMatch(p, s));
//		System.out.println(r.isMatch("aa", "a*"));
//		System.out.println(r.isMatch("ab", ".*"));
//		System.out.println(r.isMatch("aab", "c*a*b"));
//		System.out.println(r.isMatch("mississippi", "mis*is*p*."));




	}

	public boolean isMatch(String s, String p) {
		if (p.isEmpty() || p.isBlank()) {
			return s.isEmpty() ? true : false;
		}
		char patternToMatch = p.charAt(0);
		char nextPatternToMatch = p.length() > 1 ? p.charAt(1) : 0;

		if (patternToMatch == '.' && nextPatternToMatch == '*') {
			for (int i = 0; i < s.length(); i++) {
				if (true == isMatch(s.substring(i), p.substring(2))) {
					return true;
				}
			}
			if (true == isMatch("", p.substring(2))) {
				return true;
			}
		} else if (nextPatternToMatch == '*') {
			if (true == isMatch(s.substring(0), p.substring(2))) {
				return true;
			}
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == patternToMatch) {
					if (true == isMatch(s.substring(i + 1), p.substring(2))) {
						return true;
					}
				} else {
					break;
				}
			}
		} else if (!s.isEmpty() && (patternToMatch == '.' || s.charAt(0) == patternToMatch)) {
			return isMatch(s.substring(1), p.substring(1));

		} else if (s.isEmpty() || s.charAt(0) != patternToMatch) {
			return false;
		}
		return false;
	}
}
