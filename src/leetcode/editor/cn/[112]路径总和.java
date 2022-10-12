//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。如果存在，返回 true ；否则，返回 false 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//解释：等于目标和的根节点到叶节点路径如上图所示。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
//解释：树中存在两条根节点到叶子节点的路径：
//(1 --> 2): 和为 3
//(1 --> 3): 和为 4
//不存在 sum = 5 的根节点到叶子节点的路径。 
//
// 示例 3： 
//
// 
//输入：root = [], targetSum = 0
//输出：false
//解释：由于树是空的，所以不存在根节点到叶子节点的路径。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1015 👎 0


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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return getPathSum(root,targetSum - root.val); //进入递归函数前先减去当前节点的值
    }

    public boolean getPathSum(TreeNode cur, int count){
        //计算叶子节点不用把空节点加入递归
        // 遍历节点的同时将target减去节点的值如果到达叶子节点且target减到0就返回true
        if (cur.left == null && cur.right == null && count == 0) return true;
        // 如果到叶子节点且target没有归0 返回false
        if (cur.left == null && cur.right == null) return false;

        // 单层递归逻辑
        if (cur.left != null) {
            count = count - cur.left.val; //进入递归函数前先减去当前节点的值
            //如果叶子节点返回true 直接返回true
            if (getPathSum(cur.left, count)) return true;
            // 如果叶子节点返回false 回溯
            count = count + cur.left.val;
        }
        if (cur.right != null) {
            count = count - cur.right.val; //进入递归函数前先减去当前节点的值
            //如果叶子节点返回true 直接返回true
            if (getPathSum(cur.right, count)) return true;
            // 如果叶子节点返回false 回溯
            count = count + cur.right.val;
        }

        //如果左右叶子节点都没有得到结果
        // 直接返回false
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
