package algopractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ConcetrationOfWords2 {

	public static void main(String[] args) {
		ConcetrationOfWords2 cow = new ConcetrationOfWords2();
//		String[] words = { "bar", "foo", "the" };
//		String s = "barfoofoobarthefoobarman";
		String[] words = { "dhvf", "sind", "ffsl", "yekr", "zwzq", "kpeo", "cila", "tfty", "modg", "ztjg", "ybty",
				"heqg", "cpwo", "gdcj", "lnle", "sefg", "vimw", "bxcb" };
		String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";

		System.out.println(cow.findSubstring(s, words));
		;
	}

	public List<Integer> findSubstring(String s, String[] words) {
		Set<Integer> indexList = new HashSet<>();
		Set<String> permutaions = new HashSet<>();
		int[] a = { 0, 1, 2, 3, 4 };
		int[] p = new int[100];
		permute(a, p, 5);
		for (int i = 0; i < p.length; i++)
			System.out.println(p[i]);
//		findSubstringRecur("", new LinkedList<String>(Arrays.asList(words)), permutaions);
//		System.out.println(permutaions);
		for (String uniqueString : permutaions) {
			/*
			 * for (int i = 0; i < s.length(); i++) { int startIndex =
			 * s.indexOf(uniqueString); int start = startIndex; while(startIndex != -1) {
			 * indexList.add(startIndex); startIndex = s.indexOf(uniqueString, ++start);
			 * 
			 * } }
			 */}
		return new ArrayList<>(indexList);
	}

	static void permute(int A[], int P[], int n) {
		// For each element of P
		for (int i = 0; i < n; i++) {
			int next = i;

			// Check if it is already
			// considered in cycle
			while (P[next] >= 0) {

				// Swap the current element according
				// to the permutation in P
				swap(A, i, P[next]);
				int temp = P[next];

				// Subtract n from an entry in P
				// to make it negative which indicates
				// the corresponding move
				// has been performed
				P[next] -= n;
				next = temp;
			}
		}
	}

	static int[] swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

	public void findSubstringRecur(String sb, List<String> words, Set<String> permutaions) {
		for (int i = 0; i < words.size(); i++) {
			List<String> newWords = new LinkedList<>(words);
			newWords.remove(i);
			findSubstringRecur(sb + words.get(i), newWords, permutaions);
		}
		if (words.size() == 0)
			permutaions.add(sb);
	}

}
