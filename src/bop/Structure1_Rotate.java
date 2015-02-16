package bop;

public class Structure1_Rotate {
  public boolean rotateContain(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() < s2.length())
      return false;
    String s = s1 + s1;
    return s.contains(s2);
  }

  public static void main(String[] args) {
    Structure1_Rotate s = new Structure1_Rotate();
    System.out.println(s.rotateContain("ABCD", "ABCDA"));
  }
}
