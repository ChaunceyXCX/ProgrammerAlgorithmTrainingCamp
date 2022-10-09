//给定一个非空二叉树的根节点
// root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10⁻⁵ 以内的答案可以被接受。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[3.00000,14.50000,11.00000]
//解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
//因此返回 [3, 14.5, 11] 。
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root = [3,9,20,15,7]
//输出：[3.00000,14.50000,11.00000]
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 树中节点数量在 [1, 10⁴] 范围内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 372 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
    public List<Double> averageOfLevels(TreeNode root) {
//定义队列动态的遍历二叉树中的元素
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) deque.push(root);
        List<Double> list = new ArrayList<>();
        while (!deque.isEmpty()) {
            //每一层节点元素个数,一定要先取出来，因为下面出队列时长度时不断变化的
            int size = deque.size();
            Double sizeBack = Double.valueOf(size);

            Double temp = 0d;
            //根据每层元素个数组装每层数组
            while (size-->0){
                //不断出队列当前层元素
                TreeNode node = deque.pollLast();
                temp+=node.val;
                //出队列的同时把左右叶子节点入队，组装下一层节点元素
                if (node.left != null)
                    deque.push(node.left);
                if (node.right != null)
                    deque.push(node.right);
            }

            list.add(temp/sizeBack);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
