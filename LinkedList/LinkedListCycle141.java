// "If two people start running from the same point on a circular track and one runs at twice the speed of the other, then the faster runner will inevitably lap the slower one—meaning they will meet again at some point on the track. This principle of guaranteed intersection due to relative speed on a closed loop is exactly what underlies Floyd's Cycle Detection algorithm. The slow and fast pointers—starting together and moving at different speeds—will eventually meet if a cycle exists."


public class LinkedListCycle141 {
  public static void main(String[] args) {

    public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head ;
        ListNode fast = head ;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next ;
            slow = slow.next;
            if(fast==slow) return true;
        }

        return false;
        
    }
}
}
}
