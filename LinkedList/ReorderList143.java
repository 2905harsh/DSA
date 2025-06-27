public class ReorderList143 {
  class Solution {

    public void reorderList(ListNode head) {

        if(head==null || head.next == null || head.next.next==null ) return ;

        //finding the middle node of the linked list.

        ListNode middle = FindMiddle(head);

        // reversing the list only from the node next to middle till the end of list.
        // OG LIST => 1->2->3->4->5->6->7
        reverselist(middle);
        // Now the list to converted to  1->2->3->4(middle)->7->6->5
        // In case of two middle we will get the second middle by the function.
        
        // Now the actual rearrangement of nodes will be done.
        ListNode start = head ;
        ListNode end  = middle.next;
        while(end!=null){
            ListNode afterStart = start.next;
            ListNode afterEnd = end.next;
            start.next = end;
            end.next = afterStart;
            start = afterStart;
            end = afterEnd;
        } 
        middle.next = null;

        // No need to return anything.
        
    }

    public ListNode FindMiddle(ListNode node){
        ListNode slow = node;
        ListNode fast = slow;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public void reverselist(ListNode node){
        ListNode mid = node;
        ListNode prev = mid.next;
        ListNode curr = prev.next;
        ListNode nxt = null;
        while(curr!=null){
            nxt = curr.next;
            curr.next = prev;
            if(mid.next == prev) prev.next = null; 
            prev = curr;
            curr = nxt;
        }
        mid.next = prev ; 

    }

}
}

// This is the Leetcode problem 143. Reorder List. The class Solution can directly used to submit on Leetcode.
// Time Complexity is O(n).
//Space Complexity Analysis
//	•	No extra data structures used (like arrays, hashmaps, etc.)
//	•	Only a few pointers (start, end, prev, curr, etc.) are used ⇒ Constant extra space
//	•	Thus, the space complexity is O(1).