package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DrazilandFactorial {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    in.readLine();
    String a = in.readLine();
    int i = 0;
    int[] num = new int[10];
    while (i < a.length()) {
      num[Integer.parseInt(a.substring(i, i + 1))]++;
      i++;
    }
    while (num[9] > 0) {
      num[3] += 2;
      num[2]++;
      num[7]++;
      num[9]--;
    }
    while (num[8] > 0) {
      num[2] += 3;
      num[7]++;
      num[8]--;
    }
    while (num[6] > 0) {
      num[3]++;
      num[5]++;
      num[6]--;
    }
    while (num[4] > 0) {
      num[2] += 2;
      num[3]++;
      num[4]--;
    }
    for (i = 7; i > 1; i--)
      while (num[i] > 0) {
        out.print(i);
        num[i]--;
      }
    out.println();
    out.close();
    in.close();
  }
}
