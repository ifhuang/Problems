package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class KuriyamaMiraisStones {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    int n = Integer.parseInt(line);
    line = in.readLine();
    String[] part = line.split(" ");
    long[] v = new long[n + 1];
    long[] p1 = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      v[i] = Long.parseLong(part[i - 1]);
      p1[i] = p1[i - 1] + v[i];
    }
    shuffleArray(v);
    Arrays.sort(v);
    long[] p2 = new long[n + 1];
    for (int i = 1; i <= n; i++)
      p2[i] = p2[i - 1] + v[i];
    line = in.readLine();
    int m = Integer.parseInt(line);
    while (m-- > 0) {
      line = in.readLine();
      part = line.split(" ");
      int type = Integer.parseInt(part[0]);
      int l = Integer.parseInt(part[1]);
      int r = Integer.parseInt(part[2]);
      if (type == 1)
        out.println(p1[r] - p1[l - 1]);
      else
        out.println(p2[r] - p2[l - 1]);
    }
    out.close();
    in.close();
  }

  static void shuffleArray(long[] array) {
    Random random = new Random();
    for (int i = array.length - 1; i > 0; i--) {
      int index = random.nextInt(i + 1);
      long temp = array[index];
      array[index] = array[i];
      array[i] = temp;
    }
  }
}
