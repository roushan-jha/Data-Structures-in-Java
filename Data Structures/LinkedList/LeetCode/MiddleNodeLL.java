//Question: https://leetcode.com/problems/middle-of-the-linked-list/
////////////////////////////////////////////////////////////////////

// public class MiddleNodeLL {
//     public ListNode middleNode(ListNode head) {
//         ListNode temp = head;
//         int size = 0;
        
//         while(temp != null) {
//             temp = temp.next;
//             size++;
//         }

//         double mid = Math.floor(size/2);
//         ListNode midNode = head;
//         for(int i = 0; i < mid; i++) {
//             midNode = midNode.next;
//         }

//         return midNode;
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
// }

/////////////////////////////////////////////////////////////////////