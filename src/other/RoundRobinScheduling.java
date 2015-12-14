package other;

import java.util.LinkedList;
import java.util.Queue;

public class RoundRobinScheduling {

  public double solve(int[] arriveTime, int[] executeTime, int q) {
    int currentTime = 0;
    int waitTime = 0;
    Queue<Process> queue = new LinkedList<>();
    int index = 0;
    int length = arriveTime.length;
    while (!queue.isEmpty() || index < length) {
      if (!queue.isEmpty()) {
        Process currentProcess = queue.poll();
        waitTime += currentTime - currentProcess.arriveTime;
        currentTime += Math.min(currentProcess.executeTime, q);
        for (; index < length && arriveTime[index] <= currentTime; index++) {
          queue.offer(new Process(arriveTime[index], executeTime[index]));
        }
        if (currentProcess.executeTime > q) {
          queue.offer(new Process(currentTime, currentProcess.executeTime - q));
        }
      } else {
        queue.offer(new Process(arriveTime[index], executeTime[index]));
        currentTime = arriveTime[index];
        index++;
      }
    }
    return (double) waitTime / length;
  }

}


class Process {
  int arriveTime;
  int executeTime;

  Process(int arriveTime, int executeTime) {
    this.arriveTime = arriveTime;
    this.executeTime = executeTime;
  }
}
