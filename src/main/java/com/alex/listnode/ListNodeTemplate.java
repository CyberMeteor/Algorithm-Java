package com.alex.listnode;

public class ListNodeTemplate {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Delete duplicates
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null) {
            while (p.next != null && p.val == p.next.val) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return head;
    }

    // Reverse
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Merge two lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);

        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }

            if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }
        curr.next = (l1 == null) ? l2 : l1;
        return head.next;
    }


    // Fast and slow pointers
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
