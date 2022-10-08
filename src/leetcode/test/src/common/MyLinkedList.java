package common;

public class MyLinkedList {

    //单链表-虚拟头
    private int val;
    public MyLinkedList next;

    private int index;

    private int length;

    public MyLinkedList() {

    }

    public MyLinkedList(int i, MyLinkedList head) {
        this.val = i;
        this.next = head;
    }


    public int get(int index) {
        int current = 0;
        MyLinkedList currentNode = this.next;
        while (currentNode != null) {
            if (current == index) {
                return currentNode.val;
            }
            current++;
            currentNode = currentNode.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        // 虚拟头的下一个就是Head
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.val = val;
        linkedList.next = this.next;
        this.next = linkedList;

    }

    public void addAtTail(int val) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.val = val;
        MyLinkedList linkedList = this;
        while (linkedList.next != null) {
            linkedList = linkedList.next;
        }
        linkedList.next = myLinkedList;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            this.addAtHead(val);
            return;
        }
        int current = 0;
        MyLinkedList currentNode = this;
        while (currentNode != null) {
            if (current == index) {
                MyLinkedList myLinkedList = new MyLinkedList();
                myLinkedList.val = val;
                myLinkedList.next = currentNode.next;
                currentNode.next = myLinkedList;
                return;
            }
            current++;
            currentNode = currentNode.next;
        }
    }

    public void deleteAtIndex(int index) {
        int current = 0;
        MyLinkedList currentNode = this;
        while (currentNode.next != null ) {
            if (current == index ) {
                currentNode.next = currentNode.next.next;
                return;
            }
            current++;
            currentNode = currentNode.next;
        }
    }


    public void addAll(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            this.addAtIndex(i,ints[i]);
        }
    }

    public void printList(){
        MyLinkedList cur = this;
        StringBuilder s = new StringBuilder();
        while (cur != null) {
            s.append(cur.val).append("->");
            cur = cur.next;
        }
        System.out.println(s);
    }

    public MyLinkedList getIntersectionNode(MyLinkedList headA, MyLinkedList headB) {
        //反转链表
        MyLinkedList headAA = headA;
        headAA = reverseList(headAA);
        MyLinkedList headBB = headB;
        headBB = reverseList(headBB);
        //找到第一个下一节点不等的节点
        while (headAA.next.val==headBB.next.val){
            System.out.println(headAA.val);
            System.out.println(headBB.val);
            headAA = headAA.next;
            headBB = headBB.next;

        }
        return headAA;


    }

    public MyLinkedList reverseList(MyLinkedList head){
        MyLinkedList pre = null;
        MyLinkedList cur = head;
        while (cur!=null){
            MyLinkedList temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


}
