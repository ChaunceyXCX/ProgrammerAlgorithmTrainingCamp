//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 391 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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

    private int maxDepth = Integer.MIN_VALUE;
    private int result;
    public int findBottomLeftValue(TreeNode root) {
        getLeft(root,0);
        return result;
    }

    public void getLeft(TreeNode cur, int depth){
        //递归终止条件
        if (cur.left == null && cur.right == null) {
            // depth已经在上轮递归中加1了
            if (maxDepth<depth){
                maxDepth = depth;
                result = cur.val;
            }
        }

        //注意一定要先访问左子树，因为要保证从左边搜索
        if (cur.left != null) {
            depth++;
            getLeft(cur.left, depth);
            depth--; //回溯
        }
        if (cur.right != null) {
            depth++;
            getLeft(cur.right, depth);
            depth--; //回溯
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
