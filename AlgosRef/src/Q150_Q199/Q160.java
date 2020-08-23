package Q150_Q199;

import ds.ListNode;

public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {  // this is a very tricky solution; need to memorize; 这个题 通过变换两次两个数组的头,从而达到目的
        ListNode currA = headA;  // 最开始感觉这是一个N^2的方法，但好像其实是一个m+n的方法
        ListNode currB = headB;
        while(currA != currB){  // 直到找到结果为止或者都是Null
            currA = currA == null ? headB: currA.next;  // 这个逻辑
            currB = currB == null ? headA: currB.next;
        }

        return currA;
    }

    public static void main(String[] args) {
//        ListNode n0 = new ListNode(0);
//        ListNode n9 = new ListNode(9);
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n4 = new ListNode(4);
//        ListNode n3 = new ListNode(3);
//        n0.next = n9; n9.next=n1; n1.next=n2; n2.next=n4; n3.next=n2;
//        System.out.println(new Q160().getIntersectionNode(n0, n3).val);

        ListNode n6 = new ListNode(6);
        ListNode n1 = new ListNode(1);
        ListNode n8 = new ListNode(8);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n7 = new ListNode(7);
        ListNode n0 = new ListNode(0);

        n6.next = n1; n1.next=n8; n8.next=n4; n4.next=n5; n7.next=n0; n0.next = n1;
        System.out.println(new Q160().getIntersectionNode(n6, n7).val);
    }
}
