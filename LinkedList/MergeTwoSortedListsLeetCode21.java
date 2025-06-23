// 1->2->4
// 1->3->4
// 0->1->1->2->3->4->4
// but we neglect 0 . That's why we return preHead.next .

public class MergeTwoSortedListsLeetCode21 {
  public static void main(String[] args) {
    class Solution {
      public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // You are creating a new node of type ListNode. Since no value is passed, it
        // uses the default constructor.So this node has val = 0 by default (Java sets
        // int to 0) & has next = null . 
        ListNode StartNode = new ListNode();

        // This is another reference (pointer) . This is made to return head of the new
        // linked list at the end.
        ListNode preHead = StartNode;

        ListNode h1 = list1;
        ListNode h2 = list2;

        while (h1 != null && h2 != null) {

          if (h1.val <= h2.val) {
            StartNode.next = h1;
            h1 = h1.next;
            StartNode = StartNode.next;
          }

          else if (h2.val <= h1.val) {
            StartNode.next = h2;
            h2 = h2.next;
            StartNode = StartNode.next;
          }

        }

        if (h1 == null) {
          StartNode.next = h2;
        }
        if (h2 == null) {
          StartNode.next = h1;
        }

        return preHead.next;
      }
    }

  }
}
