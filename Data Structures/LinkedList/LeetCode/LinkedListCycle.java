//Question: https://leetcode.com/problems/linked-list-cycle/
////////////////////////////////////////////////////////////

//Notes: Fast & slow pointer method is used to solve
//      i) Cycle detection problems
//      ii) Finding a node in cycle, etc

// public class LinkedListCycle {
//     public boolean hasCycle(ListNode head) {
//          ListNode fast = head;
//          ListNode slow = head;

//          while(fast != null && fast.next != null) {
//              fast = fast.next.next;
//              slow = slow.next;

//              if(fast == slow) {
//                  return true;
//              }
//          }
//          return false;
//     }

//     public boolean lengthCycle(ListNode head) {
//          ListNode fast = head;
//          ListNode slow = head;

//          while(fast != null && fast.next != null) {
//              fast = fast.next.next;
//              slow = slow.next;

//              if(fast == slow) {
//                  int length = 0;
//                  do {
//                      slow = slow.next;
//                      length++;
//                  } while (slow != fast);
//                  return length;
//              }
//          }
//          return 0;
//     }

// }

//////////////////////////////////////////////////////////////