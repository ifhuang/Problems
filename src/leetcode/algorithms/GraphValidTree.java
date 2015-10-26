package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/graph-valid-tree/
// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of
// nodes), write a function to check whether these edges make up a valid tree.
// For example:
// Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
// Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
// Hint:
// Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid
// tree?
// According to the definition of tree on Wikipedia: ¡°a tree is an undirected graph in which any two
// vertices are connected by exactly one path. In other words, any connected graph without simple
// cycles is a tree.¡±
// Note: you can assume that no duplicate edges will appear in edges. Since all edges are
// undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
public class GraphValidTree {
  public boolean validTree(int n, int[][] edges) {
    int[] nums = new int[n];
    Arrays.fill(nums, -1);
    for (int i = 0; i < edges.length; i++) {
      int x = find(nums, edges[i][0]);
      int y = find(nums, edges[i][1]);
      if (x == y) {
        return false;
      }
      nums[x] = y;
    }
    return edges.length == n - 1;
  }

  private int find(int nums[], int i) {
    return nums[i] == -1 ? i : find(nums, nums[i]);
  }

  public boolean validTree2(int n, int[][] edges) {
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }
    for (int i = 0; i < edges.length; i++) {
      int u = edges[i][0], v = edges[i][1];
      adjList.get(u).add(v);
      adjList.get(v).add(u);
    }
    boolean[] visited = new boolean[n];
    if (hasCycle(adjList, 0, visited, -1)) {
      return false;
    }
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        return false;
      }
    }
    return true;
  }

  boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
    visited[u] = true;
    for (int i = 0; i < adjList.get(u).size(); i++) {
      int v = adjList.get(u).get(i);
      if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList, v, visited, u))) {
        return true;
      }
    }
    return false;
  }
}
