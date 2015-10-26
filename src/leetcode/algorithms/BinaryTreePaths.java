package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

// https://leetcode.com/problems/binary-tree-paths/
public class BinaryTreePaths {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> ans = new ArrayList<>();
    if (root == null) {

    } else if (root.left == null && root.right == null) {
      ans.add(root.val + "");
    } else {
      List<String> left = binaryTreePaths(root.left);
      for (String l : left) {
        ans.add(root.val + "->" + l);
      }
      List<String> right = binaryTreePaths(root.right);
      for (String r : right) {
        ans.add(root.val + "->" + r);
      }
    }
    return ans;
  }
}
