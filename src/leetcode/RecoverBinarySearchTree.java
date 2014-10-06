package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetcode.util.TreeNode;

public class RecoverBinarySearchTree
{
	public void recoverTree(TreeNode root)
	{
		if (root == null || root.left == null && root.right == null)
			return;
		List<Integer> list = new ArrayList<>();
		preOrderAdd(root, list);
		Collections.sort(list);
		preOrderSet(root, list);
	}

	private void preOrderAdd(TreeNode root, List<Integer> list)
	{
		if (root.left != null)
			preOrderAdd(root.left, list);
		list.add(root.val);
		if (root.right != null)
			preOrderAdd(root.right, list);
	}

	private void preOrderSet(TreeNode root, List<Integer> list)
	{
		if (root.left != null)
			preOrderSet(root.left, list);
		root.val = list.remove(0);
		if (root.right != null)
			preOrderSet(root.right, list);
	}

	public static void main(String[] args)
	{
		RecoverBinarySearchTree solution = new RecoverBinarySearchTree();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		solution.recoverTree(root);
	}
}