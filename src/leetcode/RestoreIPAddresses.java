package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses
{
	public List<String> restoreIpAddresses(String s)
	{
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= 3; i++)
			for (int j = 1; j <= 3; j++)
				for (int k = 1; k <= 3; k++)
					for (int l = 1; l <= 3; l++)
						if (i + j + k + l == s.length())
						{
							StringBuffer ip = new StringBuffer();

							String p1 = s.substring(0, i);
							if (!check(p1))
								continue;
							ip.append(p1);
							ip.append(".");

							String p2 = s.substring(i, i + j);
							if (!check(p2))
								continue;
							ip.append(p2);
							ip.append(".");

							String p3 = s.substring(i + j, i + j + k);
							if (!check(p3))
								continue;
							ip.append(p3);
							ip.append(".");

							String p4 = s.substring(i + j + k);
							if (!check(p4))
								continue;
							ip.append(p4);

							result.add(ip.toString());
						}
		return result;
	}

	private boolean check(String p)
	{
		if (Integer.parseInt(p) > 255)
			return false;
		if (p.length() > 1 && p.startsWith("0"))
			return false;
		return true;
	}

	public static void main(String[] args)
	{
		RestoreIPAddresses s = new RestoreIPAddresses();
		System.out.println(s.restoreIpAddresses("010010"));
	}
}
