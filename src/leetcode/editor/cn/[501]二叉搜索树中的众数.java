//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。 
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 531 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
import java.util.stream.Collectors;

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

    int maxCount = 0;
    int count = 0;
    TreeNode pre = null;
    List<Integer> res = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        searceBST(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public void searceBST(TreeNode root) {
        if (root == null) return;
        searceBST(root.left); //左
        //中
        if (pre == null){ //第一个节点
            count = 1;
        }else if (pre.val== root.val) { //与前一个节点相等
            count++;
        }else { //与前一个节点不等
            count = 1;
        }
        pre = root;
        if (count == maxCount){ //重复最大频率节点
            res.add(root.val);
        }

        //最大频率节点更新
        if (count>maxCount){
            res.clear();
            res.add(root.val);
            maxCount = count;
        }
        searceBST(root.right); //右
    }
}
//leetcode submit region end(Prohibit modification and deletion)
