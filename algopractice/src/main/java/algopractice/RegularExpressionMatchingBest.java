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

public class RegularExpressionMatchingBest {

	public static void main(String[] args) {
		RegularExpressionMatchingBest r = new RegularExpressionMatchingBest();
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

    public boolean isMatch(String s, String p) {
        int sl = s.length();
		int pl = p.length();
		int[][] dp = new int[sl+1][pl+1];
        dp[0][0] = 1;
		return dpr(s,p,sl,pl,dp);
    }
    
    private boolean dpr(String s, String p, int i, int j, int[][] dp){
        if(dp[i][j] == 0){
            boolean valid = false;
            if(j>0 && p.charAt(j-1) == '*') {
                if(i>0 &&  (p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1))) {
                    valid= dpr(s,p,i,j-2,dp) || dpr(s,p,i-1,j,dp);
                }else{
                    valid = dpr(s,p,i,j-2,dp);
                }
            }else if(j>0 && i>0 && (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1))) {
                valid = dpr(s,p,i-1,j-1,dp);
            }
            dp[i][j] = valid ? 1 : -1;
        }
        return dp[i][j] > 0;
    }
}
