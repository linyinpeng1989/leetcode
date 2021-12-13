import common.CommonUtil;
import common.ListNode;

/**
 * @author Yinpeng.Lin
 * @see <a href="对链表进行插入排序">https://leetcode-cn.com/problems/insertion-sort-list/</a>
 * @date Created in 2021/12/7 14:24
 */
public class LeetCode147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        // 定义哨兵节点，方便后续处理
        ListNode sentinelNode = new ListNode(0, head);

        // 从第二个节点开始算无序队列
        ListNode currNode = head.next;

        // 断开有序部分与无序部分连接
        head.next = null;

        // 开始遍历
        while (currNode != null) {
            // 下一个需要排序的节点
            ListNode tempNode = currNode.next;

            ListNode comNode = sentinelNode.next;
            ListNode comPredNode = sentinelNode;
            while (comNode != null) {
                // 中间插入场景
                if (comNode.val > currNode.val) {
                    currNode.next = comNode;
                    comPredNode.next = currNode;
                    break;
                }
                comPredNode = comNode;
                comNode = comNode.next;
            }

            // 尾部插入的情况
            if (comNode == null) {
                comPredNode.next = currNode;
                currNode.next = null;
            }
            currNode = tempNode;
        }
        return sentinelNode.next;
    }

    public static void main(String[] args) {
        LeetCode147 leetCode147 = new LeetCode147();
        // ListNode node6 = new ListNode(1);
        // ListNode node5 = new ListNode(2, node6);
        // ListNode node4 = new ListNode(3, node5);
        // ListNode node3 = new ListNode(4, node4);
        // ListNode node2 = new ListNode(5, node3);
        // ListNode header = new ListNode(6, node2);

        ListNode node5 = new ListNode(0);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(5, node3);
        ListNode header = new ListNode(-1, node2);

        ListNode listNode = leetCode147.insertionSortList(header);
        CommonUtil.printListNode(listNode);
    }

}
