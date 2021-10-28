

/**
 * @author Yinpeng.Lin
 * @see <a href="无重复字符的最长子串">https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/</a>
 * @date Created in 2021/10/27 10:13
 */
public class LeetCode3 {

    // 使用 HashMap 记录字符出现位置，65 ms，39MB
    // public int lengthOfLongestSubstring(String s) {
    //     if (s == null) {
    //         return 0;
    //     }
    //
    //     // 最大子串长度
    //     int maxLength = 0;
    //
    //     // 当前子串起始、截止下标
    //     int currStartIndex = 0;
    //     int currEndIndex = 0;
    //
    //     // 缓存字符和下标映射关系
    //     Map<Character, Integer> map = new HashMap<>();
    //     while (currEndIndex < s.length()) {
    //         Character c = s.charAt(currEndIndex);
    //         Integer mapIndex = map.get(c);
    //         // 存在重复情况
    //         if (mapIndex != null) {
    //             // 如果最大子串变更，则更新最大子串的起始、截止下标
    //             maxLength = Math.max(maxLength, currEndIndex - currStartIndex);
    //
    //             // 重新设置扫描的坐标
    //             currStartIndex = currEndIndex = ++mapIndex;
    //             map.clear();
    //             continue;
    //         }
    //         // 设置映射关系，更新同一字符的下标
    //         map.put(c, currEndIndex);
    //         currEndIndex++;
    //     }
    //     // 可能最后一次扫描没有碰到重复的情况，所以 maxLength 没有更新，因此取最大值即可
    //     return Math.max(maxLength, currEndIndex - currStartIndex);
    // }

    // 将字符转换成对应的 ASCII 码，使用 int[] 记录字符出现位置，2ms，38.5MB
    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置。初始元素均为 -1，因为 0 也是 ASCII 码中的一个元素。ASCII 码目前总共定义了 128 个字符。
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }

        // 记录最大子串的长度
        int res = 0;
        // 窗口开始位置
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            // 将对应字符转化成对应的 ASCII 码
            int index = s.charAt(i);
            // 若未出现重复情况，last[index] 元素值初始为 -1，而 last[index] + 1 即表示窗口开始位置为第一个位置，即 0；
            // 当出现重复的情况时，last[index] 元素值会被设置成上一次出现该字符的位置，而 last[index] + 1 即表示窗口开始位置
            // 变成了当前字符上一次出现位置的下一个位置，比如 “abcabcdde”，当扫描到第 4 个字符 'a' 时，last[3] 中保存了上一次
            // 出现字符 'a' 的位置 0，则下一个窗口开始位置 last[3] + 1 即表示从第 2 个字符 'b' 开始扫描。
            // PS：将字符转换成 ASCII 码后，即可用数组保存上一次字符出现的位置并通过下标直接访问，而不需要使用 Map，节省了运行时间和空间占用。
            start = Math.max(start, last[index] + 1);

            // res 表示目前记录的最大子串长度，i - start + 1 表示当前扫描窗口的子串长度
            res   = Math.max(res, i - start + 1);

            // 记录字符上一次出现的位置
            last[index] = i;
        }

        return res;
    }


    public static void main(String[] args) {
        LeetCode3 leetCode = new LeetCode3();
        System.out.println(leetCode.lengthOfLongestSubstring("abcabcabcaaa"));
    }

}
