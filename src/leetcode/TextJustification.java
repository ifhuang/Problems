package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://oj.leetcode.com/problems/text-justification/
public class TextJustification {
	public List<String> fullJustify(String[] words, int L) {
		List<String> ans = new ArrayList<>();
		int len = words.length;
		int start = 0;
		int sumWord = words[start].length();
		int sumWordSpace = sumWord;
		StringBuilder sb;
		for (int i = start + 1; i < len; i++) {
			sumWord += words[i].length();
			sumWordSpace += 1 + words[i].length();
			if (sumWordSpace > L) {
				sumWord -= words[i].length();
				int sumSpace = L - sumWord;
				sb = new StringBuilder();
				sb.append(words[start]);
				if (start + 1 == i)
					sb.append(nSpace(sumSpace));
				else {
					for (int j = start + 1; j < i - 1; j++) {
						int k = sumSpace / (i - j);
						if (k * (i - j) != sumSpace)
							k++;
						sumSpace -= k;
						sb.append(nSpace(k));
						sb.append(words[j]);
					}
					sb.append(nSpace(sumSpace));
					sb.append(words[i - 1]);
				}
				ans.add(sb.toString());
				start = i;
				sumWord = words[start].length();
				sumWordSpace = sumWord;
			}
		}
		int sumSpace = L - sumWord;
		sb = new StringBuilder();
		sb.append(words[start]);
		for (int i = start + 1; i < len; i++) {
			sb.append(nSpace(1));
			sb.append(words[i]);
			sumSpace--;
		}
		sb.append(nSpace(sumSpace));
		ans.add(sb.toString());
		return ans;
	}

	private String nSpace(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(' ');
		return sb.toString();
	}
}