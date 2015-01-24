package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

// https://oj.leetcode.com/problems/path-sum-ii/
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		dfs(ans, list, root, sum);
		return ans;
	}
	private void dfs(List<List<Integer>> ans, List<Integer> list,
			TreeNode root, int sum) {
		if (root != null) {
			list.add(root.val);
			sum -= root.val;
			if (root.left == null && root.right == null && sum == 0)
				ans.add(list);
			if (root.left != null)
				dfs(ans, new ArrayList<>(list), root.left, sum);
			if (root.right != null)
				dfs(ans, new ArrayList<>(list), root.right, sum);
		}
	}
}