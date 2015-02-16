package other;

import leetcode.util.TreeNode;

public class LowestCommonAncestor {
  public TreeNode getLCA(TreeNode root, TreeNode node1, TreeNode node2) {
    if (root == null)
      return null;
    if (root == node1 || root == node2)
      return root;
    TreeNode left = getLCA(root.left, node1, node2);
    TreeNode right = getLCA(root.right, node1, node2);
    if (left != null && right != null)
      return root;
    return left != null ? left : right;
  }

  public static void main(String[] args) {
    LowestCommonAncestor lca = new LowestCommonAncestor();
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    System.out.println(lca.getLCA(root, root.left, root.left.left).val);
  }
}
