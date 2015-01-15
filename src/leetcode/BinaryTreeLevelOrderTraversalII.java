package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			TreeNode flag = null;
			queue.offer(flag);
			while (true) {
				List<Integer> list = new ArrayList<>();
				if (queue.peek() == flag)
					break;
				while (queue.peek() != flag) {
					TreeNode p = queue.poll();
					if (p.left != null)
						queue.add(p.left);
					if (p.right != null)
						queue.add(p.right);
					list.add(p.val);
				}
				ans.add(list);
				queue.poll();
				queue.offer(flag);
			}
		}
		Collections.reverse(ans);
		return ans;
	}
}
