// Problem Statement: Reverse a linked list only from position left to right.
// Logic: Go to node just before left, then iteratively reverse the sublist from left to right by adjusting pointers.

public class reverseLinkedList {
    
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right){
        if(head==null || left==right){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move prev to one node before left
        ListNode prev = dummy;
        for(int i=1; i<left; i++){
            prev = prev.next;
        }

        // Reverse the sublist
        ListNode curr = prev.next;
        for(int i=0; i<right-left; i++){
            ListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }
        return dummy.next;
    }
    // Helper print
    public static void printList(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
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

        int left = 2, right = 4;
        head = reverseBetween(head, left, right);

        System.out.println("List after reversing from position " + left + " to " + right + ":");
        printList(head);
    }
}

// Complexity Analysis:
// Time Complexity: O(N) where N is the number of nodes in the linked list, as we may need to traverse the entire list.
// Space Complexity: O(1) since we are reversing the list in place without using any extra space.