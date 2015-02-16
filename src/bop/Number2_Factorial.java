package bop;

public class Number2_Factorial {
  public int countZero(int n) {
    int count = 0;
    while (n != 0) {
      count += n / 5;
      n /= 5;
    }
    return count;
  }

  public int firstOne(int n) {
    int count = 0;
    while (n != 0) {
      count += n / 2;
      n /= 2;
    }
    return count + 1;
  }

  private int f(int n) {
    int ans = 1;
    for (int i = 2; i <= n; i++)
      ans *= i;
    return ans;
  }

  public static void main(String[] args) {
    Number2_Factorial n2 = new Number2_Factorial();
    int num = 10;
    System.out.println(n2.countZero(num));
    System.out.println(Integer.toBinaryString(n2.f(num)));
    System.out.println(n2.firstOne(num));
  }
}
