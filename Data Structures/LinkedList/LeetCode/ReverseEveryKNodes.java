//Question: https://leetcode.com/problems/reverse-nodes-in-k-group/description/
///////////////////////////////////////////////////////////////////////////////

// public class ReverseEveryKNodes {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         if(k <= 1 || head == null) {
//             return head;
//         }

//         ListNode prev = null;
//         ListNode current = head;
        
//         int size = getSize(head);
//         int i = 0;
//         while (i < Math.floor(size/k)) {
//             ListNode last = prev;
//             ListNode newEnd = current;

//             ListNode Next = current.next;

//             for(int j = 0; current != null && j < k; j++) {
//                 current.next = prev;
//                 prev = current;
//                 current = Next;
//                 if(Next != null) {
//                     Next = Next.next;
//                 }
//             }

//             if(last != null) {
//                 last.next = prev;
//             } else {
//                 head = prev;
//             }

//             newEnd.next = current;

//             if(current == null) {
//                 break;
//             }

//             prev = newEnd;

//             i++;  
//         }
//         return head;
//     }

//     private int getSize(ListNode head) {
//         int size = 0;
//         ListNode ptr = head;

//         while (ptr != null) {
//             ptr = ptr.next;
//             size++;
//         }

//         return size;
//     }
// }

///////////////////////////////////////////////////////////////////////////////