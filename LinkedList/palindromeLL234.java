public class palindromeLL234 {
  class Solution {

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        if(head.next.next==null){
            if(head.val==head.next.val) return true;
            else return false;
        }
          ListNode middle = FindMiddle(head);
          reverselist(middle);

          //We are reversing the linked list after the middle element.
          //  OG list => 1->2->3->3(middle)->2->1
          //  after reversing 1->2->3->3(middle)->1->2
         //   Now we do comparison using 2 variable a and b.

          ListNode a = head;
          ListNode b = middle.next;

          while(b!=null){
            if(a.val!=b.val) return false;
            a=a.next;
            b=b.next;
          }
          if(middle.val!=a.val) return false;
          return true;
    
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
