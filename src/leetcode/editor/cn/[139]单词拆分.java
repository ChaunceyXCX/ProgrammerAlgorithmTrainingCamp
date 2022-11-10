// 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
// 输入: s = "leetcode", wordDict = ["leet", "code"]
// 输出: true
// 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
// 输出: true
// 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
// 输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1855 👎 0


import java.util.HashSet;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int size = s.length();
        boolean[] dp = new boolean[size + 1];
        // 后面的再前面的基础上判断而来所以如果dp[0] = false 后面都为false
        dp[0] = true;

        for (int j = 1; j <= size; j++) {
            for (int i = 0; i < j; i++) {
                // 将背包拆分为[0-i]  [i-j]两份
                String subStr = s.substring(i, j);
                if (set.contains(subStr) && dp[i]){
                    dp[j] = true;
                }
            }
        }
        return dp[size];

    }
}
// leetcode submit region end(Prohibit modification and deletion)
