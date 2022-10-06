## [剑指offer 05.替换空格](https://leetcode.cn/problems/ti-huan-kong-ge-lcof/)

### 通过复制字符串的方式
#### 思路
1. 创建一个StringBuilder,然后遍历字符串,遇见空格就在后面拼接%20

- 时间复杂度O(n)
- 空间复杂度O(n)

```java
class Solution {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]==' '){
                sb.append("%20");
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
```

### 通过双指针的方式

1. 首先创建字符串长度为空格数,然后空格数乘以3拼接到原来的字符串中
2. 然后定义左右双指针分别指向原来字符串末端和新字符串末端
3. 从后向前遍历左指针遇到非空字符放到右指针,遇到空字符,右指针向前填充%20就这样直至结束

```java
class Solution {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                stringBuilder.append("  ");
            }
        }
        int left = s.length()-1;
        s+=stringBuilder.toString();
        int right = s.length()-1;
        char[] chars = s.toCharArray();
        while (left>=0){
            System.out.println(left +"->"+right+" "+ chars[left]);
            if (chars[left]==' '){
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            }else {
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }
```
