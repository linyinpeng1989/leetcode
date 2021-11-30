import common.CommonUtil;
import common.ListNode;

/**
 * @author Yinpeng.Lin
 * @see <a href="链表的中间结点">https://leetcode-cn.com/problems/middle-of-the-linked-list/</a>
 * @date Created in 2021/11/5 17:35
 */
public class LeetCode876 {

    public ListNode middleNode(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        // 使用快、慢两个指针，遍历链表
        // 奇数节点时，fastNode.next == null 条件触发结束遍历，此时 slowNode 即为中间点
        // 偶数节点时，fastNode == null 条件触发结束遍历，此时 slowNode 即为中间点（若有两个中间点，则返回第二个中间点）
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    public static void main(String[] args) {
        LeetCode876 leetCode876 = new LeetCode876();

        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode header = new ListNode(1, node2);
        CommonUtil.printListNode(header);
        ListNode listNode = leetCode876.middleNode(header);
        CommonUtil.printListNode(listNode);

    }

}
