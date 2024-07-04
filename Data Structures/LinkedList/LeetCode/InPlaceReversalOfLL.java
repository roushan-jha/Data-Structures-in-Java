//Question: https://leetcode.com/problems/reverse-linked-list/description/
//Notes: Use Three pointers method (prev, current, Next)
//////////////////////////////////////////////////////////////////////////

// public class InPlaceReversalOfLL {
//     public ListNode reverseList(ListNode head) {
//         if(head == null || head.next == null) {
//             return head;
//         }

//         ListNode prev = null;
//         ListNode current = head;
//         ListNode Next = current.next;

//         while(current != null) {
//             current.next = prev;
//             prev = current;
//             current = Next;
//             Next = Next.next;
//         }
//         return prev;
//     }
// }

//////////////////////////////////////////////////////////////////////////