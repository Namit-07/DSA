// Problem Statement: Reverse a singly linked list.
// Logic: Iterate through the linked list, reversing the pointers one by one until the end of the list is reached.

public class reverseALinkedList {

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }
    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode next = curr.next; // store next node
            curr.next = prev; // reverse the link
            prev = curr; // move prev to current
            curr = next; // move curr to next
        }
        return prev;
    }
    // Helper method to print the linked list
    public static void printList(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        ListNode reversedHead = reverseList(head);

        System.out.println("Reversed Linked List:");
        printList(reversedHead);
    }
}

// Complexity Analysis:
// Time Complexity: O(N), where N is the number of nodes in the linked list, as we traverse the list once.
// Space Complexity: O(1), as we are using only a constant amount of extra space.
