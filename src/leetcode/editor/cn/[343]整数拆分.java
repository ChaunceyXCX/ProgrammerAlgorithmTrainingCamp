//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
//
// Related Topics 数学 动态规划 👍 967 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        // dp[i]，表示第i位的最大乘积，因为要取第n位所以数组长度n+1更好理解
        int[] dp = new int[n+1];
        // dp[0]和dp[1],0和1不能拆分没有意义可以不用考虑
        dp[2] = 1;
        // 因为初始值是2所以i从3开始遍历
        for (int i = 3; i <= n ; i++) {
            for (int j = 1; j <=i-j ; j++) {
                // j*(i-j) 其实是将i拆分成j和i-j两个数; j*dp[i-j] 其实是将i拆分成 j 和 i-j对用的不同可能(i-j取了不同可能的最大值)
                dp[i] = Math.max(dp[i], Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
