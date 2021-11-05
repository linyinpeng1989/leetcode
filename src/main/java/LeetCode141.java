import common.ListNode;

/**
 * @author Yinpeng.Lin
 * @see <a href="环形链表">https://leetcode-cn.com/problems/linked-list-cycle/</a>
 * @date Created in 2021/11/4 14:50
 */
public class LeetCode141 {

    /**
     * 判断是否有环：使用快、慢两个指针遍历链表，如果链表遍历完之前相遇，则存在环。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        // 快速节点为空，或快速节点的下一个节点为空时，则链表遍历结束
        // 如果存在环，则在遍历完成之前，两个指针必然会相遇
        while (fastNode != null && fastNode.next != null) {
            // 先各自移位
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            // 判断是否相遇
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
    }

}
