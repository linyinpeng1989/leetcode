import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yinpeng.Lin
 * @see <a href="拥有最多糖果的孩子">https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/</a>
 * @date Created in 2021/10/27 9:55
 */
public class LeetCode1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 拷贝数组，并对数组进行排序，获取最大数值
        int[] tempArray = Arrays.copyOf(candies, candies.length);
        Arrays.sort(tempArray);
        int max = tempArray[tempArray.length - 1];

        // 遍历数组，若数组元素值 + extraCandies > 最大值max 即为true，否则为false
        List<Boolean> result = new ArrayList<>(candies.length);
        for (int index = 0; index < candies.length; index++) {
            Boolean compareResult = candies[index] + extraCandies >= max;
            result.add(compareResult);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1431 leetCode = new LeetCode1431();
        int[] candies = new int[]{2,3,5,1,3};
        List<Boolean> result = leetCode.kidsWithCandies(candies, 3);
        System.out.println(result);
    }

}
