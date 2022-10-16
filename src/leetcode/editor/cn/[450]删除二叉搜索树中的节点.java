//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
// 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
// 
//
// 示例 3: 
//
// 
//输入: root = [], key = 0
//输出: [] 
//
// 
//
// 提示: 
//
// 
// 节点数的范围 [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 节点值唯一 
// root 是合法的二叉搜索树 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// Related Topics 树 二叉搜索树 二叉树 👍 973 👎 0


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
    public TreeNode deleteNode(TreeNode root, int key) {
        // 递归终止条件
        //第一种情况没有找到要删除节点
        if(root == null) return null;
        if(root.val == key) {
             // 第一种情况 左右子树都为空
            if (root.left == null && root.right == null){
                root = null;
                return root;
            }
            // 第二种情况 左子树为空右子树不为空
            else if (root.left == null && root.right != null){
                return root.right;
            }
            // 第三种情况 左子树不为空右子树为空
            else if (root.left != null && root.right == null) {
                return root.left;
            }
            // 第四种情况 左右子树都不为空 ：将左子树指向右子树最右边节点返回右子树根节点
            else {
                TreeNode node = root.right;
                // 查找右子树左下角
                while (node.left != null){
                    node = node.left;
                }
                node.left = root.left;
                return root.right;
            }
        }

        // 根据二叉搜索树的特性向左或者向右搜索
        //如果搜索到了下一层返回的就是重新指向的左或者右节点
        if (root.val > key) root.left = deleteNode(root.left,key);
        if (root.val < key) root.right = deleteNode(root.right,key);
        // 然后递归返回当前节点
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
