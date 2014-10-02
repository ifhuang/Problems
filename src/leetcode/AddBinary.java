package leetcode;

public class AddBinary
{
	public String addBinary(String a, String b)
	{
		if (a == null && b == null || a.length() == 0 && b.length() == 0)
			return "";
		else if (a == null || a.length() == 0)
			return b;
		else if (b == null || b.length() == 0)
			return a;
		else
		{
			int lengthA = a.length();
			int lengthB = b.length();
			char lastA = a.charAt(lengthA - 1);
			char lastB = b.charAt(lengthB - 1);
			String preA = a.substring(0, lengthA-1);
			String preB = b.substring(0, lengthB-1);
			if (lastA == '0' && lastB == '0')
			{
				return addBinary(preA, preB) + '0';
			}
			else if (lastA == '0' && lastB == '1' || lastA == '1'
					&& lastB == '0')
			{
				return addBinary(preA, preB) + '1';
			}
			else if (lastA == '1' && lastB == '1')
			{
				return addBinary(addBinary(preA, preB), "1") + '0';
			}
			else
			{
				return null;
			}
		}
	}

	public static void main(String[] args)
	{
		AddBinary s = new AddBinary();
		System.out.println(s.addBinary("1", "111"));
	}
}