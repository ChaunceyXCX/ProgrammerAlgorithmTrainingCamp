// 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
// 输入: nums = [2,3,1,1,4]
// 输出: 2
// 解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
// 输入: nums = [2,3,0,1,4]
// 输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 贪心 数组 动态规划 👍 1843 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int curCcoverage = 0; // 当前覆盖下标距离
        int nextCoverage = 0; // 下一步下标最远距离
        int res = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            nextCoverage = Math.max(nums[i] + i, nextCoverage); // 不断更新下一步的最远距离
            if (i == curCcoverage) {
                // 当前步下标没有达到数组末尾步数加1,进入下一步
                res++;
                curCcoverage = nextCoverage;
            }
        }

        return res;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
