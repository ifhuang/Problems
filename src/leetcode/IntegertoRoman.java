package leetcode;

public class IntegertoRoman
{
	public String intToRoman(int num)
	{
		if (num < 1 || num > 3999)
			return null;
		StringBuffer sb = new StringBuffer();

		while (num >= 1000)
		{
			sb.append("M");
			num -= 1000;
		}

		int now = num / 100;
		num -= now * 100;
		if (now == 9)
		{
			sb.append("CM");
		}
		else if (now < 9 && now > 4)
		{
			sb.append("D");
			while (now - 5 > 0)
			{
				sb.append("C");
				now--;
			}
		}
		else if (now == 4)
		{
			sb.append("CD");
		}
		else
		{
			while (now > 0)
			{
				sb.append("C");
				now--;
			}
		}

		now = num / 10;
		num -= now * 10;
		if (now == 9)
		{
			sb.append("XC");
		}
		else if (now < 9 && now > 4)
		{
			sb.append("L");
			while (now - 5 > 0)
			{
				sb.append("X");
				now--;
			}
		}
		else if (now == 4)
		{
			sb.append("XL");
		}
		else
		{
			while (now > 0)
			{
				sb.append("X");
				now--;
			}
		}

		now = num;
		if (now == 9)
		{
			sb.append("IX");
		}
		else if (now < 9 && now > 4)
		{
			sb.append("V");
			while (now - 5 > 0)
			{
				sb.append("I");
				now--;
			}
		}
		else if (now == 4)
		{
			sb.append("IV");
		}
		else
		{
			while (now > 0)
			{
				sb.append("I");
				now--;
			}
		}

		return sb.toString();
	}
}
