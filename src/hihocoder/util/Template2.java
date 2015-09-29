package hihocoder.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Template2 {
  public static void main(String args[]) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  }

  static String[] split(String s, String p) {
    return s.split(p);
  }

  static int parseInt(String s) {
    return Integer.parseInt(s);
  }

  static void out(String s) {
    System.out.println(s);
  }
}
