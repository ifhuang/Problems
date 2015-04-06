package leetcode.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;

public class BinaryTreeRightSideView {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null)
      return ans;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    queue.offer(null);
    while (true) {
      TreeNode p = queue.poll();
      if (p.left != null)
        queue.offer(p.left);
      if (p.right != null)
        queue.offer(p.right);
      if (queue.peek() == null) {
        ans.add(p.val);
        queue.poll();
        if (queue.isEmpty())
          break;
        queue.offer(null);
      }
    }
    return ans;
  }

}
