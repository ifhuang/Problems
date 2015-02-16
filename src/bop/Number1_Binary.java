package bop;

public class Number1_Binary {
  public int countOne(int input) {
    int mask = 1;
    int count = 0;
    for (int i = 0; i < Integer.SIZE; i++) {
      if ((input & mask) == mask)
        count++;
      mask <<= 1;
    }
    return count;
  }

  public static void main(String[] args) {
    Number1_Binary n1 = new Number1_Binary();
    int num = Integer.MIN_VALUE;
    System.out.println(Integer.toBinaryString(num));
    System.out.println(n1.countOne(num));
  }

}
