package leetcode;

// https://oj.leetcode.com/problems/gas-station/
public class GasStation {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int start = 0;
    int now = 0;
    int gasSum = 0;
    int costSum = 0;
    int n = gas.length;
    for (int i = 0; i < n; i++) {
      gasSum += gas[i];
      costSum += cost[i];
      now += gas[i] - cost[i];
      if (now < 0) {
        start = i + 1;
        now = 0;
      }
    }
    return gasSum < costSum ? -1 : start;
  }
}
