// Problem Statement: Given k sorted linked lists, merge them into one sorted linked list.
// Logic: Put the first node of each list into a min-heap (priority queue). Repeatedly extract the smallest node and add it to the merged list, then add the next node from the same list to the heap.

import java.util.*;

public class mergeKSortedLists {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists){
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add first node of each list to the heap
        for(ListNode node : lists){
            if(node!=null){
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Process the heap
        while(!minHeap.isEmpty()){
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            if(smallest.next!=null){
                minHeap.add(smallest.next);
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        // Example usage:
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        ListNode mergedHead = mergeKLists(lists);

        // Print merged list
        ListNode current = mergedHead;
        while(current != null){
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// Complexity Analysis:
// Time Complexity: O(N log k), where N is the total number of nodes across all lists and k is the number of lists. Each node is added and removed from the heap once.
// Space Complexity: O(k) for the heap, which holds at most one node from each list at any time.
