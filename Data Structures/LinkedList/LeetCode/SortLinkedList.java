//Question: https://leetcode.com/problems/sort-list/
////////////////////////////////////////////////////

// public class SortLinkedList {
//     //Using Merge Sort
//     public class sortList(ListNode head) {
//         if(head == null && head.next != null) {
//             return head;
//         }

//         ListNode mid = middleNode(head);
//         ListNode left = sortList(head);
//         ListNode right = sortList(mid);

//         return merge(left, right);
//     }

//     private ListNode middleNode(ListNode head) {
//         ListNode slow = head;
//         ListNode fast = head;
//         ListNode prev = null;

//         while (fast != null && fast.next != null) {
//             prev = slow;
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         return slow;
//     }

//     private ListNode merge(ListNode list1, ListNode list2) {
//         ListNode dummyHead = new ListNode();
//         ListNode tail = dummyHead;

//         while (list1 != null && list2 != null) {
//             if(list1.val < list2.val) {
//                 tail.next = list1;
//                 list1 = list1.next;
//                 tail = tail.next;
//             } else {
//                 tail.next = list2;
//                 list2 = list2.next;
//                 tail = tail.next;
//             }
//         }

//         tail.next = (list1 != null) ? list1 : list2;
//         return dummyHead.next;
//     }
// }

/////////////////////////////////////////////////////