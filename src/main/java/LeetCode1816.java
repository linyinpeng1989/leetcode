/**
 * @author Yinpeng.Lin
 * @see <a href="截断句子">https://leetcode-cn.com/problems/truncate-sentence/</a>
 * @date Created in 2021/12/6 10:31
 */
public class LeetCode1816 {

    public String truncateSentence(String s, int k) {
        int countSpace = 0;
        int endIndex = 0;
        while (countSpace++ != k) {
            endIndex = s.indexOf(" ", endIndex + 1);
        }
        if (endIndex == -1) {
            endIndex = s.length();
        }

        return s.substring(0, endIndex);
    }

    public static void main(String[] args) {
        LeetCode1816 leetCode1816 = new LeetCode1816();
        // System.out.println(leetCode1816.truncateSentence("Hello how are you Contestant", 4));
        // System.out.println(leetCode1816.truncateSentence("What is the solution to this problem", 4));
        System.out.println(leetCode1816.truncateSentence("chopper is not a tanuki", 5));
    }

}
