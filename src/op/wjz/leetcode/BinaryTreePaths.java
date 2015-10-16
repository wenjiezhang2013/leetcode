package op.wjz.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BinaryTreePaths {

	Set<TreeNode> visited = new HashSet<TreeNode>();
	Stack<TreeNode> queue = new Stack<TreeNode>();
	List<String> list = new ArrayList<String>();
	boolean first = true;

	public List<String> binaryTreePaths(TreeNode root) {
		while (!queue.isEmpty() || first) {
		    first = false;
			if (root == null) {
				continue;
			} else if (visited.contains(root)) {
				if (root.right != null && !visited.contains(root.right)) {
					binaryTreePaths(root.right);
				}
				else{
				    queue.pop();
				    if(!queue.isEmpty())
				    	binaryTreePaths(queue.peek());
				}
			} else {
				queue.add(root);
				visited.add(root);
				if (root.left == null && root.right == null) {
					list.add(queueToString(queue));
					queue.pop();
				    if(!queue.isEmpty())
					 binaryTreePaths(queue.peek());
				} else if (root.left != null) {
					binaryTreePaths(root.left);
				}
			}
		}

		return list;
	}

	private String queueToString(Stack<TreeNode> queue) {
		boolean first = true;
		String result = "";
		for (TreeNode treeNode : queue) {
			if (first) {
				first = false;
			} else {
				result += "->";
			}
			result += treeNode.val;
		}

		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
		
		BinaryTreePaths test = new BinaryTreePaths();
		
		List<String> result = test.binaryTreePaths(root);
		
		for (String string : result) {
			System.out.println(string);
		}
		
	}

}
