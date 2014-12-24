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
		if(head == null || head.next == null)
			return head;
		
		
		if(head.val == head.next.val)
		{
			head.next = head.next.next;
		}
		
		return deleteDuplicates(head.next);
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
