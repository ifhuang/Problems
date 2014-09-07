package leetcode;

public class RomantoInteger
{
	public int romanToInt(String s)
	{
		if (s == null || s.equals(""))
			return 0;

		int sum = 0;
		int i = 0;

		while (s.charAt(i) == 'M')
		{
			sum += 1000;
			i++;
			if (i == s.length())
				return sum;
		}

		if (s.charAt(i) == 'C' && i < s.length() - 1 && s.charAt(i + 1) == 'M')
		{
			sum += 900;
			i += 2;
		}
		else if (s.charAt(i) == 'C' && i < s.length() - 1
				&& s.charAt(i + 1) == 'D')
		{
			sum += 400;
			i += 2;
		}
		else if (s.charAt(i) == 'D')
		{
			sum += 500;
			i++;
			if (i == s.length())
				return sum;
			while (s.charAt(i) == 'C')
			{
				sum += 100;
				i++;
				if (i == s.length())
					return sum;
			}
		}
		else if (s.charAt(i) == 'C')
		{
			sum += 100;
			i++;
			if (i == s.length())
				return sum;
			while (s.charAt(i) == 'C')
			{
				sum += 100;
				i++;
				if (i == s.length())
					return sum;
			}
		}
		if (i == s.length())
			return sum;

		if (s.charAt(i) == 'X' && i < s.length() - 1 && s.charAt(i + 1) == 'C')
		{
			sum += 90;
			i += 2;
		}
		else if (s.charAt(i) == 'X' && i < s.length() - 1
				&& s.charAt(i + 1) == 'L')
		{
			sum += 40;
			i += 2;
		}
		else if (s.charAt(i) == 'L')
		{
			sum += 50;
			i++;
			if (i == s.length())
				return sum;
			while (s.charAt(i) == 'X')
			{
				sum += 10;
				i++;
				if (i == s.length())
					return sum;
			}
		}
		else if (s.charAt(i) == 'X')
		{
			sum += 10;
			i++;
			if (i == s.length())
				return sum;
			while (s.charAt(i) == 'X')
			{
				sum += 10;
				i++;
				if (i == s.length())
					return sum;
			}
		}
		if (i == s.length())
			return sum;

		if (s.charAt(i) == 'I' && i < s.length() - 1 && s.charAt(i + 1) == 'X')
		{
			sum += 9;
			i += 2;
		}
		else if (s.charAt(i) == 'I' && i < s.length() - 1
				&& s.charAt(i + 1) == 'V')
		{
			sum += 4;
			i += 2;
		}
		else if (s.charAt(i) == 'V')
		{
			sum += 5;
			i++;
			if (i == s.length())
				return sum;
			while (s.charAt(i) == 'I')
			{
				sum += 1;
				i++;
				if (i == s.length())
					return sum;
			}
		}
		else if (s.charAt(i) == 'I')
		{
			sum += 1;
			i++;
			if (i == s.length())
				return sum;
			while (s.charAt(i) == 'I')
			{
				sum += 1;
				i++;
				if (i == s.length())
					return sum;
			}
		}

		return sum;
	}
}
