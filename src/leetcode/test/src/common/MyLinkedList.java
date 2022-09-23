package common;

public class MyLinkedList {

    //单链表-虚拟头
    private int val;
    public MyLinkedList next;

    private int index;

    private int length;

    public MyLinkedList() {

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
}
