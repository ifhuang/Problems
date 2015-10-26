package leetcode.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule/
public class CourseSchedule {
  // bfs
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> in = gen(numCourses);
    List<List<Integer>> out = gen(numCourses);
    for (int i = 0; i < prerequisites.length; i++) {
      in.get(prerequisites[i][0]).add(prerequisites[i][1]);
      out.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }
    List<Integer> order = new LinkedList<>();
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (in.get(i).isEmpty()) {
        queue.offer(i);
      }
    }
    while (!queue.isEmpty()) {
      int i = queue.poll();
      order.add(i);
      for (int j : out.get(i)) {
        in.get(j).remove((Integer) i);
        if (in.get(j).isEmpty()) {
          queue.offer(j);
        }
      }
    }
    return order.size() == numCourses;
  }

  private List<List<Integer>> gen(int n) {
    List<List<Integer>> list = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      list.add(new LinkedList<>());
    }
    return list;
  }

  // dfs
  public boolean canFinish2(int numCourses, int[][] prerequisites) {
    List<List<Integer>> out = gen2(numCourses);
    for (int i = 0; i < prerequisites.length; i++) {
      out.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }
    int[] mark = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      if (mark[i] == 0 && !dfs(out, mark, i)) {
        return false;
      }
    }
    return true;
  }

  private boolean dfs(List<List<Integer>> out, int[] mark, int i) {
    mark[i] = 1;
    for (int j : out.get(i)) {
      if (mark[j] == 1 || (mark[j] == 0 && !dfs(out, mark, j))) {
        return false;
      }
    }
    mark[i] = 2;
    return true;
  }

  private List<List<Integer>> gen2(int n) {
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new ArrayList<>());
    }
    return list;
  }
}
