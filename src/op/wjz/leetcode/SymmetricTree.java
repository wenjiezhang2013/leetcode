package op.wjz.leetcode;
/**
 * https://leetcode.com/problems/symmetric-tree/
 * @author wenjiezhang
 *
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return compare(root.left, root.right);
        
    }
    
    private boolean compare(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;
        else if(left == null || right == null)
            return false;
        else if(left.val == right.val){
            return compare(left.left, right.right) && compare(left.right, right.left);
        }
        
        return false;
    }
}
