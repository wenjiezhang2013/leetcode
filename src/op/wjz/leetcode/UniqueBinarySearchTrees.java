package op.wjz.leetcode;

/**
 * https://oj.leetcode.com/problems/unique-binary-search-trees/
 * @author wenjiezhang
 *
 */
public class UniqueBinarySearchTrees
{
	public int numTrees(int n) {
        return (int) Math.pow(2, n) - 1;
    }
}
