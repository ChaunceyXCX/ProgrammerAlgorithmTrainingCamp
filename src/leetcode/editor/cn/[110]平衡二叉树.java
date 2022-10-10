//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1151 👎 0


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
    public boolean isBalanced(TreeNode root) {
        if (getHeight(root)==-1){
            return false;
        }
        return true;
    }

    public int getHeight(TreeNode cur){
        // 如果当前节点为空直接返回高度为0
        if (cur == null) return 0;
        // 如果左子树不是完全二叉树直接返回-1
        int leftHeight = getHeight(cur.left);
        if (leftHeight == -1) return -1;
        // 如果当前节点的左子树不是完全二叉树直接返回-1
        int rightHeight = getHeight(cur.right);
        if (rightHeight == -1) return -1;
        // 判断当前节点是否完全二叉树
        if (Math.abs(leftHeight-rightHeight)>1){
            return -1;
        } else {
            // 如果是完全二叉树返回当前节点的高度
            return 1+Math.max(leftHeight,rightHeight);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
