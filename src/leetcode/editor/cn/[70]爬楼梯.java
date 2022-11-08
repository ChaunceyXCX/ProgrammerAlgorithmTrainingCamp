//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 2713 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        /*
        // 1.确定dp数组及下标含义：dp[i] = 斐波那契数列第i个数的含义
        // 2.确定递推公式：dp[i] = dp[i-1]+dp[i-1]
        // 3.数组如何初始化： dp[0] = 0; dp[1] = 1;
        // 4.确定遍历顺序：从递归公式dp[i] = dp[i - 1] + dp[i - 2];中可以看出，dp[i]是依赖 dp[i - 1] 和 dp[i - 2]，那么遍历的顺序一定是从前到后遍历的
        // 5. 举例推到dp数组：n=10 时 ：0、1、1、2、3、5、8、13、21、34、55;
        if (n<=2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n-1];
        */

        return bag_full(n,2);
    }


    public int bag_full(int n, int m){
        //之前是每次能爬1-2 现在进阶每次能爬1-m
        //完全背包-排列
        int[] dp = new int[n+1];
        dp[0]=1;
        for (int j = 0; j <= n; j++) {
            for (int i = 1; i < m; i++) {
                if (j-i>=0) dp[j]+=dp[j-i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
