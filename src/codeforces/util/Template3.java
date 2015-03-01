package codeforces.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Template3 {
  public static void main(String[] args) throws IOException {
    FastReader in = new FastReader();
    PrintWriter out = new PrintWriter(System.out);

    out.close();
  }
}


class FastReader {
  BufferedReader br;
  StringTokenizer in;

  FastReader() {
    this.br = new BufferedReader(new InputStreamReader(System.in));
  }

  FastReader(String filename) {
    try {
      this.br = new BufferedReader(new FileReader(filename));
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  public String nextToken() throws IOException {
    while (in == null || !in.hasMoreTokens()) {
      in = new StringTokenizer(br.readLine());
    }
    return in.nextToken();
  }

  public int nextInt() throws IOException {
    return Integer.parseInt(nextToken());
  }

  public double nextDouble() throws IOException {
    return Double.parseDouble(nextToken());
  }

  public long nextLong() throws IOException {
    return Long.parseLong(nextToken());
  }
}
