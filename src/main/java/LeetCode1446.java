/**
 * @author Yinpeng.Lin
 * @see <a href="连续字符">https://leetcode-cn.com/problems/consecutive-characters/</a>
 * @date Created in 2021/12/1 9:50
 */
public class LeetCode1446 {

    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        char cur = chars[0];
        int count= 1;
        int maxCount = 0;
        for (int i = 1; i < chars.length; i++) {
            if (cur == chars[i]) {
                count++;
                continue;
            }
            // 取较大值
            maxCount = Math.max(maxCount, count);

            // 还原 count 和 cur的值
            count = 1;
            cur = chars[i];
        }
        // 取较大值，避免 cc 这种后缀是最大子串的情况，导致没取较大值
        return Math.max(maxCount, count);
    }

    public static void main(String[] args) {
        LeetCode1446 leetCode1446 = new LeetCode1446();
        System.out.println(leetCode1446.maxPower("abbcccddddeeeeedcba"));
        System.out.println(leetCode1446.maxPower("cc"));
    }

}
