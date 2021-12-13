import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author Yinpeng.Lin
 * @see <a href="字母异位词分组">https://leetcode-cn.com/problems/group-anagrams/</a>
 * @date Created in 2021/12/2 16:55
 */
public class LeetCode49 {

    /**
     * 字符串转换成字符数组并排序
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String mapKey = new String(chars);
            List<String> orDefault = map.getOrDefault(mapKey, new ArrayList<>());
            orDefault.add(str);
            map.put(mapKey, orDefault);
        }
       return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        LeetCode49 leetCode49 = new LeetCode49();
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = leetCode49.groupAnagrams(arr);
        System.out.println(JSON.toJSONString(lists));
    }

}
