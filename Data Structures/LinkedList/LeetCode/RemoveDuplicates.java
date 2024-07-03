//Question: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
/////////////////////////////////////////////////////////////////////////////

// public class RemoveDuplicates {
//     public ListNode removeDuplicates(ListNode head) {
//         ListNode ptr = head;

//         while (ptr != null) {
//             if(ptr.next != null && ptr.val == ptr.next.val) {
//                 ptr.next = ptr.next.next;
//             } else {
//                 ptr = ptr.next;
//             }
//         }

//         return head;
//     }
// }

//////////////////////////////////////////////////////////////////////////////