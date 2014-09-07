package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class FlattenBinaryTreetoLinkedList
{
	public void flatten(TreeNode root)
	{
		List<TreeNode> list = new ArrayList<>();
		preOrder(root, list);
		TreeNode tmp = new TreeNode(0);
		TreeNode pre = tmp;
		for (TreeNode i : list)
		{
			pre.right = i;
			pre.left = null;
			pre = pre.right;
		}
	}

	private void preOrder(TreeNode root, List<TreeNode> list)
	{
		if (root == null)
			return;
		list.add(root);
		if (root.left != null)
			preOrder(root.left, list);
		if (root.right != null)
			preOrder(root.right, list);
	}

	public static void main(String[] args)
	{
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		FlattenBinaryTreetoLinkedList solution = new FlattenBinaryTreetoLinkedList();
		solution.flatten(t1);
		System.out.println();
	}
}
