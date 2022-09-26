//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// Related Topics 哈希表 字符串 排序 👍 668 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {

        //如果出现unicode的话用hash map 替换
//        Map<Character,Integer> sMap = new HashMap();
        //本题中说明只有小写字母
        int[] record = new int[26];
        if (s.length()!=t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            //不需要知道字母在ascII中的具体位置只需要相对下标就行
            record[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            //与s的抵消当抵消到每个字符的计数都为0时就能证明时异位词
            record[t.charAt(i)-'a']--;
        }
        for (int i : record) {
            if (i!=0){
                return false;
            }
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
