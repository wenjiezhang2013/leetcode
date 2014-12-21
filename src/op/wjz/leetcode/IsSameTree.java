package op.wjz.leetcode;

/**
 * https://oj.leetcode.com/problems/same-tree/
 * @author wenjiezhang
 *
 */
public class IsSameTree
{

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == q)
            return true;
        else if(p == null || q == null)
            return false;
        else if(p.val == q.val)
        {
            if(isSameTree(q.left, p.left) && isSameTree(q.right, p.right))
                return true;
        }
        return false;
        
        
    }
  //Definition for binary tree
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

