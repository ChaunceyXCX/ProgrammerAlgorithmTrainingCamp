//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 1604 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length()<needle.length()){ //剪枝
            return -1;
        }

        int[] next = new int[needle.length()];
        getNext(next,needle); //前缀数组
//        System.out.println(Arrays.toString(next));
        int j = 0; //needle指针
        for (int i = 0; i < haystack.length(); i++) {
            while (j>0 && needle.charAt(j) != haystack.charAt(i)){
                j = next[j-1]; //不相等j向前回退
            }
            if (needle.charAt(j) == haystack.charAt(i)){
                j++; //相等双指针前移：i在for循环中移动
            }
            if (j == needle.length()){  //移动到模式串末尾证明找到匹配子串了
                return i-needle.length()+1; //计算第一个匹配字符所在位置
            }
        }
        return -1;
    }

    private void getNext(int[] next, String s){
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) { //注意i从1开始
            //前后缀不相等一直往前找
            while (j>0 && s.charAt(i) != s.charAt(j)){
                j = next[j-1]; //向前回退
            }
            //前后缀相等j往后移动
            if (s.charAt(j) == s.charAt(i)){
                j++;
            }
            next[i] = j;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
