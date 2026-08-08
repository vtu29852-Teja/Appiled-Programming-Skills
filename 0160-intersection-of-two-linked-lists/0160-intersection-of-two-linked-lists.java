public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            // When p1 reaches the end, move it to headB
            p1 = (p1 == null) ? headB : p1.next;

            // When p2 reaches the end, move it to headA
            p2 = (p2 == null) ? headA : p2.next;
        }

        return p1;
    }
}