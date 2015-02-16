package bop;

import java.util.Arrays;

public class Game3_Pancake {
  private int[] pancakes;
  private int[] result;
  private int swapMax;
  private int[] swapResult;
  private int searchNum;

  public Game3_Pancake(int[] pancakes) {
    this.pancakes = Arrays.copyOf(pancakes, pancakes.length);
    swapMax = 2 * pancakes.length;
    result = new int[swapMax];
    swapResult = new int[swapMax];
    searchNum = 0;
  }

  public void dfs(int count) {
    searchNum++;
    int estimateNum = lowBound();
    if (count + estimateNum >= swapMax)
      return;
    if (isSorted()) {
      if (count < swapMax) {
        swapMax = count;
        for (int i = 0; i < swapMax; i++)
          result[i] = swapResult[i];
      }
      return;
    }
    for (int i = 1; i < pancakes.length; i++) {
      reverse(0, i);
      swapResult[count] = i;
      dfs(count + 1);
      reverse(0, i);
    }
  }

  public void output() {
    System.out.print("result:");
    for (int i = 0; i < swapMax; i++)
      System.out.print(" " + result[i]);
    System.out.println();
    System.out.println("searchNum: " + searchNum);
    System.out.println("swapMax: " + swapMax);
  }

  private void reverse(int start, int end) {
    for (int i = start, j = end; i < j; i++, j--) {
      int tmp = pancakes[i];
      pancakes[i] = pancakes[j];
      pancakes[j] = tmp;
    }
  }

  private boolean isSorted() {
    for (int i = 1; i < pancakes.length; i++)
      if (pancakes[i - 1] > pancakes[i])
        return false;
    return true;
  }

  private int lowBound() {
    int count = 0;
    for (int i = 1; i < pancakes.length; i++) {
      int t = pancakes[i] - pancakes[i - 1];
      if (t == 1 || t == -1)
        ;
      else
        count++;
    }
    return count;
  }

  public static void main(String[] args) {
    int[] pancakes = new int[] {3, 2, 1, 6, 5, 4, 9, 8, 7, 0};
    Game3_Pancake game3 = new Game3_Pancake(pancakes);
    game3.dfs(0);
    game3.output();
  }
}
