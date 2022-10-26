//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
//
// Related Topics 贪心 哈希表 双指针 字符串 👍 839 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
        //先遍历字符串统计字符最后出现的下标
        //然后根据最后出现的下标分割字符串
        int[] hash = new int[26]; //全小写字母,哈希表大小可以固定
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int left = 0,maxRight = -1;
        for (int i = 0; i < s.length(); i++) {
            //取右边界最大值
            maxRight = Math.max(maxRight,hash[s.charAt(i)-'a']);
            if (i == maxRight){ //如果下标到达有边界最大值
                res.add(i-left+1); //记录区间长度
                left = i+1; //更新左边界
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
