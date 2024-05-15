package src.leetcode;

import src.leetcode.common.ListNode;

//	Main point: 

//	int remainder = 0;
//	while (l1!=null & l2!=null) {
//		int temp = l1.val + l2.val + remainder;
//		if (temp >= 10) {
//			temp %= 10;
//			remainder = 1;
//		} else {
//			remainder = 0;
//		}
//		head.next = new ListNode(temp);
//		head = head.next;
//		l1 = l1.next;
//		l2 = l2.next;
//	}

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(); // Temp
		ListNode preHead = head;
		int remainder = 0;
		while (l1!=null & l2!=null) {
			int temp = l1.val + l2.val + remainder;
			if (temp >= 10) {
				temp %= 10;
				remainder = 1;
			} else {
				remainder = 0;
			}
			head.next = new ListNode(temp);
			head = head.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while(l1!=null) {
			int temp = l1.val + remainder;
			if (temp >= 10) {
				temp %= 10;
				remainder = 1;
			} else {
				remainder = 0;
			}
			head.next = new ListNode(temp);
			head = head.next;
			l1= l1.next;
		}
		while(l2!=null) {
			int temp = l2.val + remainder;
			if (temp >= 10) {
				temp %= 10;
				remainder = 1;
			} else {
				remainder = 0;
			}
			head.next = new ListNode(temp);
			head = head.next;
			l2= l2.next;
		}
		if (remainder == 1) {
			head.next = new ListNode(1);
		}
		return preHead.next;
	}
}
