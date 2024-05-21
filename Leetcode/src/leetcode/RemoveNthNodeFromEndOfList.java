package src.leetcode;

import src.leetcode.common.ListNode;

// Main point: find the order of that node fro start, int nthNodeFromStart = count - n;
//             ListNode preNode = head;
//             ListNode nextNode = head.next;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;
        while (temp!=null) {
            count ++;
            temp = temp.next;
        }
        // count = 5, n = 1, n_reversed = count - n - 1
        int nthNodeFromStart = count - n;   //
        if (nthNodeFromStart == 0){
            return head.next;
        }
        count = 1;  // First node is equivalent to count = 0,
                    // Second node is equivalent to count = 1,
        ListNode preNode = head;
        ListNode nextNode = head.next;
        while (nextNode!=null) {
            if (count == nthNodeFromStart) {
                preNode.next = nextNode.next;
                return head;
            }
            preNode = nextNode;
            nextNode=nextNode.next;
            count++;
        }
        return head;
    }
}
