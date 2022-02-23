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

public class RegularExpressionMatching2 {

	public static void main(String[] args) {
		RegularExpressionMatching2 r = new RegularExpressionMatching2();
//		System.out.println(r.isMatch("aaaabcdefgab", "a*aa*bc*.*efga*"));
//		System.out.println(r.isMatch("aaaabcdef", ".*"));
		String p = new String("aa");
		String s = new String("a");
//		System.out.println(r.isMatch(p, s));
//		System.out.println(r.isMatch("aa", "a*"));
//		System.out.println(r.isMatch("ab", ".*"));
//		System.out.println(r.isMatch("aab", "c*a*b"));
		System.out.println(r.isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"));

	}

	int sLength, pLength;
	public boolean isMatch(String s, String p) {
		return recursiveMatch(s, p, 0, 0, s.length(), p.length());
	}

	public boolean recursiveMatch(String s, String p, int sPosition, int pPosition, int sLength, int pLength) {
		if (pPosition >= pLength) {
			return sPosition >= sLength ? true : false;
		}
		char patternToMatch = p.charAt(pPosition);
		char nextPatternToMatch = pLength - pPosition > 1 ? p.charAt(pPosition + 1) : 0;
		System.out.println(s.substring(sPosition));

		if (patternToMatch == '.' && nextPatternToMatch == '*') {
			for (int i = sPosition; i < sLength; i++) {
				if (true == recursiveMatch(s, p, i, pPosition + 2, sLength, pLength)) {
					return true;
				}
			}
			if (true == recursiveMatch("", p, 0, pPosition + 2, 0, pLength)) {
				return true;
			}
		} else if (nextPatternToMatch == '*') {
			if (true == recursiveMatch(s, p, sPosition, pPosition + 2, sLength, pLength)) {
				return true;
			}
			for (int i = sPosition; i < sLength; i++) {
				if (s.charAt(i) == patternToMatch) {
					if (true == recursiveMatch(s, p, i + 1, pPosition + 2, sLength, pLength)) {
						return true;
					}
				} else {
					break;
				}
			}
		} else if (sLength > sPosition && (patternToMatch == '.' || s.charAt(sPosition) == patternToMatch)) {
			return recursiveMatch(s, p, sPosition + 1, pPosition + 1, sLength, pLength);

		} else if (sPosition >= sLength || s.charAt(sPosition) != patternToMatch) {
			return false;
		}
		return false;
	}
}
