package other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * V-Clustering from <<T-Drive: Driving Directions Based on Taxi Trajectories>>
 * Algorithm 3
 * 
 * @author If
 *
 */
public class VClustering
{
	private static Set<Integer> y_split = new TreeSet<>();

	/**
	 * initialize sorted list of y value
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public List<Integer> init(String path) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		List<Integer> list = new ArrayList<>();
		while ((line = br.readLine()) != null)
			list.add(Integer.parseInt(line.split(",")[1]));
		br.close();
		Collections.sort(list);
		return list;
	}

	/**
	 * recursive v-clustering algorithm
	 * 
	 * @param start
	 *            start index in original list
	 * @param list
	 * @param delta
	 * @return
	 */
	public Set<Integer> cluster(int start, List<Integer> list, double delta)
	{
		double var = getVAR(list);
		double minWeightedVAR = weightedVAR(0, list);
		int minIndex = 0;
		int n = list.size();
		for (int i = 1; i <= n; i++)
		{
			double temp = weightedVAR(i, list);
			if (temp < minWeightedVAR)
			{
				minWeightedVAR = temp;
				minIndex = i;
			}
		}
		if (var - minWeightedVAR < delta / n)
			return y_split;
		else
		{
			y_split.add(start + minIndex);
			cluster(start, list.subList(0, minIndex), delta);
			cluster(start + minIndex, list.subList(minIndex, n), delta);
			return y_split;
		}
	}

	/**
	 * 
	 * @param in
	 * @param out
	 * @param list
	 * @throws Exception
	 */
	public void output(String in, String out, List<Integer> list)
			throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(in));
		FileWriter fw = new FileWriter(out);
		String line;
		while ((line = br.readLine()) != null)
		{
			fw.write(line);
			fw.write(",");
			int i = Integer.parseInt(line.split(",")[1]);
			int j = 0;
			int n = list.size();
			for (; j < n; j++)
				if (i <= list.get(j))
				{
					fw.write(j + "\n");
					break;
				}
			if (j == n)
				fw.write(j + "\n");
		}
		br.close();
		fw.close();
	}

	private double weightedVAR(int i, List<Integer> list)
	{
		if (i == 0 || i == list.size())
			return getVAR(list);
		else
		{
			int n = list.size();
			double var1 = getVAR(list.subList(0, i));
			double var2 = getVAR(list.subList(i, n));
			double left = var1 * i / n;
			double right = var2 * (n - i) / n;
			return left + right;
		}
	}

	private double getVAR(List<Integer> list)
	{
		double avg = getAVG(list);
		double temp = 0.;
		for (int i : list)
			temp += (avg - i) * (avg - i);
		return temp / list.size();
	}

	private double getAVG(List<Integer> list)
	{
		double sum = 0.;
		for (int i : list)
			sum += i;
		return sum / list.size();
	}

	private static void Usage(Class<?> c, String[] args)
	{
		System.err.print("Usage: ");
		System.err.print(c.getSimpleName());
		for (String string : args)
		{
			System.err.print(" [" + string + "]");
		}
		System.err.println();
		System.exit(1);
	}

	public static void main(String[] args) throws Exception
	{
		if (args.length != 2)
			Usage(VClustering.class, new String[] { "Tuv.txt", "Tuv-out.txt" });
		VClustering vc = new VClustering();
		List<Integer> list = vc.init(args[0]);
		Set<Integer> set = vc.cluster(0, list, 40000);
		List<Integer> level = new ArrayList<>();
		for (int i : set)
			level.add(list.get(i));
		vc.output(args[0], args[1], level);
	}
}
