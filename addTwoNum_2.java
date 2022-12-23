import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}
public class addTwoNum_2 {
    public static void traverse(ListNode l){
        /* print all values out in ListNode with delimiter -> */
        ListNode cur = l;
        while (cur != null){
            if (cur.next == null) {
                System.out.print(cur.val);
                break;
            }
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }

    public static ListNode addTwoNum(ListNode l1, ListNode l2) {
        /* add two numbers regarding linked list in reverse order */
        // See the example in test part of the below main function
        // PseudoCode
        // -1. define a dummy node
        // 0. define a carry value as 0; carry = 0
        // 1. find the current digit for two numbers, l1, l2 from left to right; num1, num2
        //   if l1 == null then 0; otherwise l1.val
        //   this is true of l2
        // 2. get the sum of this position with a carry value; sum
        // 3. update carry value with sum/10
        // 4. mark current value with sum%10, and point to it; cur.next = new ListNode(sum%10)
        // 5. move to the next node for result, l1, and l2 if they are not null
        // 6. for loop 1 - 5 until all digits in l1 or l2 are considered
        // 7. after the loop, if carry exist, then add this new node
        // 8. return the first node in the linked list; dummy.next

        // -1
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        // 0
        int carry = 0;

        // 6
        while (l1 != null || l2 != null) {
            // 1
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            // 2
            int sum = num1 + num2 + carry;

            // 3
            carry = sum / 10;

            // 4
            cur.next = new ListNode(sum%10);

            // 5
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // 7
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        // 8
        return dummy.next;
    }

    public static void main(String[] args) {
        // for test purpose
        // construct node
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);

        // construct two test linked list in reverse order 2->4->3; 5->6->4, then reach 7->0->8, got 807
        // Think the add operation for two values in general, we do by right to left and if the sum of digits greater
        //   than 10, we give one more to the left position, and finally we got a value, which can be read from
        //   left to right.
        // However, if we store these two values in a reverse order, then add from left to right, and got the final
        //   value, which can be read from the right to left. The value equals with the above one.
        // We use linked list to store values in a reversed order, then reach the same direction of operations(add & move)
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;

        // test traverse function
        traverse(l1);
        traverse(l4);

        // test addTwoNum function
        traverse(addTwoNum(l1, l4));
    }
}
