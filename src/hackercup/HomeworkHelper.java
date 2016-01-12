package hackercup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class HomeworkHelper {

  static int[] prime;

  static void loadPrime(String path) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader(path));
    String[] part = br.readLine().split(",");
    br.close();
    prime = new int[part.length];
    for (int i = 0; i < part.length; i++) {
      prime[i] = Integer.parseInt(part[i]);
    }
  }

  static void help(String path) throws Exception {
    FileWriter fw = new FileWriter(path);
    fw.write(1 + "");
    for (int i = 3; i <= 10000000; i++) {
      if (i % 1000000 == 0)
        System.out.println(i);
      int p = 0;
      int copy = i;
      for (int j = 0; j < prime.length; j++) {
        if (prime[j] > copy)
          break;
        if (copy % prime[j] == 0) {
          p++;
          copy /= prime[j];
        }
      }
      fw.write("," + p);
    }
    fw.flush();
    fw.close();
  }

  public static void main(String[] args) throws Exception {
    loadPrime("Prime.txt");
    help("Help.txt");
  }

}
