package leetcode;

public class LRUCache
{
	private java.util.LinkedHashMap<Integer, Integer> map;
	int size;

	public LRUCache(int capacity)
	{
		size = capacity;
		map = new java.util.LinkedHashMap<Integer, Integer>(size, 0.75f, true)
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected boolean removeEldestEntry(
					java.util.Map.Entry<Integer, Integer> eldest)
			{
				return size() > size;
			}

		};
	}

	public int get(int key)
	{
		Integer value = map.get(key);
		if (value == null)
			return -1;
		else
			return value;
	}

	public void set(int key, int value)
	{
		map.put(key, value);
	}
}
