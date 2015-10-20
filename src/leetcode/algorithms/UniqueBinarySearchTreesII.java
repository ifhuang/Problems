package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBinarySearchTreesII {
  public List<TreeNode> generateTrees(int n) {
    List<TreeNode> ans = new ArrayList<>();
    if (n == 0) {
      ans.add(null);
      return ans;
    }
    List<TreeNode> pre = generateTrees(n - 1);
    for (TreeNode root : pre) {
      TreeNode node = new TreeNode(n);
      node.left = copy(root);
      ans.add(node);
      TreeNode p = root;
      int level = 0;
      while (p != null) {
        TreeNode copyRoot = copy(root);
        TreeNode copyP = copyRoot;
        int copyLevel = level;
        while (copyLevel-- > 0) {
          copyP = copyP.right;
        }
        TreeNode newNode = new TreeNode(n);
        newNode.left = copyP.right;
        copyP.right = newNode;
        ans.add(copyRoot);
        p = p.right;
        level++;
      }
    }
    return ans;
  }

  private TreeNode copy(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode node = new TreeNode(root.val);
    node.left = copy(root.left);
    node.right = copy(root.right);
    return node;
  }

  public List<TreeNode> generateTrees2(int n) {
    return generateTrees(1, n);
  }

  private List<TreeNode> generateTrees(int s, int e) {
    List<TreeNode> ans = new ArrayList<>();
    if (s > e) {
      ans.add(null);
      return ans;
    }
    for (int i = s; i <= e; i++) {
      List<TreeNode> left = generateTrees(s, i - 1);
      List<TreeNode> right = generateTrees(i + 1, e);
      for (TreeNode l : left) {
        for (TreeNode r : right) {
          TreeNode root = new TreeNode(i);
          root.left = l;
          root.right = r;
          ans.add(root);
        }
      }
    }
    return ans;
  }
}
