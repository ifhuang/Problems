package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBinarySearchTreesII {
  public List<TreeNode> generateTrees(int n) {
    List<TreeNode> ans = new ArrayList<>();
    if (n == 0)
      ans.add(null);
    else {
      List<TreeNode> pre = generateTrees(n - 1);
      for (TreeNode root : pre) {
        TreeNode newRoot = new TreeNode(n);
        newRoot.left = root;
        ans.add(newRoot);
        TreeNode p = root;
        int level = 0;
        while (p != null) {
          TreeNode copyRoot = copy(root);
          TreeNode copyP = copyRoot;
          int copyLevel = level;
          while (copyLevel-- != 0)
            copyP = copyP.right;
          TreeNode node = new TreeNode(n);
          node.left = copyP.right;
          copyP.right = node;
          ans.add(copyRoot);
          p = p.right;
          level++;
        }
      }
    }
    return ans;
  }

  private TreeNode copy(TreeNode root) {
    if (root == null)
      return null;
    TreeNode newRoot = new TreeNode(root.val);
    newRoot.left = copy(root.left);
    newRoot.right = copy(root.right);
    return newRoot;
  }
}
