package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FlattenIterator
{
	public static void main(String args[]) throws Exception
	{
		List<Iterator<String>> lists = new ArrayList<>();
		lists.add(Arrays.asList("a", "b", "c").iterator());
		lists.add(null);
		lists.add(Arrays.<String> asList().iterator());
		lists.add(Arrays.asList("d", "e").iterator());
		lists.add(Arrays.<String> asList().iterator());
		lists.add(Arrays.asList("f", "g").iterator());
		lists.add(null);

		Iterator<Iterator<String>> iters = lists.iterator();

		Iterator<String> flattened = flatten(iters);
		while (flattened.hasNext())
		{
			System.out.println(flattened.next());
		}
	}

	/** @return Iterator which flattens the given arguments */
	public static Iterator<String> flatten(
			final Iterator<Iterator<String>> iters)
	{
		return new Iterator<String>()
		{
			private Iterator<String> currentIterator;
			private String nextString = findNext();

			private String findNext()
			{
				String string;
				while (currentIterator == null || !currentIterator.hasNext()
						|| (string = currentIterator.next()) == null)
				{
					if (!iters.hasNext())
						return null;
					currentIterator = iters.next();
				}
				return string;
			}

			public boolean hasNext()
			{
				return nextString != null;
			}

			public String next()
			{
				String tmp = nextString;
				nextString = findNext();
				return tmp;
			}

			public void remove()
			{
				throw new UnsupportedOperationException();
			}
		};
	}
}
