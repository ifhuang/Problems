package codeforces.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ProblemSet {

  public static void main(String[] args) throws Exception {
    int min = 1;
    int max = 23;
    for (int i = min; i <= max; i++) {
      Document doc = Jsoup.connect("http://codeforces.com/problemset/page/" + i).get();
      Element table = doc.getElementsByAttributeValue("class", "problems").first();
      System.out.println(table);
    }
  }
}
