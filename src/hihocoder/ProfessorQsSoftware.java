package hihocoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ProfessorQsSoftware {

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      String[] part = br.readLine().split(" ");
      int N = Integer.parseInt(part[0]);
      int[] count = new int[N];
      int M = Integer.parseInt(part[1]);
      Queue<Integer> queue = new LinkedList<>();
      part = br.readLine().split(" ");
      for (int i = 0; i < M; i++)
        queue.add(Integer.parseInt(part[i]));
      Map<Integer, List<Integer>> map = new HashMap<>();
      int[][] m = new int[N][];
      for (int i = 0; i < N; i++) {
        part = br.readLine().split(" ");
        int key = Integer.parseInt(part[0]);
        int k = Integer.parseInt(part[1]);
        m[i] = new int[k];
        for (int j = 0; j < k; j++)
          m[i][j] = Integer.parseInt(part[2 + j]);
        if (map.containsKey(key))
          map.get(key).add(i);
        else {
          List<Integer> list = new ArrayList<>();
          list.add(i);
          map.put(key, list);
        }
      }
      while (!queue.isEmpty()) {
        int key = queue.poll();
        if (map.containsKey(key))
          for (int j : map.get(key)) {
            count[j] = (count[j] + 1) % 142857;
            for (int k = 0; k < m[j].length; k++)
              queue.add(m[j][k]);
          }
      }
      System.out.print(count[0]);
      for (int i = 1; i < N; i++)
        System.out.print(" " + count[i]);
      System.out.println();
    }
  }

}
