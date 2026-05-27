/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while(curr != null) {
            int num = curr.val;
            if(curr.next != null) {
                int num2 = curr.next.val;
                int gcd = gcdOfTwoNumbers(num, num2);
                ListNode temp = curr.next;
                ListNode gcdNode = new ListNode(gcd);
                gcdNode.next = temp;
                curr.next = gcdNode;
                curr = curr.next.next;
            } else {
                break;
            }
        }
        return head;
    }

    public int gcdOfTwoNumbers(int a, int b) {
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}