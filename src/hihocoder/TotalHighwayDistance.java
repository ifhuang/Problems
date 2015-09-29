package hihocoder;

import java.io.PrintWriter;
import java.util.Scanner;

public class TotalHighwayDistance {
  static Scanner in;
  static PrintWriter out;

  static void solve() {
    int N = in.nextInt(), M = in.nextInt();
    int[][] g = new int[N][N];
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        g[i][j] = -1;
    for (int i = 1; i < N; i++) {
      int u = in.nextInt(), v = in.nextInt(), k = in.nextInt();
      g[u - 1][v - 1] = g[v - 1][u - 1] = k;
    }
    for (int i = 0; i < M; i++) {
      String s = in.next();
      if (s.equals("QUERY"))
        out.println(query(g, N));
      else {
        int u = in.nextInt(), v = in.nextInt(), k = in.nextInt();
        g[u - 1][v - 1] = g[v - 1][u - 1] = k;
      }
    }
  }

  static int query(int[][] g, int N) {
    int[][] dis = new int[N][N];
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        dis[i][j] = -1;
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        if (g[i][j] > -1)
          dfs(g, dis, g[i][j], i, j);
    int ans = 0;
    for (int i = 0; i < N; i++)
      for (int j = i + 1; j < N; j++)
        ans += dis[i][j];
    return ans;
  }

  static void dfs(int[][] g, int[][] dis, int pre, int i, int j) {
    dis[i][j] = pre;
    for (int k = 0; k < g[j].length; k++)
      if (g[j][k] > -1 && dis[i][k] == -1 && i != k)
        dfs(g, dis, pre + g[j][k], i, k);
  }

  public static void main(String[] args) {
    in = new Scanner(System.in);
    out = new PrintWriter(System.out);
    solve();
    out.close();
    in.close();
  }
}
