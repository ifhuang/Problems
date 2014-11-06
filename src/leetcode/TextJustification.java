package leetcode;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;

public class TextJustification
{
	public List<String> fullJustify(String[] words, int L)
	{
		List<String> list = new LinkedList<>();
		if (words == null || words.length == 0)
			return list;
		else if (words.length == 1)
		{
			StringBuilder sb = new StringBuilder(words[0]);
			for (int i = words[0].length(); i < L; i++)
				sb.append(" ");
			list.add(sb.toString());
			return list;
		}
		int sum = 0;
		int tmp = L;
		int i = 0;
		for (; i < words.length; i++)
		{
			sum += words[i].length();
			if (sum > tmp)
				break;
			tmp--;
		}
		if (i == words.length)
		{
			StringBuilder sb = new StringBuilder(words[0]);
			int blank = L - sum - (i - 1);
			for (int j = 1; j < words.length; j++)
				sb.append(" ").append(words[j]);
			for (int j = 0; j < blank; j++)
				sb.append(" ");
			list.add(sb.toString());
		}
		else
		{
			StringBuilder sb = new StringBuilder(words[0]);
			int blank = L - (sum - words[i].length());
			if (i == 1)
			{
				for (int j = 0; j < blank; j++)
					sb.append(" ");
			}
			else
			{
				int a = blank % (i - 1);
				int b = blank / (i - 1);

				for (int j = 1; j < i; j++)
				{
					for (int k = 0; k < b; k++)
						sb.append(" ");
					if (a > 0)
					{
						sb.append(" ");
						a--;
					}
					sb.append(words[j]);
				}
			}
			String[] post = Arrays.copyOfRange(words, i, words.length);
			list = fullJustify(post, L);
			list.add(0, sb.toString());
		}
		return list;
	}

	public static void main(String[] args)
	{
		TextJustification solution = new TextJustification();
		String[] words = { "What", "must", "be", "shall", "be." };
		int L = 12;
		System.out.println(solution.fullJustify(words, L));

	}
}