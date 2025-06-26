public class ReversingSomePartOfLL92 {
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Creating a Dummy Node Because in case when (left == 1) where will our prev pointer will point . 😏 
        ListNode dummy = new ListNode(0);
        dummy.next = head ;
        ListNode BeforeLeft = dummy;

        // for finding node just before left 
        for(int i =1 ; i<left ; i++){
            BeforeLeft = BeforeLeft.next;
        }

        // Setting up 3 Pointer prev , curr , nxt . 
        ListNode prev = BeforeLeft;
        ListNode curr = prev.next;
        ListNode nxt = null ; 
        
        for(int i =0 ; i<right-left ; i++){
            nxt = curr.next;
            curr.next = nxt.next;
            nxt.next = prev.next;
            prev.next = nxt;
        }

// We can't return head because head for answer list is different from the head of given list when left is 1 . In this case our prev pointer will be dummy one . So dummy.next is safe to return in all scenarios .   
// NO return head;
return dummy.next;
      }
}
}
