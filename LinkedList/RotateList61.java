public class RotateList61 {
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null || head.next==null) return head;
        // Calculating the length of the linked list so that we need not to do unnecessary rotations.
        ListNode start = head;
        int length = 1;
        while(start.next!=null){
            start=start.next;
            length++;
        }
        // This is the last element of the Original List.
        ListNode lastNode = start;
        // Updating k so that we need not to do same rotations again.
        k = k%length;
        // if k is 0 then we need not to do anything.Just Simply return.
        if(k==0) return head;
        // Creating a new pointer and moving that till the end of new List.
        ListNode temp = head;
        for(int i = 1;i<length-k;i++){
            temp=temp.next;
        }
        // Logic to redesign the list.
        ListNode newHead = temp.next;
        temp.next = null;
        lastNode.next = head;
        
        return newHead; 
 }
}
  
}