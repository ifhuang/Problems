package leetcode;

import java.util.ArrayList;

public class LetterCombinationsofaPhoneNumber
{
	private static String[] dic = new String[10];
	static
	{
		dic[2] = "abc";
		dic[3] = "def";
		dic[4] = "ghi";
		dic[5] = "jkl";
		dic[6] = "mno";
		dic[7] = "pqrs";
		dic[8] = "tuv";
		dic[9] = "wxyz";
	}

	public ArrayList<String> letterCombinations(String digits)
	{
		if (digits == null || digits.equals(""))
		{
			ArrayList<String> list = new ArrayList<>();
			list.add("");
			return list;
		}

		int kind = 1;
		for (int i = 0; i < digits.length(); i++)
		{
			kind *= dic[digits.charAt(i) - 48].length();
		}
		StringBuffer[] sb = new StringBuffer[kind];
		for (int i = 0; i < kind; i++)
		{
			sb[i] = new StringBuffer();
		}

		for (int i = 0; i < digits.length(); i++)
		{
			for (int k = 0; k < sb.length; k++)
			{
				sb[k].append(dic[digits.charAt(i) - 48].charAt(k % kind
						/ (kind / dic[digits.charAt(i) - 48].length())));
			}
			kind /= dic[digits.charAt(i) - 48].length();
		}

		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < sb.length; i++)
		{
			list.add(sb[i].toString());
		}
		return list;
	}
}
