package op.wjz.leetcode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
import java.util.Objects;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode head = null;
		ListNode current = null;

		while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
			if (Objects.nonNull(l1) && Objects.nonNull(l2)) {
				if (l1.val >= l2.val) {
					if (Objects.nonNull(current)) {
						current.next = new ListNode(l2.val);
						current = current.next;
					} else {
						current = new ListNode(l2.val);
						head = Objects.isNull(head) ? current : head;
					}
					l2 = l2.next;
				} else {
					if (Objects.nonNull(current)) {
						current.next = new ListNode(l1.val);
						current = current.next;
					} else {
						current = new ListNode(l1.val);
						head = Objects.isNull(head) ? current : head;
					}
					l1 = l1.next;
				}
			} else if (Objects.isNull(l1)) {
				if (Objects.nonNull(current)) {
					current.next = l2;
				} else {
					current = l2;
					head = Objects.isNull(head) ? current : head;
				}
				l1 = null;
				l2 = null;

			} else {
				if (Objects.nonNull(current)) {
					current.next = l1;
				} else {
					current = l1;
					head = Objects.isNull(head) ? current : head;
				}
				l1 = null;
				l2 = null;
			}

		}
		return head;

	}
}