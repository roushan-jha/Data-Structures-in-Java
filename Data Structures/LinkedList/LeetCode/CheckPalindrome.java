//Question: https://leetcode.com/problems/palindrome-linked-list/description/
/////////////////////////////////////////////////////////////////////////////

// public class CheckPalindrome {
//     public boolean isPalindrome(ListNode head) {
//         ListNode mid = middleNode(head);
//         ListNode reverseHead = reverse(head);

//         ListNode first = head;
//         ListNode second = reverseHead;

//         while(first != null && second != null) {
//             if(first.val != second.val) {
//                 break;
//             }
//             first = first.next;
//             second = second.next;
//         }

//         reverse(reverseHead);

//         if(first == null || second == null) {
//             return true;
//         }

//         return false;
//     }

//     public ListNode middleNode(ListNode head) {
//         ListNode slow = head;
//         ListNode fast = head;

//         while(fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         return slow;
//     }

//     private ListNode reverse(ListNode head) {
//         if(head == null || head.next == null) {
//              return head;
//         }
//         ListNode prev = null;
//         ListNode current = head;
//         ListNode Next = current.next;

//         while (current != null) {
//             current.next = prev;
//             prev = current;
//             current = Next;
//             if(Next != null) {
//                 Next = Next.next;
//             }
//         }

//         return prev;
//     }
// }

/////////////////////////////////////////////////////////////////////////////