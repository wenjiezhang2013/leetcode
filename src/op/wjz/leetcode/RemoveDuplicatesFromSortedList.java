package op.wjz.leetcode;

/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * @author wenjiezhang
 *
 */
public class RemoveDuplicatesFromSortedList
{

	public ListNode deleteDuplicates(ListNode head)
	{
		ListNode first = head;

		if (head == null || head.next == null)
			return head;

		while (head != null && head.next != null)
		{
			if (head.val == head.next.val)
			{
				head.next = head.next.next;
			} else
				head = head.next;
		}

		return first;
	}

	class ListNode
	{

		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
			next = null;
		}
	}
}
