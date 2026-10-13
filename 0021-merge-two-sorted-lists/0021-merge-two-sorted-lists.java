class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) { 
        this.val = val; 
    }

    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }

    public static void main(String[] args) {
        // Example list 1: 1 -> 2 -> 4
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        // Example list 2: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        Solution sol = new Solution();
        ListNode merged = sol.mergeTwoLists(l1, l2);

        // Print merged list
        while (merged != null) {
            System.out.print(merged.val + (merged.next != null ? " -> " : ""));
            merged = merged.next;
        }
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }
}
