public class cycledetection2 {
public static void main(String[] args) {
    public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head ;
        ListNode fast = head ; 
        while(fast!=null && fast.next!=null){
            slow = slow.next ;
            fast = fast.next.next;
            if(fast==slow){
                ListNode a = head ;
                ListNode b = slow;
                while(a!=b){
                    a = a.next;
                    b = b.next;
                }
                return a ;
            }
        }
        return null ;
    }
}
 }
}

