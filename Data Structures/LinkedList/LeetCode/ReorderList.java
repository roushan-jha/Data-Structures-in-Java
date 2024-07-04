// Question: https://leetcode.com/problems/reorder-list/
////////////////////////////////////////////////////////

// public class ReorderList {

//     public void reorderList(ListNode head) {
//         if(head == null || head.next == null) {
//             return;
//         }
//         ListNode mid = middleNode(head);
//         ListNode second = reverse(mid);
//         ListNode first = head;

//         while(first != null && second != null) {
//             ListNode temp = first.next;
//             first.next = second;
//             first = temp;

//             temp = second.next;
//             second.next = first;
//             second = temp;
//         }

//         if(first != null) {
//             first.next = null;
//         }
//     }
    
//     //USING RECURSION
//     public void reorderList(ListNode head) {
//         if(head == null || head.next == null) {
//             return;
//         }
//         ListNode temp = head;
//         ListNode ptr = reverse(temp.next);

//         temp.next = ptr;
//         temp = temp.next;
//         ptr = ptr.next;

//         while(ptr != null) {
//             ptr = reverse(ptr);
//             temp.next = ptr;
//             temp = temp.next;
//             ptr = ptr.next;
//         }
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
//             return head;
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

////////////////////////////////////////////////////////