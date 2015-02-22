package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Registrationsystem {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    int n = Integer.parseInt(in.readLine());
    Map<String, Integer> map = new HashMap<>();
    while (n-- > 0) {
      String line = in.readLine();
      if (!map.containsKey(line)) {
        out.println("OK");
        map.put(line, 1);
      } else {
        int suffix = map.get(line);
        out.println(line + suffix);
        map.put(line, suffix + 1);
      }
    }
    out.close();
    in.close();
  }
}
