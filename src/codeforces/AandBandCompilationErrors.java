package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class AandBandCompilationErrors {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    in.readLine();
    Map<String, Integer> mapA = new HashMap<>();
    Map<String, Integer> mapB = new HashMap<>();
    String line = in.readLine();
    String[] part = line.split(" ");
    for (int i = 0; i < part.length; i++) {
      if (mapA.containsKey(part[i]))
        mapA.put(part[i], mapA.get(part[i]) + 1);
      else
        mapA.put(part[i], 1);
    }
    line = in.readLine();
    part = line.split(" ");
    for (int i = 0; i < part.length; i++) {
      if (mapA.get(part[i]) > 1)
        mapA.put(part[i], mapA.get(part[i]) - 1);
      else
        mapA.remove(part[i]);
      if (mapB.containsKey(part[i]))
        mapB.put(part[i], mapB.get(part[i]) + 1);
      else
        mapB.put(part[i], 1);
    }
    for (String k : mapA.keySet())
      out.println(k);
    line = in.readLine();
    part = line.split(" ");
    for (int i = 0; i < part.length; i++) {
      if (mapB.get(part[i]) > 1)
        mapB.put(part[i], mapB.get(part[i]) - 1);
      else
        mapB.remove(part[i]);
      if (mapA.containsKey(part[i]))
        mapA.put(part[i], mapA.get(part[i]) + 1);
      else
        mapA.put(part[i], 1);
    }
    for (String k : mapB.keySet())
      out.println(k);
    out.close();
    in.close();
  }
}
