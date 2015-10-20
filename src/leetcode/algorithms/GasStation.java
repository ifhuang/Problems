package leetcode.algorithms;

// https://oj.leetcode.com/problems/gas-station/
public class GasStation {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int gasSum = 0;
    int costSum = 0;
    int cur = 0;
    int j = 0;
    for (int i = 0; i < gas.length; i++) {
      gasSum += gas[i];
      costSum += cost[i];
      cur += gas[i] - cost[i];
      if (cur < 0) {
        cur = 0;
        j = i + 1;
      }
    }
    return gasSum >= costSum ? j : -1;
  }
}
