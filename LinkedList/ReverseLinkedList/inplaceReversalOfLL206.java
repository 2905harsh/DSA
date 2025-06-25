public class inplaceReversalOfLL206 {
public static void main(String[] args) {
  class Solution {
    public ListNode reverseList(ListNode head) {
        // inplace reversal of linked list
        ListNode prev = null ;
        ListNode curr = head ;
        while(curr!=null){
            ListNode nxt = curr.next;
            curr.next = prev ;
            prev = curr;
            curr = nxt;
        }
        return prev ;
    }
}
}
}

// THIS IS A LEETCODE PROBLEM AND CLASS SOLUTION CAN BE DIRECTLY USED TO SUBMIT THE CODE.
