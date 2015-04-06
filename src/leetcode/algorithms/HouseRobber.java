package leetcode.algorithms;

public class HouseRobber {

  public int rob(int[] num) {
    if (num.length == 0)
      return 0;
    int grandpa = 0;
    int father = num[0];
    if (num.length == 1)
      return father;
    int child = 0;
    for (int i = 2; i <= num.length; i++) {
      child = Math.max(father, num[i - 1] + grandpa);
      grandpa = father;
      father = child;
    }
    return child;
  }

}
