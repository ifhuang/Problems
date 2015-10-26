package leetcode.algorithms;

import leetcode.util.TreeNode;

// https://leetcode.com/problems/binary-tree-upside-down/
// Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node
// that shares the same parent node) or empty, flip it upside down and turn it into a tree where the
// original right nodes turned into left leaf nodes. Return the new root.
// For example:
// Given a binary tree {1,2,3,4,5},
// return the root of the binary tree [4,5,2,#,#,3,1].
public class BinaryTreeUpsideDown {
  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return root;
    }
    TreeNode pre = root;
    TreeNode cur = root.left;
    while (cur.left != null) {
      pre = pre.left;
      cur = cur.left;
    }
    cur.left = pre.right;
    pre.left = null;
    pre.right = null;
    cur.right = upsideDownBinaryTree(root);
    return cur;
  }

  public TreeNode upsideDownBinaryTree2(TreeNode root) {
    TreeNode cur = root;
    TreeNode pre = null;
    TreeNode next = null;
    TreeNode preR = null;
    while (cur != null) {
      next = cur.left;
      cur.left = preR;
      preR = cur.right;
      cur.right = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }
}
