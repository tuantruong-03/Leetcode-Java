package src.leetcode;




public class RemoveDuplicatesFromSortedList {
	private class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	 public ListNode deleteDuplicates(ListNode head) {
		 if (head == null) {
			 return null;
		 }
		 ListNode result = head;
		 ListNode prev = head;
		 head = head.next;
		 while(head != null) {
			 if (head.val == prev.val) {
				 prev.next = head.next;
				 head = head.next;
				 continue;
			 }
			 prev = head;
			 head = head.next;
		 }
		 return result;
	 }
}
