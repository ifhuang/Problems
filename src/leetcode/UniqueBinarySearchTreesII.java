package leetcode;

import java.util.LinkedList;
import java.util.List;

import leetcode.util.TreeNode;

public class UniqueBinarySearchTreesII
{
	public List<TreeNode> generateTrees(int n)
	{
		List<TreeNode> result = new LinkedList<>();
		if (n < 1)
		{
			result.add(null);
			return result;
		}
		else if (n == 1)
		{
			TreeNode root = new TreeNode(1);
			result.add(root);
			return result;
		}
		else
		{
			List<TreeNode> pre = generateTrees(n - 1);
			for (TreeNode treeNode : pre)
			{
				TreeNode root = new TreeNode(n);
				root.left = treeNode;
				result.add(root);
			}
			for (TreeNode treeNode : pre)
			{
				result.addAll(insert(treeNode, n));
			}
			return result;
		}
	}

	private List<TreeNode> insert(TreeNode root, int n)
	{
		List<TreeNode> list = new LinkedList<>();
		TreeNode p = root;
		int count = 0;
		while (p != null)
		{
			TreeNode newRoot = copy(root);
			TreeNode newP = newRoot;
			int countP = count;
			while (countP > 0)
			{
				newP = newP.right;
				countP--;
			}
			TreeNode newN = new TreeNode(n);
			newN.left = newP.right;
			newP.right = newN;
			list.add(newRoot);
			p = p.right;
			count++;
		}
		return list;
	}

	private TreeNode copy(TreeNode root)
	{
		if (root == null)
			return null;
		TreeNode newRoot = new TreeNode(root.val);
		newRoot.left = copy(root.left);
		newRoot.right = copy(root.right);
		return newRoot;
	}

	public static void main(String[] args)
	{
		UniqueBinarySearchTreesII solution = new UniqueBinarySearchTreesII();
		List<TreeNode> list = solution.generateTrees(3);
		System.out.println(list);
	}
}