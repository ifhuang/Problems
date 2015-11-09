package lintcode;

import java.util.ArrayList;

// http://www.lintcode.com/en/problem/product-of-array-exclude-itself/
public class ProductofArrayExcludeItself {
  /**
   * @param A: Given an integers array A
   * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
   */
  public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
    // write your code
    ArrayList<Long> list = new ArrayList<>();
    long i = 1;
    for (int a : A) {
      list.add(i);
      i *= a;
    }
    i = 1;
    for (int j = list.size() - 1; j >= 0; j--) {
      list.set(j, list.get(j) * i);
      i *= A.get(j);
    }
    return list;
  }
}
