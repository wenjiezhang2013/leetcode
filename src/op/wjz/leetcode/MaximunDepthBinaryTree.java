package op.wjz.leetcode;

/**
 * https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * @author wenjiezhang
 *
 */

public class MaximunDepthBinaryTree
{

	public int maxDepth(TreeNode root) 
	{
		int depth = 0;
        if(root != null)
        {
        	int left = maxDepth(root.left);
        	int right = maxDepth(root.right);
        	
        	return left >= right ? left + 1 : right + 1;
        }
        
        return depth;
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


