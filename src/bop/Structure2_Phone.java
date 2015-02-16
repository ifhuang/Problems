package bop;

import java.util.ArrayList;
import java.util.List;

public class Structure2_Phone {
  private static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> transform(String number) {
    List<String> list = new ArrayList<>();
    if (number == null || number.length() == 0)
      list.add("");
    else {
      String letters = map[Integer.parseInt(number.substring(0, 1))];
      List<String> postList = transform(number.substring(1));
      if (letters.length() == 0)
        return postList;
      for (String string : postList)
        for (int i = 0; i < letters.length(); i++) {
          String s = letters.charAt(i) + string;
          list.add(s);
        }
    }
    return list;
  }

  public static void main(String[] args) {
    Structure2_Phone s = new Structure2_Phone();
    System.out.println(s.transform("26678837"));
  }
}
