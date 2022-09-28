//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 360 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int left = 0;
        int rigih = 0;
        int temp = 0;
        for (int i = 0; i < chars.length; i++) {
            temp++;
            if (temp==2*k){
                left = i-2*k+1;
                rigih = i-k;
                reverseSubArray(left,rigih,chars);
                temp = 0;
            }
        }

        if (temp<k){
            left = chars.length-temp;
            rigih = chars.length-1;
            reverseSubArray(left,rigih,chars);
        }
        if (temp<2*k && temp>=k){
            left = chars.length-temp;
            rigih = left+k-1;
            reverseSubArray(left,rigih,chars);
        }
        return String.copyValueOf(chars);
    }

    private void reverseSubArray(int left, int right, char[] chars){
        char temp;
        while (left<right){
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
