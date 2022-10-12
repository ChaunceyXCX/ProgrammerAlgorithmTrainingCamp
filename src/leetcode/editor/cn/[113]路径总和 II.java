//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 853 👎 0


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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        path.add(root.val);
        getPaths(root,targetSum-root.val,list);
        return list;
    }

    private List<Integer> path = new ArrayList<>();
    public void getPaths(TreeNode cur, int count, List<List<Integer>> list) {
        //终止条件
        if (cur.left == null && cur.right == null && count == 0) {
            list.add(new ArrayList<>(path));
            return;
        }
        if (cur.left == null && cur.right ==null) return;

        //
        if (cur.left!= null) {
            count = count-cur.left.val;
            path.add(cur.left.val);
            getPaths(cur.left,count,list);
            //回溯
            count = count+cur.left.val;
            path.remove(path.size()-1);
        }

        if (cur.right!= null) {
            count = count-cur.right.val;
            path.add(cur.right.val);
            getPaths(cur.right,count,list);
            //回溯
            count = count+cur.right.val;
            path.remove(path.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
