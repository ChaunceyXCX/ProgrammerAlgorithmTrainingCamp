import common.MyLinkedList;

public class L面试题0207链表相交 {

    public static void main(String[] args) {
        MyLinkedList headA = new MyLinkedList();
        MyLinkedList headB = new MyLinkedList();
        headA.addAll(new int[]{4,1,8,4,5});
        headB.addAll(new int[]{5,0,1,8,4,5});
        headA = headA.next;
        headB = headB.next;
        headA.printList();
        headB.printList();
        MyLinkedList linkedList = headA.getIntersectionNode(headA,headB);
    }


}
