// 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
// 序列。
//
// 示例 1： 
//
// 
// 输入：nums = [10,9,2,5,3,7,101,18]
// 输出：4
// 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
// 输入：nums = [0,1,0,3,2,3]
// 输出：4
// 
//
// 示例 3： 
//
// 
// 输入：nums = [7,7,7,7,7,7,7]
// 输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
//
// Related Topics 数组 二分查找 动态规划 👍 2868 👎 0


import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length<=1)return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //返回dp数组中最大的长度，因为只计算nums[i] > nums[j]有可能出现最后一位dp不是最大长度
            // 例：nums：[1,3,6,7,9,4,10,5,6]；dp：[1, 2, 3, 4, 5, 3, 6, 4, 5]
            if (dp[i]>result) result = dp[i];
        }
        // System.out.println(Arrays.toString(dp));
        return result;
        // return dp[nums.length-1];
    }

}
// leetcode submit region end(Prohibit modification and deletion)
