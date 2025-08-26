/*
234. Palindrome Linked List

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
Example 1:
Input: head = [1,2,2,1]
Output: true
Example 2:
Input: head = [1,2]
Output: false
 Constraints:
The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 Follow up: Could you do it in O(n) time and O(1) space?
*/

import java.util.*;

// class ListNode {
//     int val;
//     ListNode next;

//     public ListNode () {}

//     public ListNode (int val) {
//         this.val = val;
//         this.next = null;
//     }

//     public ListNode (int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverseLinkedList(slow);

        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean isPalindrome = true;
        while(p2 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return isPalindrome;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}