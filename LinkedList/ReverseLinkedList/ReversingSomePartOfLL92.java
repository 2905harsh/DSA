public class ReversingSomePartOfLL92 {
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Creating a Dummy Node 
        ListNode dummy = new ListNode(0);
        dummy.next = head ;
        ListNode BeforeLeft = dummy;

        // for finding node just before left
        for(int i =1 ; i<left ; i++){
            BeforeLeft = BeforeLeft.next;
        }

        ListNode prev = BeforeLeft;
        ListNode curr = prev.next;

        for(int i =0 ; i<right-left ; i++){
            ListNode nxt = curr.next;
            curr.next = nxt.next;
            nxt.next = prev.next;
            prev.next = nxt;
        }
       // NO return head;
       return dummy.next;


        
    }
}

  
}