

/**
 * @author Yinpeng.Lin
 * @see <a href="从英文中重建数字">https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/</a>
 * @date Created in 2021/11/24 16:05
 */
public class LeetCode423 {

    /**
     * 字母	数字
     * e	0 1 3 5 7 8 9
     * f	4 5
     * g	8
     * h	3 8
     * i	5 6 8 9
     * n	1 7 9
     * o	0 1 2 4
     * r	0 3 4
     * s	6 7
     * t	2 3 8
     * u	4
     * v	5 7
     * w	2
     * x	6
     * z	0
     */
    // public String originalDigits(String s) {
    //     // 统计每个字符出现的次数，因为题目限定只会出现 15 个字符，所以使用 Map 相比较数组更省内存
    //     Map<Character, Integer> statisticsMap = new HashMap<>();
    //     char[] chars = s.toCharArray();
    //     for (int index = 0; index < chars.length; index++) {
    //         char c = chars[index];
    //         statisticsMap.put(c, statisticsMap.getOrDefault(c, 0) + 1);
    //     }
    //     // 每个元素存储对应的数字的个数，比如 cnt[0] 表示数字 0 出现的次数，cnt[1] 表示数字 1 出现的次数，依次类推
    //     int[] cnt = new int[10];
    //
    //     // 获取仅在一个数字中出现的字母的次数，即对应数字出现的次数
    //     cnt[0] = statisticsMap.getOrDefault('z', 0);
    //     cnt[2] = statisticsMap.getOrDefault('w', 0);
    //     cnt[4] = statisticsMap.getOrDefault('u', 0);
    //     cnt[6] = statisticsMap.getOrDefault('x', 0);
    //     cnt[8] = statisticsMap.getOrDefault('g', 0);
    //     cnt[3] = statisticsMap.getOrDefault('h', 0) - cnt[8];
    //     cnt[7] = statisticsMap.getOrDefault('s', 0) - cnt[6];
    //     cnt[5] = statisticsMap.getOrDefault('f', 0) - cnt[4];
    //     cnt[1] = statisticsMap.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];
    //     cnt[9] = statisticsMap.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];
    //
    //     // 筛选出现次数非 0 的字符拼装字符串输出（字符串拼接时，直接使用 String 对象相加比较耗时、消耗更多内存，因为String对象不可变，每次新建一个对象，并将字符数组拷贝过来）
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < cnt.length; i++) {
    //         if (cnt[i] == 0) {
    //             continue;
    //         }
    //         for (int j = 0; j < cnt[i]; j++) {
    //             sb.append(i);
    //         }
    //     }
    //     return sb.toString();
    // }

    public String originalDigits(String s) {
        // 统计每个字符出现的次数，将字符转换成 ASCII，使用数组存储出现的次数。数组效率更高，运行时间更短，但因为题目限定只会出现 15 个字符，所以使用 Map 相比较数组更省内存；最大字符 z 对应的 ASCII 为 122
        int[] statisticsArray = new int[123];
        char[] chars = s.toCharArray();
        for (int index = 0; index < chars.length; index++) {
            byte c = (byte) chars[index];
            statisticsArray[c] = statisticsArray[c] + 1;
        }
        // 每个元素存储对应的数字的个数，比如 cnt[0] 表示数字 0 出现的次数，cnt[1] 表示数字 1 出现的次数，依次类推
        int[] cnt = new int[10];

        // 获取仅在一个数字中出现的字母的次数，即对应数字出现的次数
        cnt[0] = statisticsArray[((byte)'z')];
        cnt[2] = statisticsArray[((byte)'w')];
        cnt[4] = statisticsArray[((byte)'u')];
        cnt[6] = statisticsArray[((byte)'x')];
        cnt[8] = statisticsArray[((byte)'g')];
        cnt[3] = statisticsArray[((byte)'h')] - cnt[8];
        cnt[7] = statisticsArray[((byte)'s')] - cnt[6];
        cnt[5] = statisticsArray[((byte)'f')] - cnt[4];
        cnt[1] = statisticsArray[((byte)'o')] - cnt[0] - cnt[2] - cnt[4];
        cnt[9] = statisticsArray[((byte)'i')] - cnt[5] - cnt[6] - cnt[8];

        // 筛选出现次数非 0 的字符拼装字符串输出（字符串拼接时，直接使用 String 对象相加比较耗时、消耗更多内存，因为String对象不可变，每次新建一个对象，并将字符数组拷贝过来）
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            for (int j = 0; j < cnt[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println('z');
    }

}
