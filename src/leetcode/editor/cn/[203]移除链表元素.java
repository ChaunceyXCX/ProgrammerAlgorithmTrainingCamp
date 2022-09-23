//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
//
// Related Topics 递归 链表 👍 1034 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(1,head);  //新建个虚拟头把当前头接入,用于删除头节点
        ListNode current = newHead;  //存储当前判断的节点,将当前节点只想新的头节点,下面就可以直接判断下一节点
        while(current.next != null){ //每次判断当前节点的下一节点
            if (current.next.val == val){
                current.next = current.next.next; //如果命中逻辑删除将当前节点的下一节点指向下下节点,这里要注意命中的话不用后移指针,下轮循环判断新接入的节点即:下下节点
            }else {
                current = current.next; //没有命中指针后移
            }
        }
        return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
