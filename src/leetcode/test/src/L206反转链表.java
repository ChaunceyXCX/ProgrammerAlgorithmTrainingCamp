import common.MyLinkedList;

public class L206反转链表 {
    public static void main(String[] args) {
        MyLinkedList head = new MyLinkedList();
        head.addAll(new int[]{1,2,3,4});
        if (head == null) {
//            return head;
        }

        MyLinkedList current = head;
        MyLinkedList newHead = new MyLinkedList();
        while (current.next != null) {
            head = newHead;
            newHead = current.next;
            current.next = current.next.next;
            newHead.next = head;
        }
//        return newHead;
    }
}
