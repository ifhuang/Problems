package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GivenLengthandSumofDigits {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = in.readLine();
    String[] part = line.split(" ");
    int m = Integer.parseInt(part[0]);
    int s = Integer.parseInt(part[1]);
    if (m > 1 && s == 0 || s > 9 * m)
      out.println("-1 -1");
    else if (m == 1 && s == 0)
      out.println("0 0");
    else
      out.println(getMin(m, s) + " " + getMax(m, s));
    out.close();
    in.close();
  }


  static String getMax(int m, int s) {
    StringBuilder max = new StringBuilder();
    while (m > 0) {
      max.append(Math.min(9, s));
      s -= Math.min(9, s);
      m--;
    }
    return max.toString();
  }

  static String getMin(int m, int s) {
    String max = getMax(m, s - 1);
    StringBuilder min = new StringBuilder(max);
    min.reverse();
    if (min.charAt(0) == '9') {
      min.setCharAt(0, '0');
      min.insert(0, '1');
    } else
      min.setCharAt(0, (char) (min.charAt(0) + 1));
    return min.toString();
  }
}
