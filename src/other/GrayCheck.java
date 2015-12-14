package other;

public class GrayCheck {
  public boolean grayCheck(byte term1, byte term2) {
    int len = 8;
    int count = 0;
    for (int i = 0; i < len; i++) {
      byte base = (byte) (1 << i);
      if ((term1 & base) != (term2 & base)) {
        count++;
      }
    }
    return count == 1;
  }

  public static void main(String[] args) {
    GrayCheck m = new GrayCheck();
    byte b1 = -128;
    byte b2 = 0;
    System.out.println(m.grayCheck(b1, b2));
  }
}
