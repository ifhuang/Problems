package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
  public List<String> findWords(char[][] board, String[] words) {
    int n = board.length;
    int m = board[0].length;
    boolean[][] visit = new boolean[n][m];
    ImplementTrie trie = new ImplementTrie();
    for (String word : words)
      trie.insert(word);
    Set<String> ans = new HashSet<>();
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        dfs(board, visit, i, j, "", trie, ans);
    return new ArrayList<>(ans);
  }

  private void dfs(char[][] board, boolean[][] visit, int x, int y, String s, ImplementTrie trie,
      Set<String> ans) {
    int n = board.length;
    int m = board[0].length;
    if (x < 0 || x >= n || y < 0 || y >= m || visit[x][y])
      return;
    s += board[x][y];
    if (!trie.startsWith(s))
      return;
    if (trie.search(s))
      ans.add(s);
    visit[x][y] = true;
    dfs(board, visit, x + 1, y, s, trie, ans);
    dfs(board, visit, x - 1, y, s, trie, ans);
    dfs(board, visit, x, y + 1, s, trie, ans);
    dfs(board, visit, x, y - 1, s, trie, ans);
    visit[x][y] = false;
  }
}
