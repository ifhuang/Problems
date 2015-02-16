package other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EClustering {
  private static Set<Integer> x_split = new TreeSet<>();
  private static int classNum = 0;

  public static void Usage(Class<?> c, String[] args) {
    System.err.print("Usage: ");
    System.err.print(c.getSimpleName());
    for (String string : args) {
      System.err.print(" [" + string + "]");
    }
    System.err.println();
    System.exit(1);
  }

  public List<Integer> init(String path) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader(path));
    String line;
    List<Integer> list = new ArrayList<>();
    while ((line = br.readLine()) != null) {
      int c = Integer.parseInt(line.split(",")[2]);
      classNum = Math.max(classNum, c + 1);
      list.add(c);
    }
    br.close();
    return list;
  }

  public void cluster(int start, List<Integer> list, double delta) {
    double ent = getENT(list);
    double minWeightedENT = weightedENT(0, list);
    int minIndex = 0;
    int n = list.size();
    for (int i = 1; i <= n; i++) {
      double temp = weightedENT(i, list);
      if (temp < minWeightedENT) {
        minWeightedENT = temp;
        minIndex = i;
      }
    }
    if (ent - minWeightedENT >= delta / n) {
      x_split.add(start + minIndex);
      cluster(start, list.subList(0, minIndex), delta);
      cluster(start + minIndex, list.subList(minIndex, n), delta);
    }
  }

  public static Set<Integer> getX_split() {
    return x_split;
  }

  public void output(String in, String out, Set<Integer> set) throws Exception {
    List<Integer> list = new ArrayList<>(set);
    BufferedReader br = new BufferedReader(new FileReader(in));
    FileWriter fw = new FileWriter(out);
    String line;
    int index = 0;
    while ((line = br.readLine()) != null) {
      fw.write(line);
      fw.write(",");
      int j = 0;
      int n = set.size();
      for (; j < n; j++)
        if (index < list.get(j)) {
          fw.write(j + "\n");
          break;
        }
      if (j == n)
        fw.write(j + "\n");
      index++;
    }
    br.close();
    fw.close();
  }

  private double getENT(List<Integer> list) {
    int[] count = new int[classNum];
    for (int i : list)
      count[i]++;
    double[] p = new double[classNum];
    for (int i = 0, n = list.size(); i < p.length; i++)
      p[i] = (double) count[i] / (double) n;
    double sum = 0.;
    for (int i = 0; i < classNum; i++) {
      if (count[i] == 0)
        sum += 0.;
      else
        sum += p[i] * Math.log(p[i]);
    }
    return -sum;
  }

  private double weightedENT(int i, List<Integer> list) {
    if (i == 0 || i == list.size())
      return getENT(list);
    else {
      int n = list.size();
      double ent1 = getENT(list.subList(0, i));
      double ent2 = getENT(list.subList(i, n));
      double left = ent1 * i / n;
      double right = ent2 * (n - i) / n;
      return left + right;
    }
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 2)
      Usage(VClustering.class, new String[] {"Tuv-out.txt", "Tuv-out-2.txt"});
    EClustering ec = new EClustering();
    List<Integer> list = ec.init(args[0]);
    System.out.println("init done, list size: " + list.size());
    ec.cluster(0, list, 1.1);
    System.out.println("cluster done");
    Set<Integer> set = getX_split();
    System.out.println("x index split set: " + set);
    ec.output(args[0], args[1], set);
    System.out.println("output done");
  }

}
