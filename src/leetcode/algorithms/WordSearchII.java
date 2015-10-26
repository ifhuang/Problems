package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/word-search-ii/
public class WordSearchII {
  public List<String> findWords(char[][] board, String[] words) {
    Set<String> ans = new HashSet<>();
    int m = board.length;
    if (m == 0) {
      return new ArrayList<>(ans);
    }
    int n = board[0].length;
    boolean[][] visit = new boolean[m][n];
    ImplementTrie trie = new ImplementTrie();
    for (String word : words) {
      trie.insert(word);
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dfs(board, visit, m, n, i, j, "", trie, ans);
      }
    }
    return new ArrayList<>(ans);
  }

  private void dfs(char[][] board, boolean[][] visit, int m, int n, int x, int y, String s,
      ImplementTrie trie, Set<String> ans) {
    if (x < 0 || x >= m || y < 0 || y >= n || visit[x][y]) {
      return;
    }
    s += board[x][y];
    if (!trie.startsWith(s)) {
      return;
    }
    if (trie.search(s)) {
      ans.add(s);
    }
    visit[x][y] = true;
    int[][] d = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (int i = 0; i < d.length; i++) {
      dfs(board, visit, m, n, x + d[i][0], y + d[i][1], s, trie, ans);
    }
    visit[x][y] = false;
  }
}
