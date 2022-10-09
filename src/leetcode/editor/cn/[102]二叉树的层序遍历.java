//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1480 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //定义队列动态的遍历二叉树中的元素
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) deque.push(root);
        List<List<Integer>> list = new ArrayList<>();
        while (!deque.isEmpty()) {
            //每一层节点元素个数,一定要先取出来，因为下面出队列时长度时不断变化的
            int size = deque.size();
            List<Integer> temp = new ArrayList<>();
            //根据每层元素个数组装每层数组
            while (size-->0){
                //不断出队列当前层元素
                TreeNode node = deque.pollLast();
                temp.add(node.val);
                //出队列的同时把左右叶子节点入队，组装下一层节点元素
                if (node.left != null)
                deque.push(node.left);
                if (node.right != null)
                deque.push(node.right);
            }
            list.add(temp);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
