//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2137 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
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
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return  true;

        return compare(root.left,root.right);
    }

    boolean compare(TreeNode left, TreeNode right) {
        //排除空姐点情况
        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left==null && right == null) return true;
        //排除左右根节点不相等
        else if (left.val != right.val ) return false;
        //左右相等根节点相等的情况下，判断相应的内外层节点是否相等
        boolean outside = compare(left.left,right.right);
        boolean inside = compare(left.right,right.left);
        return outside & inside;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
