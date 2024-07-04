//Question: https://leetcode.com/problems/reverse-linked-list-ii/description/
/////////////////////////////////////////////////////////////////////////////

// public class ReverseBetween {
//     public ListNode reverseBetween(ListNode head, int left, int right) {
//         if(left == right) {
//             return head;
//         }

//         ListNode prev = null;
//         ListNode current = head;

//         for(int i = 0; current != null && i < left - 1; i++) {
//             prev = current;
//             current = current.next;
//         }

//         ListNode last = prev;
//         ListNode newEnd = current;

//         ListNode Next = current.next;
//         for(int j = 0; current.next && j < right - left + 1; j++) {
//             current.next = prev;
//             prev = current;
//             current = Next;
//             if(Next != null) {
//                 Next = Next.next;
//             }
//         }

//         if(last != null) {
//             last.next = prev;
//         } else {
//             head = prev;
//         }

//         newEnd.next = current;
//         return head;
//     }
// }

/////////////////////////////////////////////////////////////////////////////