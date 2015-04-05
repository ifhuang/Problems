package hihocoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MagicBox {

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] a = new int[3];
    String[] part = br.readLine().split(" ");
    for (int i = 0; i < 3; i++)
      a[i] = Integer.parseInt(part[i]);
    Arrays.sort(a);
    int count = 0;
    int[] b = new int[3];
    char[] c = br.readLine().toCharArray();
    for (int i = 0; i < c.length; i++) {
      b["RYB".indexOf(c[i])]++;
      count = Math.max(count, sum(b));
      if (check(a, b))
        Arrays.fill(b, 0);
    }
    System.out.println(count);
  }

  static boolean check(int[] a, int[] b) {
    int[] c = new int[a.length];
    c[0] = Math.abs(b[0] - b[1]);
    c[1] = Math.abs(b[0] - b[2]);
    c[2] = Math.abs(b[1] - b[2]);
    Arrays.sort(c);
    for (int i = 0; i < a.length; i++)
      if (a[i] != c[i])
        return false;
    return true;
  }

  static int sum(int[] b) {
    int sum = 0;
    for (int i = 0; i < b.length; i++)
      sum += b[i];
    return sum;
  }

}
