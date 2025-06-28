public class ReverseNodesInKGroup25 {
  class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
            
            // Creating an imaginary Previous Node that points to head initailly .
            ListNode prev = new ListNode(0);
            prev.next = head;
             
            // Creating a copy of original imaginary Previous Node it will help us in returning the answer finally.
            ListNode dummy = prev;

            // Now with the help of four pointer (prev , curr ,end,nxt) we will reverse every k parts.
            // prev - It is node that is just before the prev so that after reversing the k parts we can make links
            // curr - points to starting node of a particular group of length k .
            // end - poins to the ending node of a particular group of length k .
            // nxt - it points to the next node of end . It tracks the the next element of end in orginal list beacuse after reversal we cannot find the node without it since links are breaked. 

            ListNode curr = head;
            while(curr.next!=null){
                curr = prev.next;
                ListNode end = curr;

                // This loop makes the end to point at the last node of the particular group of length k .
                for(int i =1 ; i<k ;i++){
                     if(end.next==null) return dummy.next;
                     else end = end.next;
                }
                 
                ListNode nxt = end.next;

                revpart(curr,k);

                // Making connections of particular group of length k after its reversal to fit in original list.
                curr.next = nxt;
                prev.next = end;
                prev = curr;
            }
            
            return dummy.next;
        
    }
    
    // This function reverses the nodes till the length of k.
    public void revpart(ListNode a , int k){
        ListNode prev = a;
        ListNode curr = prev.next;
        for(int i =1 ; i<k;i++){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
    }
}

}
