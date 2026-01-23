// Problem Statement: Check if a linked list has a cycle.
// Logic: Use two pointers, a slow pointer that moves one step at a time and a fast pointer that moves two steps at a time. If there is a cycle, the fast pointer will eventually meet the slow pointer.

public class linkedListCycleDetection {
    
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }
    public static boolean hasCycle(ListNode head){
        if(head == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next; // move slow by 1
            fast = fast.next.next; // move fast by 2

            if(slow==fast){
                return true; // cycle detected
            }
        }
        return false; // no cycle
    }
    public static void main(String[] args) {
        // Creating a sample linked list with a cycle:
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        // Creating a cycle here
        head.next.next.next.next.next = head.next; // 6 points to 2

        boolean result = hasCycle(head);
        System.out.println("Does the linked list have a cycle? " + result); // Output: true
    }
}

// Complexity Analysis:
// Time Complexity: O(N), where N is the number of nodes in the linked list, as we may need to traverse the entire list.
// Space Complexity: O(1), as we are using only a constant amount of extra space.

