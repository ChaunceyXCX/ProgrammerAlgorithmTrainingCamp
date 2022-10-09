//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
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
// Related Topics 树 广度优先搜索 二叉树 👍 621 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root!=null) deque.push(root);
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            while (size-->0){
                TreeNode node = deque.pollLast();
                list.add(node.val);
                if (node.left != null) deque.push(node.left);
                if (node.right != null) deque.push(node.right);
            }
            stack.push(list);
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
