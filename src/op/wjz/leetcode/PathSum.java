package op.wjz.leetcode;

/**
 * https://oj.leetcode.com/problems/path-sum/
 * 
 * @author wenjiezhang
 *
 */
public class PathSum
{

	public boolean hasPathSum(TreeNode root, int sum)
	{
		if (root != null)
		{
			if ((sum - root.val) == 0)
			{
				if (root.left == null && root.right == null)
					return true;
				else
					return hasPathSum(root.left, sum - root.val)
					        || hasPathSum(root.right, sum - root.val);
			} else
				return hasPathSum(root.left, sum - root.val)
				        || hasPathSum(root.right, sum - root.val);
		} else
		{
			return false;
		}
	}
	
	// Definition for binary tree
	class TreeNode
	{

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}
}
