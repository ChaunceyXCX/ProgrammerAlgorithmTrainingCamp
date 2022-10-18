// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
// 和 "192.168@1.1" 是 无效 IP 地址。
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
// 排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "25525511135"
// 输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
// 输入：s = "0000"
// 输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
// 输入：s = "101023"
// 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1047 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    int pointNum = 0;

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return result; // 算是剪枝了
        backTracking(s, 0);
        return result;
    }

    public void backTracking(String s, int startIndex) {
        // 如果已经组合了三段，如果剩余字符符合就拼接返回
        if (pointNum == 3) {
            // 判断剩余字符是否符合
            if (isValid(s,startIndex,s.length()-1)){

                path.append(s,startIndex,s.length());
                result.add(path.toString());
            }
        }

        for (int i = startIndex; i < s.length() && i - startIndex < 3; i++) {
            String substring = s.substring(startIndex, i + 1);
            if (isValid(s,startIndex,i)) {
                int temp = path.length();
                pointNum += 1;
                path.append(substring).append('.');
                backTracking(s, i + 1);
                pointNum -= 1;
                path.delete(temp, path.length());
            }else break; //不合法直接退出： 如果第一位开始就不合法那么后面的都会不合法
        }
    }

    // 判断左闭右闭区间是否合法
    public boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 0开头的数字不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 非数字不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
