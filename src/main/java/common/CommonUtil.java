package common;

/**
 * @author Yinpeng.Lin
 * @desc 工具类
 * @date Created in 2021/11/5 17:27
 */
public class CommonUtil {

    /**
     * 打印链表
     *
     * @param head
     */
    public static void printListNode(ListNode head) {
        StringBuilder sb = new StringBuilder("打印链表：");
        if (head == null) {
            sb.append("NULL");
        } else {
            ListNode temp = head;
            while (temp != null) {
                sb.append(temp.val);
                temp = temp.next;
            }
        }
        System.out.println(sb.toString());
    }

    /**
     * 打印数组
     *
     * @param array
     */
    public static void printArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder("打印数组：");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i] + ",");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

}
