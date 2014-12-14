package op.wjz.leetcode;

/**
 * https://oj.leetcode.com/problems/linked-list-cycle/
 * 
 * @author wenjiezhang
 *
 */

public class LinkedListCycle
{

	public boolean hasCycle(ListNode head)
	{
		if (head == null)
			return false;
		ListNode fast = head;
		ListNode slow = head;
		while (true)
		{
			if (slow.next != null)
				slow = slow.next;
			else
				return false;

			if (fast.next != null && fast.next.next != null)
			{
				fast = fast.next.next;
			} else
				return false;

			if (slow == fast)
				return true;

		}

	}

	private class ListNode
	{

		public int val;
		public ListNode next;

		public ListNode(final int x)
		{
			val = x;
			next = null;
		}
	}

}
