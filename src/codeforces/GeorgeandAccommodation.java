package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GeorgeandAccommodation {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    int n = Integer.parseInt(in.readLine());
    int count = 0;
    while (n-- > 0) {
      String line = in.readLine();
      String[] part = line.split(" ");
      if (Integer.parseInt(part[1]) - Integer.parseInt(part[0]) > 1)
        count++;
    }
    out.println(count);
    out.close();
    in.close();
  }
}
