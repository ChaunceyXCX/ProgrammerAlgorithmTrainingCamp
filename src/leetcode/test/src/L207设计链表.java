import common.MyLinkedList;

public class L207设计链表 {


    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(2);
        linkedList.deleteAtIndex(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2); //链表变为1-> 2-> 3
        int a4 = linkedList.get(1); //返回2
        linkedList.deleteAtIndex(1); //现在链表是1-> 3
        int a6 = linkedList.get(1); //返回3

    }





}
