package leetcode;

public class ZigZagConversion
{
	public String convert(String s, int nRows)
	{
		if (s == null || nRows < 1)
			return null;
		else if (nRows == 1)
		{
			return s;
		}
		else
		{
			StringBuffer[] sb = new StringBuffer[nRows];
			for (int i = 0; i < sb.length; i++)
			{
				sb[i] = new StringBuffer();
			}
			for (int i = 0; i < s.length(); i += 2 * nRows - 2)
			{
				sb[0].append(s.charAt(i));
			}
			for (int i = nRows - 1; i < s.length(); i += 2 * nRows - 2)
			{
				sb[sb.length - 1].append(s.charAt(i));
			}
			for (int i = 1; i < nRows - 1; i++)
			{
				int flag = 0;
				for (int j = i; j < s.length();)
				{
					sb[i].append(s.charAt(j));
					if (flag == 0)
					{
						j += 2 * nRows - 2 - i * 2;
						flag = 1;
					}
					else
					{
						j += i * 2;
						flag = 0;
					}
				}
			}
			for (int i = 1; i < sb.length; i++)
			{
				sb[0].append(sb[i]);
			}
			return sb[0].toString();
		}
	}
}
