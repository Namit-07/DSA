// Problem Statement: Remove the N-th node from the end of a singly linked list.
// Logic: Use two pointers to find the N-th node from the end and remove it by adjusting the pointers.

public class removeNodeFromEnd {
    
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n steps ahead
        for(int i=0; i<=n; i++){
            fast = fast.next;
        }

        // Move both until fast reaches last node
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }

        // Delete the nth node from end
        slow.next = slow.next.next;
        return dummy.next;
    }
    // Helper print
    public static void printList(ListNode head){
        ListNode current = head;
        while(current!=null){
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        int n = 2;
        head = removeNthFromEnd(head, n);

        System.out.println("List after removing " + n + "-th node from end:");
        printList(head);
    }
}

// Complexity Analysis:
// Time Complexity: O(L), where L is the length of the linked list. We traverse the list twice.
// Space Complexity: O(1), as we are using only a constant amount of extra space.