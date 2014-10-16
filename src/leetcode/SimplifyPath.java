package leetcode;

public class SimplifyPath
{
	public String simplifyPath(String path)
	{
		if (path == null || path.length() < 2)
			return path;
		path = removeMultiSepa(path);
		path = removeSepaDot(path);
		path = removeDotDot(path);
		if (path.length() > 1 && path.charAt(path.length() - 1) == '/')
			path = path.substring(0, path.length() - 1);
		return path;
	}

	private String removeMultiSepa(String s)
	{
		boolean flag = false;
		for (int i = 0; i < s.length();)
			if (s.charAt(i) == '/' && !flag)
			{
				flag = true;
				i++;
			}
			else if (s.charAt(i) == '/' && flag)
				s = s.substring(0, i) + s.substring(i + 1);
			else
			{
				flag = false;
				i++;
			}
		return s;
	}

	private String removeSepaDot(String s)
	{
		if (s.equals("/."))
			return "/";
		for (int i = 0; i < s.length() - 2;)
			if (s.charAt(i) == '/' && s.charAt(i + 1) == '.'
					&& s.charAt(i + 2) == '/')
				s = s.substring(0, i) + s.substring(i + 2);
			else
				i++;
		if (s.length() > 2 && s.charAt(s.length() - 2) == '/'
				&& s.charAt(s.length() - 1) == '.')
			s = s.substring(0, s.length() - 2);
		return s;
	}

	private String removeDotDot(String s)
	{
		if (s.equals("/.."))
			return "/";
		for (int i = 0; i < s.length() - 2;)
			if (s.charAt(i) == '/' && s.charAt(i + 1) == '.'
					&& s.charAt(i + 2) == '.')
			{
				if (i == 0 && i + 3 == s.length())
					return "/";
				else if (i > 0 && i + 3 == s.length())
				{
					int j = i - 1;
					for (; j >= 0; j--)
						if (s.charAt(j) == '/')
							break;
					if (j == -1)
						j = 0;
					s = s.substring(0, j + 1);
					return s;
				}
				if (s.charAt(i + 3) == '/')
				{
					int j = i - 1;
					for (; j >= 0; j--)
						if (s.charAt(j) == '/')
							break;
					if (j == -1)
						j = 0;
					s = s.substring(0, j + 1) + s.substring(i + 4);
					i = j;
				}
				else
					i++;
			}
			else
				i++;
		return s;
	}

	public static void main(String[] args)
	{
		SimplifyPath solution = new SimplifyPath();
		System.out.println(solution
				.simplifyPath("/.././J/jYTp/../bumPe///raH/../."));
	}
}