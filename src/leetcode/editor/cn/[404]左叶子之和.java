//给定二叉树的根节点 root ，返回所有左叶子之和。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [3,9,20,null,null,15,7] 
//输出: 24 
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
// 
//
// 示例 2: 
//
// 
//输入: root = [1]
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 1000] 范围内 
// -1000 <= Node.val <= 1000 
// 
//
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 511 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Deque;
import java.util.LinkedList;

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
    public int sumOfLeftLeaves(TreeNode root) {
        // 递归终止条件
        if (root == null) return 0;
        //因为当前节点的计算放在了父节点所以到达左叶子节点本身不用做操作
        if (root.left == null && root.right == null) return 0;

        int left = sumOfLeftLeaves(root.left);
        //判断叶子节点是否为左节点 如果为左节点上一行的值为0
        if (root.left != null && root.left.left == null && root.left.right == null) {
            left = root.left.val;
        }
        // 计算右子树的左叶子节点
        int right = sumOfLeftLeaves(root.right);
        return left + right;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
