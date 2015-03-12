package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class AandBandInterestingSubstrings {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int[] scores = new int[26];
    for (int i = 0; i < 26; i++)
      scores[i] = Integer.parseInt(part[i]);
    line = in.readLine();
    int n = line.length();
    long count = 0;
    long[] preSum = new long[n];
    int index = line.charAt(0) - 'a';
    preSum[0] = scores[index];
    Map<Integer, Map<Long, Long>> maps = new HashMap<>();
    for (int i = 0; i < 26; i++)
      maps.put(i, new HashMap<>());
    maps.get(index).put(preSum[0], 1L);
    for (int i = 1; i < n; i++) {
      int key = line.charAt(i) - 'a';
      preSum[i] = preSum[i - 1] + scores[key];
      if (maps.get(key).containsKey(preSum[i - 1]))
        count += maps.get(key).get(preSum[i - 1]);
      if (maps.get(key).containsKey(preSum[i]))
        maps.get(key).put(preSum[i], maps.get(key).get(preSum[i]) + 1L);
      else
        maps.get(key).put(preSum[i], 1L);
    }
    out.println(count);
    out.close();
    in.close();
  }
}
