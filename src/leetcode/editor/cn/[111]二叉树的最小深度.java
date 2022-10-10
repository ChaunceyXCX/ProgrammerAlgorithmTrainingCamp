//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 854 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public int minDepth(TreeNode root) {
        return getMinDepth(root);
    }

    public int getMinDepth(TreeNode cur){
        if (cur == null) return 0;
        int left = getMinDepth(cur.left);
        int right = getMinDepth(cur.right);
        // 左右叶子节点都为空的节点才算数所以有如下三种情况
        // 如果左叶子节点不为空右叶子节点为空，那么计算左叶子节点对应的最小深度
        if (cur.left != null && cur.right == null) {
            return 1+left;
        }
        // 如果右叶子节点不为空，且左叶子节点为空，那么查找右叶子节点的最小深度并+1返回
        if (cur.right != null && cur.left == null) {
            return 1+right;
        }
        // 如果都为空返回最小值
        return 1+Math.min(left,right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
