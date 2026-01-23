// Problem Statement: Return the middle node of a linked list. If there are two middle nodes, return the second middle node.
// Logic: Use two pointers, a slow pointer that moves one step at a time and a fast pointer that moves two steps at a time. When the fast pointer reaches the end, the slow pointer will be at the middle.

public class middleOfLinkedList {
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }
    public static ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next; // move slow by 1
            fast = fast.next.next; // move fast by 2
        }
        return slow; // slow is now at the middle
    }
    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode middle = middleNode(head);
        System.out.println("The middle node value is: " + middle.val); // Output: 3
    }
}

// Complexity Analysis:
// Time Complexity: O(N), where N is the number of nodes in the linked list, as we traverse the list once.
// Space Complexity: O(1), as we are using only a constant amount of extra space.
