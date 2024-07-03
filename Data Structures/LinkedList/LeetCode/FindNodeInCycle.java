//Question: https://leetcode.com/problems/linked-list-cycle-ii/
//Find the node from where cycle starts
//Steps: i) Find the length of a cycle
//      ii) Move slow pointer (length) times
//     iii) Move slow and fast pointer one by one till (slow == fast) -> true;
///////////////////////////////////////////////////////////////

// public class FindNodeInCycle {
//     public ListNode detectCycle(ListNode head) {
//         int length = lengthCycle(head);

//         if(length == 0) {
//              return null;
//         }

//         ListNode fast = head;
//         ListNode slow = head;

//         for(int i = 0; i < length; i++) {
//             slow = slow.next;
//         }

//         while (slow != fast) {
//             slow = slow.next;
//             fast = fast.next;
//         }

//         return slow;
//     }
// }

////////////////////////////////////////////////////////////////