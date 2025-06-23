//.     1->1->2->3->3
//.     1->2->3    


public class RemoveDuplicateFromSortedListLeetCode83 {
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head ; 
        while(currentNode!=null ){
            ListNode temp = currentNode;
            while((temp.next!=null) && (temp.val == temp.next.val)){
                temp = temp.next;
            }
            currentNode.next=temp.next;
            currentNode = temp.next ;
        }
        return head;
    }
}
}

// Class Solution can be directly used in LeetCode submission . 