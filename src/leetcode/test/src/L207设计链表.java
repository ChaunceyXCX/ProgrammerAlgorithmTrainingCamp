import common.MyLinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> sMap = new HashMap();
        Map<Character,Integer> tMap = new HashMap();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        if (sArr.length!=tArr.length){
            return false;
        }
        for (int i = 0; i < sArr.length; i++) {
            if (sMap.get(sArr[i])==null){
                sMap.put(sArr[i],1);
            }else {
                sMap.put(sArr[i],sMap.get(sArr[i])+1);
            }
        }
        for (int i = 0; i < tArr.length; i++) {
            if (tMap.get(tArr[i])==null){
                tMap.put(tArr[i],1);
            }else {
                tMap.put(tArr[i],tMap.get(tArr[i])+1);
            }
        }
        for (Character sc :
                sMap.keySet()) {
            if (tMap.get(sc)==null || tMap.get(sc).intValue() != sMap.get(sc).intValue()){
                return false;
            }
        }

        return true;

    }

}
